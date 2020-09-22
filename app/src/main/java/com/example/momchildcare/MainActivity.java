package com.example.momchildcare;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static int SPLASH_SCREEN=4000;

    Animation topAnim,bottomAnim;
    ImageView image;
    TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        topAnim= AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image=findViewById(R.id.image);
        logo=findViewById(R.id.text);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);

        //next page
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Firstpage.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_SCREEN);
    }
}
