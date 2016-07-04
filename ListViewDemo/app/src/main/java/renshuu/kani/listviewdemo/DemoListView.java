package renshuu.kani.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class DemoListView extends AppCompatActivity {
    private static final String TAG = DemoListView.class.getName();

    EditText editNode;
    ListView listNode;
    ArrayList<String> notes;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_list_view);
        editNode = (EditText) findViewById(R.id.editNote);
        listNode = (ListView) findViewById(R.id.listNode);
        notes = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.items_note,notes);
        listNode.setAdapter(adapter);

        editNode.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                Log.d(TAG,"onKey keyCode = "+keyCode);
                Log.d(TAG,"onKey KeyEvent = "+keyEvent.getAction());
                if(keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction()==KeyEvent.ACTION_DOWN ){
                    Log.d(TAG,"if true");
                    String note = editNode.getText().toString();
                    notes.add(note);
                    Log.d(TAG,"notes.size = "+notes.size());
                    adapter.notifyDataSetChanged();
                    editNode.getText().clear();
                }
                return false;
            }
        });
    }
}
