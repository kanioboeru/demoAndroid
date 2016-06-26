package com.example.hungnm.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by hungnm on 16/06/26.
 */
public class EditActivity extends Activity {

    //保存ファイル名
    String mFileName="";
//    保存なしフラグ
    boolean mNotSave = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }

    @Override
    protected void onPause() {
        super.onPause();

//        [削除]で画面を閉じるときは、保存しない
        if(mNotSave){
            return;
        }

//        タイトル、内容を取得
        EditText eTxtTitle = (EditText)findViewById(R.id.eTxtTitle);
        EditText eTxtContent = (EditText) findViewById(R.id.eTxtContent);
        String title = eTxtTitle.getText().toString();
        String content = eTxtContent.getText().toString();

//        タイトル、内容が空白の場合、保存しない
        if(title.isEmpty()&&content.isEmpty()){
            Toast.makeText(this,R.string.msg_destuction,Toast.LENGTH_LONG).show();
        }

//        ファイル名を生成　ファイル名：　yyyyMMdd_HHmmssSSS.txt
//        逆に保存されるファイルはそのままのファイル名とする
        if(mFileName.isEmpty()){
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS", Locale.JAPAN);
            mFileName = sdf.format(date)+ ".txt";
        }

//      保存
        OutputStream out = null;
        PrintWriter writer = null;
        try{
            out = this.openFileOutput(mFileName, Context.MODE_PRIVATE);
            writer = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));
//            タイトル書き込み
            writer.println(title);
//            内容書き込み
            writer.print(content);
            writer.close();
            out.close();
        }catch (Exception e){
            Toast.makeText(this,R.string.save_error,Toast.LENGTH_LONG).show();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.edit,menu);
////        return super.onCreateOptionsMenu(menu);
//        return true;
//    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete:
//                「削除」選択処理
//                ファイル削除
                if (!mFileName.isEmpty()){
                    this.deleteFile(mFileName);
                }
//                保存せずに、画面を閉じる
                this.finish();
                break;
            default:
                break;
        }

        return super.onMenuItemSelected(featureId, item);
    }
}

