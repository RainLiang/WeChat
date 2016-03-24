package com.vincentliong.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vincentliong.R;
import com.vincentliong.global.MessageType;
import com.vincentliong.model.LatestMessage;
import com.vincentliong.model.User;
import com.vincentliong.utils.TimeUtils;


import java.util.ArrayList;
import java.util.List;



/**
 * Created by RongMa on 16/3/24.
 */
public class HomePageMessageAdapter extends BaseAdapter
{
    private ArrayList<LatestMessage> msgs;
    private LayoutInflater inflater;
    private Context context;

    public HomePageMessageAdapter(ArrayList<LatestMessage> msgs,Context context)
    {
            this.msgs = msgs;
            this.context = context;
            inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return msgs.size();
    }

    @Override
    public Object getItem(int position) {
        return msgs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.homepage_item_layout,null);
            viewHolder.ivDisplay = (ImageView) convertView.findViewById(R.id.iv_display);
            viewHolder.tvUserName = (TextView) convertView.findViewById(R.id.tv_username);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        LatestMessage message = msgs.get(position);
        //通过message分别获取头像\昵称\最近一条内容\时间
        //加载头像图片\获取昵称
        loadDisplayImageAndUsername(message,viewHolder);

        //处理最近一条信息
        showLatestMessage(message,viewHolder);

        //处理最近一条的时间
        showTime(message,viewHolder);
        return null;
    }

    /**
     * 获取最近信息时间
     */
    private void showTime(LatestMessage message, ViewHolder viewHolder) {
        String timeText = message.getUpdateTime();
        viewHolder.tvUserName.setText(TimeUtils.getTimeText(timeText));
    }

    //处理最新一条信息
    private void showLatestMessage(LatestMessage message,ViewHolder viewHolder) {
        switch(Integer.parseInt(message.getContentType())) {
            case MessageType.TEXT_CONTENT:
                String textContent = message.getTextContent();
                if (!TextUtils.isEmpty(textContent))
                {
                    if(textContent.length() >= 20)
                    {
                        viewHolder.tvContent.setText(textContent.substring(0,16)+"...");
                    }
                    else
                    {
                        viewHolder.tvContent.setText(textContent);
                    }
                }
                break;
            case MessageType.PIC_CONTENT:
                viewHolder.tvContent.setText("[图片]");
                break;
            case MessageType.SOUND_CONTENT:
                viewHolder.tvContent.setText("[语音信息]");
                break;
        }
    }


    private class ViewHolder
    {
        ImageView ivDisplay;
        TextView tvUserName;
        TextView tvContent;
        TextView tvTime;
    }

    //通过Glide加载图片 , 并通过User获取昵称
    private void loadDisplayImageAndUsername(LatestMessage message, final ViewHolder viewHolder)
    {
                //加载头像
                Glide.with(context)
                        .load("")
                        .placeholder(R.drawable.tab_address_pressed)
                        .into(viewHolder.ivDisplay);
                //获取昵称
                if(viewHolder.tvUserName != null)
                {
                    viewHolder.tvUserName.setText("");
                }
    }
}
