package renshuu.kani.tabhostdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hungnm on 16/07/05.
 */
public class SimpleFrag extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        if (container==null){
            return null;
        }else {
            return inflater.inflate(R.layout.simple,container,false);
        }
    }
}
