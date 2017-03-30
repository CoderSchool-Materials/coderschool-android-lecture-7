package com.kungfoolabs.lecture7;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    private Button btnAnimate;
    private Animator currentAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(android.R.id.content).setOnTouchListener(
                new OnSwipeTouchListener(this, new OnSwipeTouchListener.OnSwipeRecognizer() {
            @Override
            public void onSwipeRight() {
                Animator anim = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.regenerate);
                currentAnimation = anim;
                anim.setTarget(btnAnimate);
                anim.setDuration(10000);
                anim.start();
            }

            @Override
            public void onSwipeLeft() {
                if(currentAnimation != null) {
                    currentAnimation.cancel();
                }
            }

            @Override
            public void onSwipeTop() {

            }

            @Override
            public void onSwipeBottom() {

            }
        }));

        ((Button) findViewById(R.id.btnCancel)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentAnimation != null) {
                    currentAnimation.cancel();
                }
            }
        });

        btnAnimate = (Button) findViewById(R.id.btnAnimate);
        btnAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NonMainActivity.class));
                overridePendingTransition(R.anim.rotate, R.anim.slide_out_left);

//                Animator anim = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.regenerate);
//                currentAnimation = anim;
//                anim.setTarget(v);
//                anim.setDuration(10000);

//                anim.start();

//                final float density = getResources().getDisplayMetrics().density;
//
//                ObjectAnimator moveDownAnimation = ObjectAnimator.ofFloat(v, "y", 200.0f * density);
//                moveDownAnimation.setInterpolator(new DecelerateInterpolator());
//                moveDownAnimation.setRepeatCount(3);
//
//                ObjectAnimator moveRightAnimation = ObjectAnimator.ofFloat(v, "x", 200.0f * density);
//
//                ObjectAnimator fadeOutAnimation = ObjectAnimator.ofFloat(v, "alpha", 0);
//
//                AnimatorSet setTwo = new AnimatorSet();
//                setTwo.playTogether(moveDownAnimation, moveRightAnimation);
//                setTwo.setDuration(2000);
//
//                AnimatorSet setOne = new AnimatorSet();
//                setOne.playSequentially(setTwo, fadeOutAnimation);
//                setOne.start();

//                btnAnimate.animate().xBy(100.0f * density)
//                        .yBy(200.0f * density)
//                        .rotationBy(90.0f)
//                        .start();

//                ObjectAnimator moveDownAnimation = ObjectAnimator.ofFloat(v, "y", 200.0f * density);
//                moveDownAnimation.setInterpolator(new DecelerateInterpolator());
//                moveDownAnimation.setRepeatCount(3);

            }
        });
    }
}
