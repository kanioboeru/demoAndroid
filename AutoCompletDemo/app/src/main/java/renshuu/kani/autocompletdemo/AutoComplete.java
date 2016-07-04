package renshuu.kani.autocompletdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoComplete extends AppCompatActivity {

    private String[] COUNTRIES ={"Belgium","Canada","Colombia","France","Italy","Vietnam"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
        multiAutoCompleteTextView.setThreshold(1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item_layout,COUNTRIES);
        autoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
