package pom.lekar.myservise;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by lekar on 19.03.17.
 */

public class MyServise extends Service
{

    @Override
    public IBinder onBind(Intent intent) { return null; }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        sendNotif();
        sendBroadcast(new Intent().setAction("Timur"));

        return super.onStartCommand(intent, flags, startId);
    }

    public  void sendNotif(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException mE) {
            mE.printStackTrace();
        }

        int NOTIFI_ID = 101;// указывает уникальность нотификэйшена для данного приложения
        Context context =this;
        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);//PendingIntent тот интент на который мы будет переходить при нажатии на уведомление
        //PendingIntent.FLAG_CANCEL_CURRENT - если наш PendingIntent ранее уже был создан, то он должен отмениться чтобы сгенерировать новый
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);//получаем обьект NotificationManager
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentIntent(contentIntent)//с помощью builder можно построить наше уведомление указать картинку и какието данные в уведомлении
                .setSmallIcon(R.mipmap.ic_launcher)//иконка уведомления
                .setWhen(System.currentTimeMillis())//время прихода уведомления
                .setContentTitle("Servidufhwiufice")//текст в уведомлении
                .setContentText("Service uiinfiweufcStart")
                .setAutoCancel(true);//Notyfication - остается висеть после его нажатия если false
        Notification notification = builder.build();
        nm.notify(NOTIFI_ID, notification);

        //sendBroadcast(new Intent().setAction("Timur"));
    }
    
}
