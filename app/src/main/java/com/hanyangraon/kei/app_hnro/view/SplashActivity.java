package com.hanyangraon.kei.app_hnro.view;

import android.os.Bundle;

import com.google.firebase.iid.FirebaseInstanceId;
import com.hanyangraon.kei.app_hnro.HnroActivity;
import com.hanyangraon.kei.app_hnro.R;
import com.hanyangraon.kei.app_hnro.manager.SharedPreferencesManager;
import com.hanyangraon.kei.hnro_libs.manager.LogManager;


/**
 * 앱 시작시 로딩화면
 * Copyright (c) HanyangRaon. All Rights Reserved.
 *
 * @author Kei
 * @version 1.0
 * @since 16. 8. 30.
 */
public class SplashActivity extends HnroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /* FCM 토큰생성 */
        String token = FirebaseInstanceId.getInstance().getToken();
        LogManager.getInstance().info(new Exception(token));

        /* saml 정보 획득 */
        String saml = SharedPreferencesManager.getInstance().getSAML(this);
        if (saml.isEmpty()) {
            // saml 정보가 없으면 딜레이 후 로그인 화면으로 이동
            new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        LogManager.getInstance().error(e, getBaseContext());
                    } finally {
                        // moveActivity(LoginActivity.class);
                    }
                }
            }.start();
        } else {
            // 메인으로 이동
            // moveActivity(OldMainActivity.class);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        /* 정지되면 제거 */
        finish();
    }

}
