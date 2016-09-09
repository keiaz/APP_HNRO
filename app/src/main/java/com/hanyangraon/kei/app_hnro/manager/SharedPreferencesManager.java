package com.hanyangraon.kei.app_hnro.manager;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * APP_HNRO의 SharedPreferences 관리
 * Copyright (c) HanyangRaon. All Rights Reserved.
 *
 * @author Kei
 * @version 1.0
 * @since 16. 8. 30.
 */
public class SharedPreferencesManager {

    // const
    private static final String SHARED_PREFERENCES_NAME = "HNRO_SHARED_PREFERENCES";
    private static final String SAML = "SAML";

    // parameters
    private static SharedPreferencesManager sInstance;


    /**
     * private 생성자
     */
    private SharedPreferencesManager() {
        // nothing
    }

    /**
     * SharedPreferencesManager의 인스턴스 획득
     *
     * @return SharedPreferencesManager 인스턴스
     */
    public static SharedPreferencesManager getInstance() {
        if (sInstance == null) {
            sInstance = new SharedPreferencesManager();
        }
        return sInstance;
    }

    /**
     * SharedPreferences 획득
     *
     * @param context 컨텍스트
     * @return 컨텍스트에서 획득한 SharedPreferences
     */
    public SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    /**
     * SharedPreferences에 보안 보장 생성 언어(Security Assertion Markup Language) 저장
     *
     * @param context 컨텍스트
     * @param saml    저장할 SAML
     */
    public void setSAML(Context context, String saml) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(SAML, saml);
        editor.apply();
    }

    /**
     * SharedPreferences에 저장된 보안 보장 생성 언어(Security Assertion Markup Language) 획득
     *
     * @param context 컨텍스트
     * @return SAML
     */
    public String getSAML(Context context) {
        return getSharedPreferences(context).getString(SAML, "");
    }
}
