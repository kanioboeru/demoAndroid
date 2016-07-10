package renshuu.kani.o7planningdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExampleActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example3);
    }

    public void showText(String topImageText,String bottomImageText){
        Example3BottomFragment example3BottomFragment = (Example3BottomFragment)
                this.getSupportFragmentManager().findFragmentById(R.id.example3_bottom_fragment);

        example3BottomFragment.showText(topImageText,bottomImageText);
    }
}
