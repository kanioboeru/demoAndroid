package renshuu.kani.customelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomeListViewActivity extends AppCompatActivity {

    private static final String TAG = CustomeListViewActivity.class.getName();

    ArrayList<Country> countries;
    MyAdapter myAdapter;
    ListView lv;

    private String[][] COUNTRY_NAMES = {{"Belgium","Bi"},{"France","Phap"},{"Germany","Duc"},{"Italy","Y"}
    ,{"Spain","Tay Ban Nha"},{"VietNam","Viet Nam"}};
    private int[] COUNTRY_IMAGE = {R.drawable.flag_belgium,R.drawable.flag_france,R.drawable.flag_germany,
    R.drawable.flag_italy,R.drawable.flag_spain,R.drawable.flag_vietnam};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custome_list_view);

        countries = new ArrayList<Country>();
        for (int i = 0; i<COUNTRY_NAMES.length;i++){
            Country country = new Country();
            country.setNameTA(COUNTRY_NAMES[i][0]);
            country.setNameTV(COUNTRY_NAMES[i][1]);
            country.setImgFlag(getResources().getDrawable(COUNTRY_IMAGE[i]));
            Log.d(TAG,"COUNTRY_NAMES[i][0] ="+COUNTRY_NAMES[i][0]);
            Log.d(TAG,"COUNTRY_NAMES[i][1] ="+COUNTRY_NAMES[i][1]);
            countries.add(country);
        }

        myAdapter = new MyAdapter(this,R.layout.item_list,countries);
        lv = (ListView)findViewById(R.id.listviewCountry);
        lv.setAdapter(myAdapter);
    }
}
