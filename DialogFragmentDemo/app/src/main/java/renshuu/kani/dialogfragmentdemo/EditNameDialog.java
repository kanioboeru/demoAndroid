package renshuu.kani.dialogfragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

/**
 * Created by hungnm on 16/07/06.
 */
public class EditNameDialog extends DialogFragment implements TextView.OnEditorActionListener{
    private EditText mEditText;

    public interface EditNameDialgoListener{
        void onFinishEditDialog(String inputText);
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_layout,container);

        mEditText = (EditText) view.findViewById(R.id.txt_name);
        getDialog().setTitle("Hello");

        //フォカスト
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {

        if(EditorInfo.IME_ACTION_DONE == actionId){
            EditNameDialgoListener activity = (EditNameDialgoListener) getActivity();
            activity.onFinishEditDialog(mEditText.getText().toString());
            this.dismiss();
            return true;
        }
        return false;
    }
}
