package com.example.exam2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView circle;
    private ObjectAnimator animatorY;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        circle = (ImageView) findViewById(R.id.circle);


        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circle.setBackgroundColor(Color.rgb(59, 74, 127));
                sunAnimation();
            }
        });
    }

    private void sunAnimation(){
        animatorY = ObjectAnimator.ofFloat(circle,"y",2000f);
        animatorY.setDuration(3000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animatorY);
        animatorSet.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void openActivity2(){
        Intent myintent = new Intent(this, Activity2.class);
        startActivity(myintent);
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.toolbarEnter){
            openActivity2();
        }

        return super.onOptionsItemSelected(item);
    }
}