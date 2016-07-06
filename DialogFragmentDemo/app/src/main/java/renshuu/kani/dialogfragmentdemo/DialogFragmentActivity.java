package renshuu.kani.dialogfragmentdemo;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DialogFragmentActivity extends FragmentActivity implements EditNameDialog.EditNameDialgoListener {

    TextView txtHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);

        txtHello = (TextView) findViewById(R.id.txt_name);
        Button btnInput = (Button) findViewById(R.id.btnInput);
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEditDialog();
            }
        });

    }

    private void showEditDialog(){
        FragmentManager fm = getSupportFragmentManager();
        EditNameDialog editNameDialog = new EditNameDialog();
        editNameDialog.show(fm,"fragment_edit_name");
    }

    @Override
    public void onFinishEditDialog(String inputText) {
        txtHello.setText("Hello "+ inputText);
    }
}
