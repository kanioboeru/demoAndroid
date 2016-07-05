package renshuu.kani.readwritefiledemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ReadWriteFIleActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ReadWriteFIleActivity.class.getName();

    EditText input;
    Button btnRead,btnWrite;

    public class MyRecevier extends BroadcastReceiver{

        String path = Environment.getExternalStorageDirectory()+"HelloText.txt";

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG,"path = "+path);
            int mode = intent.getExtras().getInt("Mode");
            if(mode==0){
                readFile(context,intent);
            }else{
                writeFile(context,intent);
            }
        }

        public void readFile(Context context, Intent intent){
            File file = null;
            try{
                file = new File(path);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = "";
                StringBuilder s = new StringBuilder();
                while ((line=br.readLine())!= null){
                    s.append(line);
                }
                Log.d("ファイル内容：",s.toString());
                br.close();
                input.setText(s.toString());
            }catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        public void writeFile(Context context,Intent intent){
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(path);
                String text = intent.getExtras().getString("Text");
                fos.write(text.getBytes());
                fos.close();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
            Toast.makeText(context,"ファイルを書込むのは正常です",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_write_file);

        input = (EditText) findViewById(R.id.editText);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnRead = (Button)findViewById(R.id.btnRead);

        btnRead.setOnClickListener(this);
        btnWrite.setOnClickListener(this);

        registerReceiver(new MyRecevier(), new IntentFilter("renshuu.kani.readwritefiledemo.MyRecevier"));
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent("renshuu.kani.readwritefiledemo.MyRecevier");
        switch (view.getId()){
            case R.id.btnRead :
                intent.putExtra("Mode",0);
                break;
            case R.id.btnWrite:
                intent.putExtra("Mode",1);
                break;
        }
        intent.putExtra("Text",input.getText().toString());
        sendBroadcast(intent);

    }
}
