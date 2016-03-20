package com.example.taras.homeworklesson10;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by taras on 18.03.16.
 */
public class CustomAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context = null;

    public CustomAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final TextView textView = holder.textView;
        textView.setText("Item #" + Integer.toString(position + 1));
        startSlideAnimation(textView);
    }

    private void startSlideAnimation(View view) {
        final Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_slide);
        view.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return Constants.RECYCLER_VIEW_ITEMS_COUNT;
    }
}
