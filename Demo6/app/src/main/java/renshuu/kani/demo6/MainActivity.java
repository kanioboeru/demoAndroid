package renshuu.kani.demo6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnSelect;
    Button btnScreen;
    EditText editText;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textViewShow);
        btnSelect = (Button) findViewById(R.id.btnSelect);

        btnScreen = (Button) findViewById(R.id.btnScreen1);
        editText = (EditText) findViewById(R.id.editName);

        imageView = (ImageView) findViewById(R.id.imageView);

//        try {
//            URL path = new URL("http://www.androidbegin.com/wp-content/uploads/2013/07/ABS-FragmentTabHost-ScreenShot2.png");
//            Bitmap bmp = BitmapFactory.decodeStream(path.openConnection().getInputStream());
//            imageView.setImageBitmap(bmp);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException io){
//            io.printStackTrace();
//        }

        class LoadHinh extends AsyncTask<String,Integer,String>{

            @Override
            protected String doInBackground(String... strings) {

        try {
            URL path = new URL("https://www.google.com.vn/imgres?imgurl=http%3A%2F%2F4.bp.blogspot.com%2F-EDo1IZD9slc%2FVrL8ezba2SI%2FAAAAAAAAC1g%2FlgrrAfnp_Yw%2Fs640%2Fhoa-tu-dang-13.jpg&imgrefurl=http%3A%2F%2Fvemaybaycacnuoc.blogspot.com%2F2016%2F02%2Fhoa-tu-dang-tinh-yeu-bat-diet-va-niem-kieu-hanh.html&docid=spc2wK207YbFZM&tbnid=d2cst0Ffb0l0xM%3A&w=600&h=398&bih=673&biw=1360&ved=0ahUKEwj0-uei_97NAhWBaT4KHXl_CSYQMwg2KBUwFQ&iact=mrc&uact=8");
            Bitmap bmp = BitmapFactory.decodeStream(path.openConnection().getInputStream());
            imageView.setImageBitmap(bmp);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException io){
            io.printStackTrace();
        }

                return null;
            }
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new LoadHinh().execute();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int sc = r.nextInt(10);

                textView.setText(""+sc);
            }
        });

        btnScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ScreenActivity2.class);
                intent.putExtra("Name",editText.getText().toString());
                startActivity(intent);
            }
        });
    }
}
