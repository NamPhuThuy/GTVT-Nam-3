package com.example.spotify_cloneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.*;

public class logoBegin extends AppCompatActivity {

    private Handler handler;
    ImageView imageLogo;
    TextView text1,text2,text3,text4,text5,text6,text7;

    //Logo animation
    ScaleAnimation scaleInAnimation, scaleOutAnimation;
    TranslateAnimation translateLogo;
    AnimationSet setLogo;

    //Text Animation
    AnimationSet aniSetText1,aniSetText2,aniSetText3,
            aniSetText4,aniSetText5,aniSetText6,aniSetText7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_begin);

        //Intent
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(logoBegin.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },4000);

        findId();
        //Animation logo
        AnimationLogo();

        //Animation Text
        AnimationText();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageLogo.startAnimation(scaleInAnimation);
            }
        },1000);

        scaleInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageLogo.startAnimation(setLogo);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        setLogo.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                text1.startAnimation(aniSetText1);
                text2.startAnimation(aniSetText2);
                text3.startAnimation(aniSetText3);
                text4.startAnimation(aniSetText4);
                text5.startAnimation(aniSetText5);
                text6.startAnimation(aniSetText6);
                text7.startAnimation(aniSetText7);

                text1.setVisibility(View.VISIBLE);
                text2.setVisibility(View.VISIBLE);
                text3.setVisibility(View.VISIBLE);
                text4.setVisibility(View.VISIBLE);
                text5.setVisibility(View.VISIBLE);
                text6.setVisibility(View.VISIBLE);
                text7.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void findId(){
        imageLogo = findViewById(R.id.image_logo);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);
        text7 = findViewById(R.id.text7);

    }
    public void AnimationLogo(){
        scaleInAnimation = new ScaleAnimation(1,1.5f,1,1.5f, Animation.RELATIVE_TO_SELF,0.5f, Animation
                .RELATIVE_TO_SELF,0.5f);
        scaleInAnimation.setDuration(800);
        scaleInAnimation.setFillAfter(true);

        scaleOutAnimation = new ScaleAnimation(1.5f,1,1.5f,1, Animation.RELATIVE_TO_SELF,0.5f, Animation
                .RELATIVE_TO_SELF,0.5f);
        scaleOutAnimation.setDuration(800);

        translateLogo = new TranslateAnimation(0,-200,0,0);
        translateLogo.setDuration(800);

        setLogo = new AnimationSet(true);
        setLogo.addAnimation(scaleOutAnimation);
        setLogo.addAnimation(translateLogo);
        setLogo.setFillAfter(true);
    }
    public void AnimationText(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(800);

        TranslateAnimation trans1 = new TranslateAnimation(0,200,0,0);
        trans1.setDuration(800);

        TranslateAnimation trans2 = new TranslateAnimation(0,290,0,0);
        trans2.setDuration(800);

        TranslateAnimation trans3 = new TranslateAnimation(0,370,0,0);
        trans3.setDuration(800);

        TranslateAnimation trans4 = new TranslateAnimation(0,450,0,0);
        trans4.setDuration(800);

        TranslateAnimation trans5 = new TranslateAnimation(0,500,0,0);
        trans5.setDuration(800);

        TranslateAnimation trans6 = new TranslateAnimation(0,530,0,0);
        trans6.setDuration(800);

        TranslateAnimation trans7 = new TranslateAnimation(0,580,0,0);
        trans7.setDuration(800);

        aniSetText1 = new AnimationSet(true);
        aniSetText1.addAnimation(alphaAnimation);
        aniSetText1.addAnimation(trans1);
        aniSetText1.setFillAfter(true);

        aniSetText2 = new AnimationSet(true);
        aniSetText2.addAnimation(alphaAnimation);
        aniSetText2.addAnimation(trans2);
        aniSetText2.setFillAfter(true);

        aniSetText3 = new AnimationSet(true);
        aniSetText3.addAnimation(alphaAnimation);
        aniSetText3.addAnimation(trans3);
        aniSetText3.setFillAfter(true);

        aniSetText4 = new AnimationSet(true);
        aniSetText4.addAnimation(alphaAnimation);
        aniSetText4.addAnimation(trans4);
        aniSetText4.setFillAfter(true);

        aniSetText5 = new AnimationSet(true);
        aniSetText5.addAnimation(alphaAnimation);
        aniSetText5.addAnimation(trans5);
        aniSetText5.setFillAfter(true);

        aniSetText6 = new AnimationSet(true);
        aniSetText6.addAnimation(alphaAnimation);
        aniSetText6.addAnimation(trans6);
        aniSetText6.setFillAfter(true);

        aniSetText7 = new AnimationSet(true);
        aniSetText7.addAnimation(alphaAnimation);
        aniSetText7.addAnimation(trans7);
        aniSetText7.setFillAfter(true);

    }
}