package com.hanyangraon.kei.app_hnro.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanyangraon.kei.app_hnro.R;
import com.hanyangraon.kei.app_hnro.fragment.dummy.DummyContent;
import com.hanyangraon.kei.app_hnro.fragment.dummy.DummyContent.DummyItem;

import java.util.List;

public class TalkItemFragment extends Fragment {

    public static TalkItemFragment newInstance(int columnCount) {
        TalkItemFragment fragment = new TalkItemFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talkitem_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new TalkItemRecyclerViewAdapter(DummyContent.ITEMS));
        }
        return view;
    }

}
