package renshuu.kani.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class NotificationActivity extends AppCompatActivity {

    public static final String NOTIFICATION_DATA = "NOTIFICATION_DATA";
    private Button createNofity;
    private EditText notificationData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        createNofity = (Button) findViewById(R.id.button);
        notificationData = (EditText) findViewById(R.id.textView);

        createNofity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                createNotification(Calendar.getInstance().getTimeInMillis(),notificationData.getText().toString());
            }
        });
    }

    private void createNotification(long when,String data){
        String notificationContent="NOi dung: Nhan xem chi tiet";
        String notificationTitle = "Thong bao moi";

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        int smallIcon = R.mipmap.ic_launcher;
        String nofiticationData = "Noi dung thong bao "+data;
        Intent intent = new Intent(getApplicationContext(),NotificationDetails.class);
        intent.putExtra(NOTIFICATION_DATA,nofiticationData);

        intent.setData(Uri.parse("content://"+when));
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,Intent.FLAG_ACTIVITY_NEW_TASK);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder;
        builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setWhen(when).setContentText(notificationContent).setContentTitle(notificationTitle)
                .setSmallIcon(smallIcon).setAutoCancel(true).setTicker(notificationTitle)
                .setLargeIcon(largeIcon).setDefaults(Notification.DEFAULT_LIGHTS| Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                .setContentIntent(pendingIntent);

        Notification notification = builder.build();
        notificationManager.notify((int)when,notification);

    }
}
