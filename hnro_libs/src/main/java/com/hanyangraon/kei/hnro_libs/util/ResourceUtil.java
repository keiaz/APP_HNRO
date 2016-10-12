package com.hanyangraon.kei.hnro_libs.util;

import com.hanyangraon.kei.hnro_libs.manager.LogManager;

import java.lang.reflect.Field;

/**
 * 리소스 관련 유틸
 * Copyright (c) 2013 Richslide. All Rights Reserved.
 *
 * @author sgKim
 * @version 1.0
 * @since 16. 8. 23.
 */
public class ResourceUtil {

    /**
     * 문자열 이름으로 리소스 id 획득
     *
     * @param c    리소스 클래스
     * @param name 리소스 이름
     * @return 리소스 id
     */
    public static int getResId(Class<?> c, String name) {
        try {
            Field field = c.getDeclaredField(name);
            return field.getInt(field);
        } catch (Exception e) {
            LogManager.getInstance().error(e);
            return 0;
        }
    }

    /**
     * imageView의 기존 이미지를 제거한다 (bitmap은 GC가 자동으로 제거해주지 않는다)
     */
//    public static void recycleImage(ImageView imageView) {
//        BitmapDrawable preBitmap = (BitmapDrawable) imageView.getDrawable();
//        if (preBitmap != null) {
//            Bitmap bm = preBitmap.getBitmap();
//            if (bm != null) {
//                bm.recycle();
//            }
//        }
//    }


    /**
     * 문자열 이름으로 drawable 리소스 id 획득
     *
     * @param name drawable 리소스 이름
     * @return drawable 리소스 id
     */
    // public static int getDrawableResId(String name) {
//        return getResId(R.drawable.class, name);
//    }

    /**
     * drawable 리소스 획득
     *
     * @param activity 현재 화면 activity
     * @param resid    리소스 id
     * @return 리소스 id로 탐색된 drawable
     */
//    public static Drawable getDrawable(Activity activity, int resid) {
//        return ContextCompat.getDrawable(activity, resid);
//    }

    /**
     * 다른 테마의 drawable 리소스 획득
     *
     * @param resources 탐색할 대상 리소스
     * @param resid     리소스 id
     * @param theme     테마. 특정 테마가 없으면 null
     * @return 리소스 id로 탐색된 drawable
     */
//    public static Drawable getDrawable(Resources resources, int resid, Resources.Theme theme) {
//        return ResourcesCompat.getDrawable(resources, resid, theme);
//    }
}
