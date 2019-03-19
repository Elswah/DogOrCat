package com.example.ahmed.dogorcat;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class ResultActivity extends ActionBarActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        imageView=(ImageView)findViewById(R.id.imageView);
       Bundle extra= getIntent().getExtras();
        if(extra!=null){
           int dogCounter= extra.getInt("dogCounter");
           int catCounter= extra.getInt("catCounter");
            if(dogCounter>catCounter){
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dog));
            }else{
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.cat));
            }
        }
    }



}
