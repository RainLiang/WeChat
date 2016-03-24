package com.vincentliong.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.vincentliong.R;
import com.vincentliong.global.BaseActivity;

public class ChatActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVeriable() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chat);
    }

    @Override
    protected void initData() {

    }
}
