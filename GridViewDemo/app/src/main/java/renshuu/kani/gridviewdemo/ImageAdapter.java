package renshuu.kani.gridviewdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by hungnm on 16/07/04.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    private Integer[] images = new Integer[]{R.mipmap.cupcake,
            R.mipmap.donut,
            R.mipmap.eclair,
    R.mipmap.froyo,
    R.mipmap.gingerbread,
    R.mipmap.honeycomb,
    R.mipmap.ics,
    R.mipmap.jellybean};

    public ImageAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        if (convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(80,80));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(10,10,10,10);
        }else {
            imageView = (ImageView)convertView;
        }
        imageView.setImageResource(images[position]);
        return imageView;
    }
}
