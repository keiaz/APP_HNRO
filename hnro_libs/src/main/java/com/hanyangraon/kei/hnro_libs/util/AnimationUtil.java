package com.hanyangraon.kei.hnro_libs.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

/**
 * 간단한 애니메이션 효과용 유틸
 * Copyright (c) 2013 Richslide. All Rights Reserved.
 *
 * @author sgKim
 * @version 1.0
 * @since 16. 8. 16.
 */
public class AnimationUtil {

    /**
     * 이동을 위한 Animation set 반환
     *
     * @param fromXDelta 시작 X축 좌표
     * @param toXDelta   끝 X축 좌표
     * @param fromYDelta 시작 Y축 좌표
     * @param toYDelta   끝 Y축 좌표
     * @param duration   Animation 재생속도(ms)
     * @return Animation이 적용된 AnimationSet
     */
    public static AnimationSet translate(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, int duration) {
        Animation animation = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
        animation.setDuration(duration);

        AnimationSet animationSet = new AnimationSet(true);
        // animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.addAnimation(animation);
        return animationSet;
    }

    /**
     * 아래에서 등장하거나, 아래로 사라지는 View
     *
     * @param view     animation을 적용할 view
     * @param isShow   화면에 등장시킬지, 사라지게 할 지 결정하는 플래그. true면 화면에 등장.
     * @param duration 등장 속도 설정(ms)
     */
    public static void toggleBottomView(View view, boolean isShow, int duration) {
        if (view != null) {
            float fromYDelta = 0;
            float toYDelta = 0;
            int visibility;

            if (isShow) {
                fromYDelta = view.getHeight();
                visibility = View.VISIBLE;
            } else {
                toYDelta = view.getHeight();
                visibility = View.GONE;
            }

            if (fromYDelta == toYDelta) {
                setMeasureSpec(view);
                if (isShow) {
                    fromYDelta = view.getMeasuredHeight();
                } else {
                    toYDelta = view.getMeasuredHeight();
                }
            }

            view.setAnimation(translate(0, 0, fromYDelta, toYDelta, duration));
            view.setVisibility(visibility);
        }
    }

    /**
     * 화면에 생성된 적 없는 View의 크기를 측정
     *
     * @param view 측정 대상 화면
     */
    private static void setMeasureSpec(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getRootView().getWidth(), View.MeasureSpec.EXACTLY), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
    }

}
