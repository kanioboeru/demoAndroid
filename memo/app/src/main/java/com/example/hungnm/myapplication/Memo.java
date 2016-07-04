package com.example.hungnm.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Memo extends AppCompatActivity {
//    ListView用アダプター
    SimpleAdapter mAdapter = null;
//    ListViewに設定するデータ
    List<Map<String,String>> mList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText(R.string.tab1));
        tabs.addTab(tabs.newTab().setText(R.string.tab2));
        tabs.addTab(tabs.newTab().setText(R.string.tab3));

//        TextView tv  =( TextView ) findViewById(R.id.hello);


//        ActionBar actionBar = getActionBar();
//        actionBar.show();

//        ListView用アダプターのリストを生成
//        mList = new ArrayList< Map <String, String >>();
//        mList = new ArrayList<Map<String, String>>();

//        ListView用アダプタを生成
//        mAdapter = new SimpleAdapter(this,mList,  android.R.layout.simple_list_item_2,
//                new String[]{"title","content"},new int[]{android.R.id.text1,android.R.id.text2});

//        ListViewにアダプターをセット
//        ListView list = (ListView)findViewById(R.id.listView);
//        list.setAdapter(mAdapter);

//        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                編集画面に渡すデータをセットし、表示
//                Intent intent = new Intent(Memo.this,EditActivity.class);
//                intent.putExtra("NAME",mList.get(i).get("filename"));
//                intent.putExtra("TITLE",mList.get(i).get("title"));
//                intent.putExtra("CONTENT",mList.get(i).get("content"));
//                startActivity(intent);
//            }
//        });

//        ListViewをコンテキストメニューに登録
//        registerForContextMenu(list);


    }

    @Override
    protected void onResume() {
        super.onResume();

//        ListView用アダプターのデータをクリア
//        mList.clear();

        //アプリの保存フォルダ内のファイル一覧を取得
        String savePath = this.getFilesDir().getPath().toString();
        File[] files = new File(savePath).listFiles();


        //ファイル名の降順でソート
        Arrays.sort(files, Collections.<File>reverseOrder());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_memo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_add:
//                編集画面への遷移処理
                Intent intent = new Intent(Memo.this,EditActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }



        return super.onOptionsItemSelected(item);
    }
}
