package com.vincentliong.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;


import com.vincentliong.R;

/**
 * Created by RongMa on 16/3/23.
 */
public class AddressBookFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_address_content,null);
        return view;
    }
}
