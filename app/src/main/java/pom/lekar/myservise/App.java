package pom.lekar.myservise;

import android.app.Application;
import android.content.Intent;

/**
 * Created by lekar on 19.03.17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        //startService(new Intent(this,MyServise.class));
        super.onCreate();
    }
}
