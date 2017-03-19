package pom.lekar.myservise;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by lekar on 19.03.17.
 */

public class Broad extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
     if (intent.equals("Timur")) Toast.makeText(context,"fuck Off",Toast.LENGTH_SHORT).show();
        else Toast.makeText(context,"Roma fuck Off",Toast.LENGTH_SHORT).show();
    }
}
