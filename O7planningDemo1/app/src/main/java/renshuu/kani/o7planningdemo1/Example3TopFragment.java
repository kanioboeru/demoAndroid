package renshuu.kani.o7planningdemo1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by hungnm on 16/07/10.
 */
public class Example3TopFragment extends Fragment {

    private EditText inputTopImageText,inputBottomImageText;
    private ExampleActivity3 exampleActivity3;

    public Example3TopFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
//        View view = inflater.inflate((R.layout.activity_example3_top,container,false);
        View view = inflater.inflate(R.layout.activity_example3_top,container,false);

        inputTopImageText = (EditText) view.findViewById(R.id.input_top_image_text);
        inputBottomImageText = (EditText) view.findViewById(R.id.input_bottom_image_text);

        Button applyButton = (Button) view.findViewById(R.id.btn_apply);

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyText();
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ExampleActivity3){
            this.exampleActivity3 = (ExampleActivity3) context;
        }
    }

    private  void applyText(){
        String topText = this.inputTopImageText.getText().toString();
        String bottomText = this.inputBottomImageText.getText().toString();

        this.exampleActivity3.showText(topText,bottomText);
    }
}
