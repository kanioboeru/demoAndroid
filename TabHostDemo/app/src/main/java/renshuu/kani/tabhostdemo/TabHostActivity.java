package renshuu.kani.tabhostdemo;

import android.app.TabActivity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TabHostActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);

        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),SimpleFrag.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("detailed").setIndicator("Detailed"),DetailedFrag.class,null);

    }

}
