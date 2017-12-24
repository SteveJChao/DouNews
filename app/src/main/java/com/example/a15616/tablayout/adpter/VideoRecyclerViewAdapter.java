package com.example.a15616.tablayout.adpter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.provider.MediaStore;
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
import java.util.Random;

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
//        if (holder.file != null) {
//            holder.videoView.seekTo(getRandom());
//        }
        final View mView = holder.mView;//from line 57
    }

    /**
     * 产生随机时间
     * @return
     */
    public int getRandom() {
        int max=150;
        int min=20;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s * 1000;
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private View mView;

        protected File file;
        private ImageButton butReplay;
        private ImageButton butPlay;
        private ImageButton butStop;

        public Holder(View itemView) {
            super(itemView);
            this.mView = itemView;

            JZVideoPlayerStandard jzVideoPlayerStandard = (JZVideoPlayerStandard) mView.findViewById(R.id.video_player);
            jzVideoPlayerStandard.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                    , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "Demo tile");
            jzVideoPlayerStandard.thumbImageView.setImageResource(R.drawable.poster);
            butReplay = (ImageButton) itemView.findViewById(R.id.replay);
            butPlay = (ImageButton) itemView.findViewById(R.id.play);
            butStop = (ImageButton) itemView.findViewById(R.id.stop);

            butReplay.setOnClickListener(this);
            butPlay.setOnClickListener(this);
            butStop.setOnClickListener(this);

            //运行时权限的处理
            if (ContextCompat.checkSelfPermission(mContext,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(mActivity, new String[] {
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            } else {
//                initVideoPath();
            }

        }

        /**
         * 初始化播放器
         */
//        private void initVideoPath() {
//            file = new File(Environment.getExternalStorageDirectory(), "qqmusic/mv/movie.mp4");
//            if (file == null) {
//                Toast.makeText(mContext, "The video does not exists.", Toast.LENGTH_SHORT).show();
//            } else {
//                videoView.setVideoPath(file.getPath());
//            }
//        }

        @Override
        public void onClick(View view) {
//            switch (view.getId()) {
//                case R.id.replay:
//                    if (videoView.isPlaying()) {
//                        videoView.resume();
//                    }
//                    break;
//                case R.id.play:
//                    if (!videoView.isPlaying()) {
//                        videoView.start();
//                    }
//                    break;
//                case R.id.stop:
//                    if (videoView.isPlaying()) {
//                        videoView.pause();
//                    }
//                    break;
//            }
        }

        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                               @NonNull int[] grantResults) {
            switch (requestCode) {
                case 1:
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                        initVideoPath();
                    } else {
                        Toast.makeText(mContext, "You have denied the permission.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
            }
        }
    }

}
