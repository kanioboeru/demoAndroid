package renshuu.kani.o7planningdemo1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by hungnm on 16/07/10.
 */
public class Example3BottomFragment extends Fragment {

    private TextView topText,bottomText;

    public Example3BottomFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.activity_example3_bottom,container,false);

        topText = (TextView) view.findViewById(R.id.top_image_text);
        bottomText = (TextView) view.findViewById(R.id.bottom_image_text);


        return view;
    }

    public void showText (String topImageText,String bottomImageText){
        topText.setText(topImageText);
        bottomText.setText(bottomImageText);
    }
}
