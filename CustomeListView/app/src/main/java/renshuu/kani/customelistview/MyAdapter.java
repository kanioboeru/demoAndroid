package renshuu.kani.customelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungnm on 16/07/05.
 */
public class MyAdapter extends ArrayAdapter<Country>{
    private Context context;
    private int textViewResourceId;
    private ArrayList<Country> countries;

    public MyAdapter (Context context, int textViewResourceId, ArrayList<Country> countries){
        super(context, textViewResourceId, countries);
        this.context = context;
        this.textViewResourceId = textViewResourceId;
        this.countries = countries;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(textViewResourceId,null);
        }

        Country country = countries.get(position);
        if(country!=null){
            TextView tvTA = (TextView) view.findViewById(R.id.txtTA);
            tvTA.setText(country.getNameTA());
            TextView tvTV = (TextView)view.findViewById(R.id.txtTV);
            tvTV.setText(country.getNameTV());
            ImageView imgFlag = (ImageView) view.findViewById(R.id.imgFlag);
            imgFlag.setImageDrawable(country.getImgFlag());
        }
        return view;
    }
}
