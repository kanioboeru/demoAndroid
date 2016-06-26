package com.example.hungnm.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

/**
 * Created by hungnm on 16/06/26.
 */
public class EditActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit,menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }
}

