package renshuu.kani.demo5;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnClick;
    ImageView imgAnh;
    RelativeLayout relativeLayout;

    Button btnPlay, btnPause;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = (Button) findViewById(R.id.buttonClick);
        imgAnh = (ImageView) findViewById(R.id.imageView);
        relativeLayout = (RelativeLayout) findViewById(R.id.background);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPause = (Button) findViewById(R.id.btnPause);

        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.test1full);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAnh.setImageResource(R.drawable.cupcake);
                relativeLayout.setBackgroundResource(R.drawable.donut);
                Toast thonbao;
                thonbao = Toast.makeText(MainActivity.this,"こんにちは",Toast.LENGTH_LONG);
                thonbao.setGravity(Gravity.CENTER_VERTICAL|Gravity.CLIP_HORIZONTAL,0,0);
                thonbao.show();
            }
        });
    }
}
