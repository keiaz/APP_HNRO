package com.hanyangraon.kei.app_hnro.appbase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * {@link Fragment}를 상속받은 App base fragment
 * Copyright (c) 2013 Richslide. All Rights Reserved.
 *
 * @author Kei
 * @version 1.0
 * @since 16. 8. 29.
 */
public class HnroFragment extends Fragment implements View.OnClickListener {

    // UI references
    private volatile View mFragmentView = null; // 프레그먼트에 적용된 뷰

    /**
     * 프래그먼트 초기 생성시 호출
     *
     * @param savedInstanceState 이전에 생성되어 저장된 state가 존재할 경우, 해당 state 전달
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 프래그먼트의 인스턴스가 사용자 인터페이스 뷰 생성시 호출
     *
     * @param inflater           프래그먼트 뷰 확장을 위해 사용될 LayoutInflater
     * @param container          프래그먼트의 UI가 부착될 부모 view
     * @param savedInstanceState 재생성된 프래그먼트일 경우 이전에 저장된 state
     * @return 프래그먼트의 UI view 또는 null 반환
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * view가 클릭되었을 때 호출
     *
     * @param view 클릭된 view
     */
    @Override
    public void onClick(View view) {
        // empty
    }

    /**
     * 프레그먼트에 적용된 뷰 setter
     *
     * @param fragmentView 프레그먼트에 적용된 뷰
     */
    protected void setFragmentView(View fragmentView) {
        this.mFragmentView = fragmentView;
    }

    /**
     * 프레그먼트에 적용된 뷰 getter
     *
     * @return 프레그먼트에 적용된 뷰
     */
    protected View getFragmentView() {
        return mFragmentView;
    }

    /**
     * 프래그먼트에 적용된 뷰가 있는지 확인
     *
     * @return 프래그먼트에 적용된 뷰가 null일 경우 true
     */
    protected boolean isEmptyFragmentView() {
        return mFragmentView == null;
    }

    /**
     * 클릭 이벤트 리스너를 부착
     *
     * @param id 부착할 대상 View의 id
     */
    protected void setOnClickListener(int id) {
        if (mFragmentView != null) {
            View view = mFragmentView.findViewById(id);
            if (view != null) {
                view.setOnClickListener(this);
            }
        }
    }
}
