package com.vincentliong.global;

import android.app.Activity;
import android.os.Bundle;

/**
 * 所有Activity的基类
 * Created by RongMa on 16/3/23.
 */
public abstract class BaseActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVeriable();
        initView(savedInstanceState);
        initData();
    }

    /**
     * 初始化成员变量
     */
    protected abstract void initVeriable();

    /**
     * 加载布局
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 获取数据
     */
    protected abstract void initData();
}
