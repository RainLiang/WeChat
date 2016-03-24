package com.vincentliong.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.vincentliong.R;
import com.vincentliong.adapter.HomePageMessageAdapter;
import com.vincentliong.model.LatestMessage;

import java.util.ArrayList;

/**
 * Created by RongMa on 16/3/23.
 */
public class WeChatFragment extends Fragment
{
    private ListView mLvContent;
    private HomePageMessageAdapter mAdapter;
    private ArrayList<LatestMessage> mMsgs;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_weixin_content,null);
        mLvContent = (ListView) view.findViewById(R.id.lv_msg);
        //获取数据

        return view;
    }
}
