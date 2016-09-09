package com.hanyangraon.kei.app_hnro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.hanyangraon.kei.app_hnro.appbase.HnroActivity;
import com.hanyangraon.kei.app_hnro.appbase.HnroFragment;
import com.hanyangraon.kei.app_hnro.fragment.TalkFragment;

/**
 * 메인 화면 액티비티
 * Copyright (c) HanyangRaon. All Rights Reserved.
 *
 * @author Kei
 * @version 1.0
 * @since 16. 9. 9.
 */
public class MainActivity extends HnroActivity {

    /**
     * =======================================================
     * 메뉴 정보를 가지는 Enum
     * =======================================================
     */
    private enum MenuItems {
        talk("대화창", new TalkFragment());

        private String menuTitle;
        private HnroFragment fragmentClass;

        MenuItems(String menuTitle, HnroFragment fragmentClass) {
            this.menuTitle = menuTitle;
            this.fragmentClass = fragmentClass;
        }

        public CharSequence getMenuTitle() {
            return menuTitle;
        }

        public HnroFragment getView() {
            return fragmentClass;
        }
    }

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        if (mViewPager != null) {
            mViewPager.setAdapter(mSectionsPagerAdapter);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(mViewPager);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    /**
     * =======================================================
     * A placeholder fragment containing a simple view.
     * =======================================================
     */
    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_INDEX = "SECTION_INDEX";
        private HnroFragment fragment;

        /**
         * 인스턴스 획득
         *
         * @param sectionIndex 섹션 인덱스
         * @return PlaceholderFragment의 인스턴스
         */
        public static PlaceholderFragment newInstance(int sectionIndex) {
            PlaceholderFragment fragment = new PlaceholderFragment();

            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_INDEX, sectionIndex);
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if (getArguments() != null) {
                fragment = MenuItems.values()[getArguments().getInt(ARG_SECTION_INDEX)].getView();
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            getFragmentManager().beginTransaction().replace(R.id.layout_contents, fragment).commit();

            return rootView;
        }
    }


    /**
     * =======================================================
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the sections/tabs/pages.
     * =======================================================
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return MenuItems.values().length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return MenuItems.values()[position].getMenuTitle();
        }
    }
}
