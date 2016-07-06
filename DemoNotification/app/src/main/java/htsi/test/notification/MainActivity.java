package htsi.test.notification;

import java.util.Calendar;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	public static final String NOTIFICATION_DATA = "NOTIFICATION_DATA";	
	private Button createNotify;
	private EditText notificationData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		createNotify = (Button)findViewById(R.id.btnCreate);
		notificationData = (EditText)findViewById(R.id.editData);
		createNotify.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				createNotification(Calendar.getInstance().getTimeInMillis(), 
						notificationData.getText().toString());
			}
		});
	}
	
	private void createNotification(long when, String data){
		
		String notificationContent = "Nội dung: Nhấn để xem chi tiết";
		String notificationTitle = "Thông báo mới";
		
		Bitmap largeIcon = BitmapFactory.
				decodeResource(getResources(), R.drawable.ic_launcher);
		int smallIcon = R.drawable.ic_launcher;
		String notificationData = "Nội dung thông báo: " + data;
		
		Intent intent = new Intent
				(getApplicationContext(), NotificationDetails.class);
		intent.putExtra(NOTIFICATION_DATA, notificationData);
		
		intent.setData(Uri.parse("content://"+when));
		PendingIntent pendingIntent = PendingIntent.getActivity
				(getApplicationContext(), 0, 
						intent, Intent.FLAG_ACTIVITY_NEW_TASK);
		
		NotificationManager notificationManager = (NotificationManager) 
				getSystemService(Context.NOTIFICATION_SERVICE);
		
		NotificationCompat.Builder builder; 
		builder = new Builder(getApplicationContext());
		builder.setWhen(when)
				.setContentText(notificationContent)
				.setContentTitle(notificationTitle)
				.setSmallIcon(smallIcon)
				.setAutoCancel(true)
				.setTicker(notificationTitle)
				.setLargeIcon(largeIcon)
				.setDefaults(Notification.DEFAULT_LIGHTS | 
							Notification.DEFAULT_SOUND | 
							Notification.DEFAULT_VIBRATE)
				.setContentIntent(pendingIntent);
		
		Notification notification = builder.build();
		
		notificationManager.notify((int)when, notification);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
