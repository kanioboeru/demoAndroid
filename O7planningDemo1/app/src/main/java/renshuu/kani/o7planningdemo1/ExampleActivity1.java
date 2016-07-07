package renshuu.kani.o7planningdemo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExampleActivity1 extends AppCompatActivity {

    TextView largeText;
    TextView smallText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);

        //データを反映する
        showData();
        btnEvent();
    }

    private void showData(){
        Intent intentEx1 = getIntent();
        //大きいテキスト
        String largeTxt = intentEx1.getStringExtra("text2");
        //小さいテキスト
        String smallTxt = intentEx1.getStringExtra("text1");

         largeText = (TextView) findViewById(R.id.my_large_text);
         smallText = (TextView) findViewById(R.id.my_medium_text);

        largeText.setText(largeTxt);
        smallText.setText(smallTxt);

    }

    private void btnEvent(){
        Button button = (Button) findViewById(R.id.my_btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smallText.setText("長押しボタンをクリックする");
            }
        });
    }

}
