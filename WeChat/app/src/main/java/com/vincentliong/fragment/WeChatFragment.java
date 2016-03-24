package com.vincentliong.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.vincentliong.R;
import com.vincentliong.activity.ChatActivity;
import com.vincentliong.adapter.HomePageMessageAdapter;
import com.vincentliong.dao.LatestMessageHelper;
import com.vincentliong.dao.MessageHelper;
import com.vincentliong.dao.UserHelper;
import com.vincentliong.global.MessageType;
import com.vincentliong.model.LatestMessage;
import com.vincentliong.model.Message;
import com.vincentliong.model.User;
import com.vincentliong.utils.TimeUtils;

import java.util.ArrayList;

/**
 * Created by RongMa on 16/3/23.
 */
public class WeChatFragment extends Fragment
{
    private ListView mLvContent;
    private HomePageMessageAdapter mAdapter;
    private ArrayList<LatestMessage> mMsgs;
    private User mUserJingjing;
    private User mUserRongma;
    private LatestMessage message;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_weixin_content,null);
        mLvContent = (ListView) view.findViewById(R.id.lv_msg);
        //获取数据,模拟创建2个User,1条最近信息
        addData();
        mLvContent.setAdapter(mAdapter);
        mLvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("user",mUserJingjing);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }

    private void addData() {
        UserHelper userHelper = new UserHelper(getActivity());
        LatestMessageHelper latestHelper = new LatestMessageHelper(getActivity());
        mMsgs = new ArrayList<LatestMessage>();
        mUserRongma = new User("0001","戎码",R.drawable.rongma_display+"");
        mUserJingjing = new User("0002","婧婧",R.drawable.jingjing_display+"");
        message = new LatestMessage("0001","0002","你好呀", MessageType.TEXT_CONTENT+"", TimeUtils.getTimeTextByLong(System.currentTimeMillis()));
        preferences = getActivity().getSharedPreferences("checkFirst", Context.MODE_PRIVATE);
        editor = preferences.edit();
        boolean isChecked = preferences.getBoolean("isFirst",true);
        if(!isChecked) {
            LatestMessageHelper helper = new LatestMessageHelper(getActivity());
            mMsgs = (ArrayList<LatestMessage>) helper.queryAllLatestMessage();
        }
        else
        {
            mMsgs.add(message);
            userHelper.insertUser(mUserRongma);
            userHelper.insertUser(mUserJingjing);
            latestHelper.insertLatestMessage(message);
            MessageHelper msgHelper = new MessageHelper(getActivity());
            msgHelper.insertMessage(new Message("0002","0001",MessageType.TEXT_CONTENT+"","你好呀",null,null,null,TimeUtils.getTimeTextByLong(System.currentTimeMillis())));
            editor.putBoolean("isFirst",false);
            editor.commit();
        }
        mAdapter = new HomePageMessageAdapter(mMsgs,getActivity());
    }


}
