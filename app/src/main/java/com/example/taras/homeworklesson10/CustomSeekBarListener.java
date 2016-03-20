package com.example.taras.homeworklesson10;

import android.view.View;
import android.widget.SeekBar;

/**
 * Created by taras on 20.03.16.
 */
public class CustomSeekBarListener implements SeekBar.OnSeekBarChangeListener {
    View vHeart;
    String typeTag;

    public CustomSeekBarListener(View vHeart, String typeTag) {
        this.vHeart = vHeart;
        this.typeTag = typeTag;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (typeTag) {
            case Constants.SB_ALPHA_TAG : {
                updateAlpha(progress);
                break;
            }

            case Constants.SB_ROTATE_TAG : {
                updateRotate(progress);
                break;
            }

            case Constants.SB_SCALE_TAG : {
                updateScale(progress);
                break;
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}

    private void updateRotate(int progress) {
        vHeart.setRotation((float) progress * 360 / 100);
    }

    private void updateAlpha(int progress) {
        vHeart.setAlpha((float) progress / 100);
    }

    private void updateScale(int progress) {
        progress += 100;
        vHeart.setScaleX((float) progress / 100);
        vHeart.setScaleY((float) progress / 100);
    }
}
