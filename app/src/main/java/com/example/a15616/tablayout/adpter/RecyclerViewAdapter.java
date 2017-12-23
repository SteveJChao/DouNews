package com.example.a15616.tablayout.adpter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a15616.tablayout.R;
import com.example.a15616.tablayout.activity.DetailActivity;
import com.example.a15616.tablayout.activity.MainActivity;


/**
 * Created by hungryao on 12/21/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private Activity activity;

    /**
     * constructor
     * @param context
     */
    public RecyclerViewAdapter(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }


    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        final View mView = holder.mView;
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(activity, DetailActivity.class);
                new MainActivity().startIntent();
            }
        });
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public final View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

    }
}
