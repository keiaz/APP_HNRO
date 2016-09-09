package com.hanyangraon.kei.app_hnro;

import android.os.Bundle;

import com.hanyangraon.kei.app_hnro.appbase.HnroActivity;
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

        String saml = SharedPreferencesManager.getInstance().getSAML(this);
        if (saml.isEmpty()) {
            new DelayThread().start();
        } else {
            gotoMain();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    /**
     * 로그인 상태가 아닐 경우 로그인 화면으로 이동
     */
    private void gotoLogin() {
        moveActivity(LoginActivity.class);
    }

    /**
     * 자동로그인되어 메인으로 이동
     */
    private void gotoMain() {
        moveActivity(MainActivity.class);
    }


    /**
     * =======================================================
     * 로그인 상태가 아닐 경우 스플래시 화면을 보여주기 위한, {@link Thread} 상속 클래스
     * =======================================================
     */
    private class DelayThread extends Thread {
        @Override
        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                LogManager.getInstance().error(e);
            } finally {
                gotoLogin();
            }
        }
    }
}
