package com.example.lzw.day04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class WaterActivity extends AppCompatActivity {

    private ImageView img;
    private WaterView water;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
        img=(ImageView)findViewById(R.id.img);
           water =(WaterView)findViewById(R.id.water);
           final RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) img.getLayoutParams();
           water.animation(new WaterView.AnimationListener() {
               @Override
               public void animation(float y) {
                    params.setMargins(0,0,0, (int) y);
                    img.setLayoutParams(params);
               }
           });
    }
}
