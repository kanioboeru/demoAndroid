package renshuu.kani.o7planningdemo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ボタンを反映する
        buttonCall();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //インテントを作成して、データをExampleアクティビティに送る
                Intent intentBtn1 = new Intent(MainActivity.this,ExampleActivity1.class);
                //データを送る
                intentBtn1.putExtra("text1","This is text");
                intentBtn1.putExtra("text2","This is long text");

                MainActivity.this.startActivity(intentBtn1);

            }
        });


    }

    private void buttonCall(){
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);

    }
}
