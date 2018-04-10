package com.example.a15616.DouNews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a15616.DouNews.R;
import com.example.a15616.DouNews.adpter.VideoRecyclerViewAdapter;

/**
 * Created by hungryao on 12/22/2017.
 */

public class VideoFragment extends Fragment {
    private RecyclerView videoRecyclerView;

    /**
     * 初始化RecyclerView
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        videoRecyclerView = (RecyclerView) inflater
                .inflate(R.layout.fragement_video, container, false);
        return videoRecyclerView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        videoRecyclerView.setLayoutManager(new LinearLayoutManager(videoRecyclerView.getContext()));
        videoRecyclerView.setAdapter(new VideoRecyclerViewAdapter(getActivity(), getActivity()));
    }
}
