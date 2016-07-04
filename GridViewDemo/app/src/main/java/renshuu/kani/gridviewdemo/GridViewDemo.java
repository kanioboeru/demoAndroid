package renshuu.kani.gridviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class GridViewDemo extends AppCompatActivity {

    GridView gridImage;
    ImageAdapter adapter;

    public static final Integer[] images = {R.mipmap.cupcake,
    R.mipmap.donut,R.mipmap.eclair,R.mipmap.froyo,R.mipmap.gingerbread,R.mipmap.honeycomb,R.mipmap.ics,
    R.mipmap.jellybean};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_demo);

        gridImage = (GridView) findViewById(R.id.gridImage);
        adapter = new ImageAdapter(this);
        gridImage.setAdapter(adapter);

        gridImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                Intent intent = new Intent(GridViewDemo.this,ShowImage.class);
                intent.putExtra("Position",pos);
                startActivity(intent);
            }
        });
    }
}
