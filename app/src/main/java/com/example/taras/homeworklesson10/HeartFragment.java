package com.example.taras.homeworklesson10;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

/**
 * Created by taras on 17.03.16.
 */
public class HeartFragment extends Fragment {
    private SeekBar sbAlpha, sbRotate, sbScale;
    View vHeart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_heart, container, false);
        setRetainInstance(true);
        initViews(view);
        setListeners();
        return view;
    }

    private void setListeners() {
        sbAlpha.setOnSeekBarChangeListener(new CustomSeekBarListener(vHeart, Constants.SB_ALPHA_TAG));
        sbRotate.setOnSeekBarChangeListener(new CustomSeekBarListener(vHeart, Constants.SB_ROTATE_TAG));
        sbScale.setOnSeekBarChangeListener(new CustomSeekBarListener(vHeart, Constants.SB_SCALE_TAG));
    }

    private void initViews(View view) {
        sbAlpha = (SeekBar) view.findViewById(R.id.sb_alpha);
        sbRotate = (SeekBar) view.findViewById(R.id.sb_rotate);
        sbScale = (SeekBar) view.findViewById(R.id.sb_scale);
        vHeart = view.findViewById(R.id.iv_heart);
    }
}
