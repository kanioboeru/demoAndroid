package renshuu.kani.webviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText urlText;
    private Button goButton;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlText = (EditText) findViewById(R.id.urlfield);
        goButton = (Button) findViewById(R.id.btnGo);
        webView = (WebView) findViewById(R.id.web_view);

        urlText.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    openBrowser();
                    return true;
                }

                return false;
            }
        });

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBrowser();
            }
        });

    }

    private void openBrowser(){
        webView.loadUrl("http://"+ urlText.getText().toString());
        webView.requestFocus();
    }

}
