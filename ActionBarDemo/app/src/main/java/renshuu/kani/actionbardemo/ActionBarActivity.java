package renshuu.kani.actionbardemo;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActionBarActivity extends AppCompatActivity {

    private static final String TAG = ActionBarActivity.class.getName();

    ListView listView;
    ArrayList<Item> items;
    MyAdapter adapter;

    ActionMode.Callback callback;
    ActionMode actionMode;
//    ActionMode.Callback callback;
//    ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);

        items = new ArrayList<Item>();
        adapter = new MyAdapter(this,R.layout.item_layout,items);
        listView = (ListView) findViewById(R.id.listview1);
        listView.setAdapter(adapter);

        callback = new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                Log.d(TAG,"onCreateActionMode");
                getMenuInflater().inflate(R.menu.action_bar_menu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                Log.d(TAG,"onActionItemClicked");
                Log.d(TAG,"item.getItemId()= "+item.getItemId());
                switch (item.getItemId()){
                    case R.id.action_del :
                        for (int i = 0; i < items.size();i++){
                            if(items.get(i).isChecked()){
                                items.remove(i);
                                i= -1;
                            }
                        }
                        adapter.notifyDataSetChanged();
                        actionMode.finish();
                        actionMode = null;

                        break;
                    default:
                        break;
                }

                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        };
    }



    private class Item{
        private String content;

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }

        private boolean isChecked;
    }

    private class  MyAdapter extends ArrayAdapter<Item>{
        ArrayList<Item> items;
        int layout;

        public MyAdapter(Context context,int textViewResourceId, ArrayList<Item> objects){
            super(context,textViewResourceId,objects);
            items = objects;
            layout = textViewResourceId;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if(v == null){
                LayoutInflater inflater = getLayoutInflater();
                v = inflater.inflate(layout,null);
            }
            Item item = items.get(position);
            TextView content = (TextView) v.findViewById(R.id.txtContent);
            content.setText(item.content);
            CheckBox checkBox = (CheckBox)v.findViewById(R.id.btnCheck);
            checkBox.setChecked(item.isChecked);

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                int count = 0;
                Item item = items.get(position);

                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
                    Log.d("MyAdapter","onCheckedChanged");
                    Log.d("MyAdapter","isCheck = "+isCheck);
                    if(isCheck){
                        if(actionMode == null){
                            actionMode = startActionMode(callback);
                        }
                        item.setChecked(true);
                        count++;
                    }else {
                        count--;
                        item.setChecked(false);
                        for (Item item:items){
                            if(item.isChecked()){
                                count++;
                            }
                        }

                        if(actionMode != null && count<1){
                            actionMode.finish();
                            actionMode = null;
                        }

                    }
                }
            });

            return v;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG,"onOptionsItemSelected");
        Log.d(TAG,"item.getItemId() = "+item.getItemId());
        switch (item.getItemId()){
            case R.id.action_add:
                String s = "Item " + items.size();
                Item itemTemp = new Item();
                itemTemp.content = s;
                items.add(itemTemp);
                adapter.notifyDataSetChanged();

                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

