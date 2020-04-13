package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation topAnimation,bottomAnimation,middleAnimation;
    View first,second,third,fourth,fifth,sixth;
    TextView txtHead,txtSlogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        middleAnimation=AnimationUtils.loadAnimation(this,R.anim.middle_animation);

        first=findViewById(R.id.view1);
        second=findViewById(R.id.view2);
        third=findViewById(R.id.view3);
        fourth=findViewById(R.id.view4);
        fifth=findViewById(R.id.view5);
        sixth=findViewById(R.id.view6);
        txtHead=findViewById(R.id.txtHead);
        txtSlogan=findViewById(R.id.txtSlogan);

        first.setAnimation(topAnimation);
        second.setAnimation(topAnimation);
        third.setAnimation(topAnimation);
        fourth.setAnimation(topAnimation);
        fifth.setAnimation(topAnimation);
        sixth.setAnimation(topAnimation);
        txtHead.setAnimation(middleAnimation);
        txtSlogan.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          Intent i=new Intent(MainActivity.this,ChatActivity.class);
                                          startActivity(i);
                                          finish();
                                      }
                                  },5000);
    }
}
