package com.example.taras.homeworklesson10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private String activityTag = Constants.DEFAULT_TAG;
    private BallFragment ballFragment;
    private HeartFragment heartFragment;
    private RecyclerViewFragment recyclerViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragments();
    }

    private void initFragments() {
        // 'cause no need to create fragments every time menu item selected
        ballFragment = new BallFragment();
        heartFragment = new HeartFragment();
        recyclerViewFragment = new RecyclerViewFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_ball : {
                startBallFragment();
                break;
            }

            case R.id.mi_recycler_view : {
                startRecyclerViewFragment();
                break;
            }

            case R.id.mi_heart : {
                startHeartFragment();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void startBallFragment() {
        if (activityTag.equals(Constants.BALL_FRAGMENT_TAG)) {
            return;
        }

        activityTag = Constants.BALL_FRAGMENT_TAG;

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, ballFragment, "ball")
                .commitAllowingStateLoss();
    }

    private void startRecyclerViewFragment() {
        if (activityTag.equals(Constants.RECYCLER_VIEW_FRAGMENT_TAG)) {
            return;
        }

        activityTag = Constants.RECYCLER_VIEW_FRAGMENT_TAG;

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, recyclerViewFragment, "ball")
                .commitAllowingStateLoss();
    }

    private void startHeartFragment() {
        if (activityTag.equals(Constants.HEART_FRAGMENT_TAG)) {
            return;
        }

        activityTag = Constants.HEART_FRAGMENT_TAG;

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, heartFragment, "ball")
                .commitAllowingStateLoss();
    }
}
