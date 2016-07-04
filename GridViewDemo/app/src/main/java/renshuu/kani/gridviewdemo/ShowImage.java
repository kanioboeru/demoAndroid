package renshuu.kani.gridviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

/**
 * Created by hungnm on 16/07/04.
 */
public class ShowImage extends Activity implements View.OnTouchListener {
    public static final String TAG = ShowImage.class.getName();

    ViewFlipper viewFlipper;
    float downX = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_image_layout);

        Intent intent = getIntent();
        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);

        for (int i =0; i< GridViewDemo.images.length;i++){
            ImageView imgView = new ImageView(this);
            imgView.setImageDrawable(getResources().getDrawable(GridViewDemo.images[i]));
            viewFlipper.addView(imgView);
        }

        Log.d(TAG,"intent.getExtras().getInt(Position)= "+intent.getExtras().getInt("Position"));
        viewFlipper.setDisplayedChild(intent.getExtras().getInt("Position",0));
      //  viewFlipper.setDisplayedChild(intent.getExtras().getInt());
        viewFlipper.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d(TAG,"motionEvent.getAction = "+ motionEvent.getAction());
        Log.d(TAG,"downX = "+ downX);
        Log.d(TAG,"upX = "+ motionEvent.getX());

        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_UP:
                downX = motionEvent.getX();
                break;
            case MotionEvent.ACTION_DOWN:
                float upX = motionEvent.getX();
                if(upX<downX){
                    viewFlipper.showNext();
                }else if(upX>downX){
                    viewFlipper.showPrevious();
                }

                break;
        }
        return false;
    }
}
