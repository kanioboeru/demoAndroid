package htsi.test.notification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationDetails extends Activity {
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		TextView txtData = new TextView(this);
		setContentView(txtData);
		
		Intent intent = getIntent();
		String data = intent.getExtras().
				getString(MainActivity.NOTIFICATION_DATA);
		txtData.setText(data);
		
	}

}

