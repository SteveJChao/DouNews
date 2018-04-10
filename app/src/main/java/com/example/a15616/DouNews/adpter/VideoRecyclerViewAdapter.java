package com.example.a15616.DouNews.adpter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.a15616.DouNews.R;

import java.io.File;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by hungryao on 12/22/2017.
 */

public class VideoRecyclerViewAdapter extends RecyclerView.Adapter <VideoRecyclerViewAdapter.Holder> {

    //后文Toast使用
    private Context mContext;
    private Activity mActivity;

    public VideoRecyclerViewAdapter(Context mContext, Activity mActivity) {
        this.mContext = mContext;
        this.mActivity = mActivity;
    }

    /**
     * 加载布局项
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.video_item, parent, false);

        return new Holder(view);
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final View mView = holder.mView;//from line 57
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private View mView;

        protected File file;
        private ImageButton butShare;
        private ImageButton butLike;
        private ImageButton butComment;
        private ImageButton butCollection;

        public Holder(View itemView) {
            super(itemView);
            this.mView = itemView;

            JZVideoPlayerStandard jzVideoPlayerStandard = (JZVideoPlayerStandard) mView.findViewById(R.id.video_player);
            jzVideoPlayerStandard.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                    , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "Demo tile");
            jzVideoPlayerStandard.thumbImageView.setImageResource(R.drawable.poster);
            butShare = (ImageButton) itemView.findViewById(R.id.share);
            butLike = (ImageButton) itemView.findViewById(R.id.like);
            butComment = (ImageButton) itemView.findViewById(R.id.comment);
            butCollection = (ImageButton) itemView.findViewById(R.id.collection);

            butShare.setOnClickListener(this);
            butLike.setOnClickListener(this);
            butComment.setOnClickListener(this);
            butCollection.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.share:
                    Toast.makeText(mContext, "Share this video.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.like:
                    Toast.makeText(mContext, "Like this video.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.comment:
                    Toast.makeText(mContext, "Comment this video.", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.collection:
                    Toast.makeText(mContext, "Collect this video.", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    }

}
