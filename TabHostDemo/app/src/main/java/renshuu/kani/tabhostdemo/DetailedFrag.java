package renshuu.kani.tabhostdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hungnm on 16/07/05.
 */
public class DetailedFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        if(container == null){
            return null;
        }else {
             return inflater.inflate(R.layout.detailed,container,false);
        }
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button button = (Button)  getActivity().findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"詳細fragment",Toast.LENGTH_LONG).show();
            }
        });

        LinearLayout layout = (LinearLayout) getActivity().findViewById(R.id.my_inner_layout);
        layout.addView(createView());
    }

    public TextView createView(){
        TextView view = new TextView(getActivity());
        view.setText("テキストビューを作成する");
        return view;
    }
}
