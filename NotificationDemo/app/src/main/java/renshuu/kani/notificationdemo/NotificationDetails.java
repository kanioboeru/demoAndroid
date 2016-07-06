package renshuu.kani.notificationdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by hungnm on 16/07/06.
 */
public class NotificationDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView txtData = new TextView(this);
        setContentView(txtData);

        Intent intent = getIntent();
        String data = intent.getExtras().getString(NotificationActivity.NOTIFICATION_DATA);
        txtData.setText(data);
    }
}
