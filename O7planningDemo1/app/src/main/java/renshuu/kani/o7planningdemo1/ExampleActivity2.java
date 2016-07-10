package renshuu.kani.o7planningdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ExampleActivity2 extends AppCompatActivity {

    private TextView textEvt1,textEvt2;
    private TextView txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12;

    private static final String TAG = "TestGesture";

    //ユーザーの操作を検出する
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        setObject();

        GestureDetector.OnGestureListener gestureListener = new MyOnGestureListener();
        GestureDetector.OnDoubleTapListener doubleTapListener = new MyOnDoubleTabListener();

        this.gestureDetector = new GestureDetector(this,gestureListener);
        this.gestureDetector.setOnDoubleTapListener(doubleTapListener);

        //View goc
        View rootView = this.findViewById(android.R.id.content).getRootView();
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
        });

        Log.d(TAG,"Running ...");
    }

    private void setObject(){
        textEvt1 = (TextView) findViewById(R.id.my_text_evt1);
        textEvt2 = (TextView) findViewById(R.id.my_text_evt2);
        txt3 = (TextView) findViewById(R.id.onLongPressTxt1);
        txt4 = (TextView) findViewById(R.id.onLongPressTxt2);
        txt5 = (TextView) findViewById(R.id.onSingleTapUpTxt1);
        txt6 = (TextView) findViewById(R.id.onSingleTapUpTxt2);
        txt7 = (TextView) findViewById(R.id.onDownTxt1);
        txt8 = (TextView) findViewById(R.id.onDownTxt2);
        txt9 = (TextView) findViewById(R.id.onShowPressTxt1);
        txt10 = (TextView) findViewById(R.id.onShowPressTxt2);

    }

    class MyOnGestureListener implements GestureDetector.OnGestureListener{

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            textEvt1.setText("onFling");
            textEvt2.setText("motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY()
            +"motionEvent1.getX() = " + motionEvent1.getX() + " motionEvent1.getY() = "+motionEvent1.getY());
            Log.d(TAG,"onFling");
            Log.d(TAG,"motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY()
                    +"motionEvent1.getX() = " + motionEvent1.getX() + " motionEvent1.getY() = "+motionEvent1.getY());

            return true;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            txt3.setText("onLongPress");
            txt4.setText("motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());
            Log.d(TAG,"onLongPress");
            Log.d(TAG,"motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());

        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            txt5.setText("onSingleTapUp");
            txt6.setText("motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());
            Log.d(TAG,"onSingleTapUp");
            Log.d(TAG,"motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());

            return true;
        }

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            txt7.setText("onDown");
            txt8.setText("motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());
            Log.d(TAG,"onDown");
            Log.d(TAG,"motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());
            return true;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            txt9.setText("onShowPress");
            txt10.setText("motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());
            Log.d(TAG,"onShowPress");
            Log.d(TAG,"motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());

        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            textEvt1.setText("onScroll");
            textEvt2.setText("motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY()
                    +"motionEvent1.getX() = " + motionEvent1.getX() + " motionEvent1.getY() = "+motionEvent1.getY());
            Log.d(TAG,"onScroll");
            Log.d(TAG,"motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY()
                    +"motionEvent1.getX() = " + motionEvent1.getX() + " motionEvent1.getY() = "+motionEvent1.getY());
            return true;
        }
    }

    class MyOnDoubleTabListener implements GestureDetector.OnDoubleTapListener{
        @Override
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            textEvt1.setText("onSingleTapConfirmed");
            textEvt2.setText("motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());
            Log.d(TAG,"onSingleTapConfirmed");
            Log.d(TAG,"motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());
            Log.d(TAG,"onSingleTapConfirmed");
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent motionEvent) {
            textEvt1.setText("onDoubleTap");
            textEvt2.setText("motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());
            Log.d(TAG,"onDoubleTap");
            Log.d(TAG,"motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            textEvt1.setText("onDoubleTapEvent");
            textEvt2.setText("motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());
            Log.d(TAG,"onDoubleTapEvent");
            Log.d(TAG,"motionEvent.getX() = " + motionEvent.getX() + " motionEvent.getY() = "+motionEvent.getY());
            return true;
        }
    }
}
