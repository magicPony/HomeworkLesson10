package com.example.taras.homeworklesson10;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;


public class BallFragment extends Fragment {
    private View vBall;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_ball, container, false);
        setRetainInstance(true);

        vBall = view.findViewById(R.id.iv_ball);
        vBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startPropertyAnimation(v);
            }
        });

        return view;
    }

    private void startPropertyAnimation(final View v) {
        View vBallParent = (View) vBall.getParent();
        int ballWidth, ballHeight, ballParentWidth, ballParentHeight;
        ballWidth = vBall.getWidth();
        ballHeight = vBall.getHeight();
        ballParentWidth = vBallParent.getWidth();
        ballParentHeight = vBallParent.getHeight();

        vBall.setPivotY(0);

        float scale = (float) ballParentWidth / ballWidth,
              translation = (float) ballParentHeight - ballHeight * scale;

        final ObjectAnimator scaleAnimator = ObjectAnimator.ofPropertyValuesHolder(v,
                PropertyValuesHolder.ofFloat("scaleX", scale),
                PropertyValuesHolder.ofFloat("scaleY", scale));

        final ObjectAnimator translateAnimator = ObjectAnimator
                .ofFloat(v, "translationY", translation);

        scaleAnimator.setDuration(Constants.BALL_ANIMATION_DURATION);
        translateAnimator.setDuration(Constants.BALL_ANIMATION_DURATION);

        scaleAnimator.setTarget(v);
        translateAnimator.setTarget(v);

        scaleAnimator.setInterpolator(new BounceInterpolator());
        translateAnimator.setInterpolator(new BounceInterpolator());

        scaleAnimator.setRepeatCount(1);
        translateAnimator.setRepeatCount(1);
        scaleAnimator.setRepeatMode(ValueAnimator.REVERSE);
        translateAnimator.setRepeatMode(ValueAnimator.REVERSE);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translateAnimator, scaleAnimator);
        animatorSet.setTarget(v);
        animatorSet.start();
    }
}
