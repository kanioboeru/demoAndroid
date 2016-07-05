package renshuu.kani.fragmentviewpagerdemo;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hungnm on 16/07/05.
 */
public class MyFragment extends Fragment {

    String nameFragment;

    public  MyFragment(String nameFragment){
        this.nameFragment = nameFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_layout,container,false);
        TextView textView = (TextView) view.findViewById(R.id.textView1);
        textView.setText(nameFragment);
        return view;

    }
}
