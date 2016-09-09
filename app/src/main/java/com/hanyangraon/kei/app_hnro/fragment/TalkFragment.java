package com.hanyangraon.kei.app_hnro.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanyangraon.kei.app_hnro.R;
import com.hanyangraon.kei.app_hnro.appbase.HnroFragment;

/**
 * 메신저 대화창 프래그먼트
 * Copyright (c) HanyangRaon. All Rights Reserved.
 *
 * @author Kei
 * @version 1.0
 * @since 16. 9. 9.
 */
public class TalkFragment extends HnroFragment {

    /**
     * 생성자
     */
    public TalkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (isEmptyFragmentView()) {
            View view = inflater.inflate(R.layout.fragment_talk, container, false);
            setFragmentView(view);
        }

        return getFragmentView();
    }

}
