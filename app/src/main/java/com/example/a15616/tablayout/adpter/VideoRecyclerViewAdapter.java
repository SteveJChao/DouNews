package com.example.a15616.tablayout.adpter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.a15616.tablayout.R;
import com.example.a15616.tablayout.activity.MainActivity;

import java.io.File;

/**
 * Created by hungryao on 12/22/2017.
 */

public class VideoRecyclerViewAdapter extends RecyclerView.Adapter <VideoRecyclerViewAdapter.Holder> implements View.OnClickListener{

    //后文Toast使用
    private Context mContext;
    private Activity mActivity;

    private VideoView videoView;
    private ImageButton butReplay;
    private ImageButton butPlay;
    private ImageButton butStop;

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

        videoView = (VideoView) view.findViewById(R.id.video_view);
        butReplay = (ImageButton) view.findViewById(R.id.replay);
        butPlay = (ImageButton) view.findViewById(R.id.play);
        butStop = (ImageButton) view.findViewById(R.id.stop);

        butReplay.setOnClickListener(this);
        butPlay.setOnClickListener(this);
        butStop.setOnClickListener(this);

        //运行时权限的处理
        if (ContextCompat.checkSelfPermission(mContext,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(mActivity, new String[] {
                    Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            initVideoPath();
        }

        return new Holder(view);
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final View mView = holder.mView;
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "This is video item on RecyclerView", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 13;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.replay:
                if (videoView.isPlaying()) {
                    videoView.resume();
                }
                break;
            case R.id.play:
                if (!videoView.isPlaying()) {
                    videoView.start();
                }
                break;
            case R.id.stop:
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
                break;
        }
    }


    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initVideoPath();
                } else {
                    Toast.makeText(mContext, "You have denied the permission.", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    /**
     * 初始化播放器
     */
    private void initVideoPath() {
        File file = new File(Environment.getExternalStorageDirectory(), "qqmusic/mv/movie.mp4");
        if (file == null) {
            Toast.makeText(mContext, "The video does not exists.", Toast.LENGTH_SHORT).show();
            mActivity.finish();
        } else {
            videoView.setVideoPath(file.getPath());
        }
    }


    public class Holder extends RecyclerView.ViewHolder {
        private View mView;
        public Holder(View itemView) {
            super(itemView);
            this.mView = itemView;
        }
    }


}
