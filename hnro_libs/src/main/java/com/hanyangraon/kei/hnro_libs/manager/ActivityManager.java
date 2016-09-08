package com.hanyangraon.kei.hnro_libs.manager;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 액티비티 매니저
 * Copyright (c) HanyangRaon. All Rights Reserved.
 *
 * @author Kei
 * @version 1.0
 * @since 16. 8. 25.
 */
public class ActivityManager {

    private static ActivityManager instance = null; // 인스턴스 저장

    private ArrayList<Activity> activityList; // 액티비티 목록


    /**
     * private 생성자<br>
     * 생성시 액티비티 목록을 초기화
     */
    private ActivityManager() {
        activityList = new ArrayList<>();
    }

    /**
     * 인스턴스 획득
     *
     * @return 저장된 인스턴스 반환
     */
    public static ActivityManager getInstance() {
        if (instance == null) {
            instance = new ActivityManager();
        }
        return instance;
    }

    /**
     * 저장된 HnroAppCompatActivity 개수를 획득
     *
     * @return activityList에 저장된 Activity의 개수
     */
    public int getSize() {
        return activityList.size();
    }

    /**
     * activityList에 해당 HnroAppCompatActivity가 포함되어 있는지 여부를 반환
     *
     * @param activity 확인할 Activity
     * @return 포함되어 있으면 true.
     */
    public boolean hasActivity(Activity activity) {
        return activityList.contains(activity);
    }

    /**
     * activityList에 HnroAppCompatActivity를 추가한다.
     *
     * @param activity 추가할 HnroAppCompatActivity
     */
    public void addActivity(Activity activity) {
        if (!hasActivity(activity)) {
            activityList.add(activity);
        }
    }

    /**
     * 마지막으로 추가된 HnroAppCompatActivity를 획득
     *
     * @return 마지막으로 추가된 HnroAppCompatActivity
     */
    public Activity getLastActivity() {
        int lastIndex = activityList.size() - 1;

        if (lastIndex != -1) {
            return activityList.get(lastIndex);
        } else {
            return null;
        }
    }

    /**
     * activityList에서 특정 HnroAppCompatActivity를 제거한다.
     *
     * @param activity 제거할 Activity
     */
    public boolean removeActivity(Activity activity) {
        return activityList.remove(activity);
    }

    /**
     * 배열에 저장된 모든 HnroAppCompatActivity를 종료한다.
     */
    public void finishAllActivity() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
    }

    /**
     * 특정 activity를 제외한 activityList에 등록된 HnroAppCompatActivity를 전부 종료한다.
     *
     * @param activityClass 종료하지 않고 남겨둘, {@link Activity} 상속 activity의 Class
     */
    public void finishActivity(Class<? extends Activity> activityClass) {
        Iterator<Activity> iterator = activityList.iterator();
        while (iterator.hasNext()) {
            Activity activity = iterator.next();
            if (activity.getClass() == activityClass) {
                continue;
            }
            activity.finish();
            iterator.remove();
        }
    }

}
