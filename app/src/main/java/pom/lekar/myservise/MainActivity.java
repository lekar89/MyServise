package pom.lekar.myservise;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button         mButton;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.btn_start_notif);
        mButton.  setOnClickListener(this);
        MyREc     myREc = new MyREc();
        IntentFilter filter = new IntentFilter();

        filter.addAction("Timur");
        registerReceiver(myREc,filter);
    }


    @Override
    public void onClick(View v) { startService(new Intent(this,MyServise.class));  }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver( new MyREc());
    }

    public class MyREc extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            relativeLayout =(RelativeLayout)findViewById(R.id.activity_main);
            relativeLayout.setBackgroundColor(Color.RED);
        }
    }
}
