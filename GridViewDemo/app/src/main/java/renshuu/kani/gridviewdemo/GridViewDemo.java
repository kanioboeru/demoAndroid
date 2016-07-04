package renshuu.kani.gridviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class GridViewDemo extends AppCompatActivity {

    GridView gridImage;
    ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_demo);

        gridImage = (GridView) findViewById(R.id.gridImage);
        adapter = new ImageAdapter(this);
        gridImage.setAdapter(adapter);
    }
}
