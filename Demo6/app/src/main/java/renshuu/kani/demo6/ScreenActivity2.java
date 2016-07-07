package renshuu.kani.demo6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScreenActivity2 extends AppCompatActivity {

    Button btnScreen2;
    TextView txtName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        Intent intent1 = getIntent();
//        intent1.getExtras().get()
        btnScreen2 = (Button) findViewById(R.id.btnScreeen2);
        txtName = (TextView) findViewById(R.id.txtName);
        txtName.setText(intent1.getExtras().getString("Name"));
        btnScreen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScreenActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
