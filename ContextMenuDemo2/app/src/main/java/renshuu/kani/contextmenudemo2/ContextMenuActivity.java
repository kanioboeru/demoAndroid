package renshuu.kani.contextmenudemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContextMenuActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> s;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        listView = (ListView) findViewById(R.id.listview);
        s = new ArrayList<String>();
        for(int i =0; i< 20;i++){
            String sTemp = "Row " + (i+1);
            s.add(sTemp);
        }

        adapter = new ArrayAdapter<String>(this,R.layout.item_layout,s);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int pos = info.position;
        String delItem = s.get(pos);
        switch (item.getItemId()){
            case R.id.delete :
                s.remove(pos);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"削除　'"+delItem + "' at row "+ info.id,Toast.LENGTH_LONG).show();

                break;
            case R.id.share :
                Toast.makeText(getApplicationContext(),"共有できた",Toast.LENGTH_LONG).show();
                break;
            case R.id.update :
                Toast.makeText(getApplicationContext(),"更新できた",Toast.LENGTH_LONG).show();
                break;

        }

        return super.onContextItemSelected(item);
    }
}
