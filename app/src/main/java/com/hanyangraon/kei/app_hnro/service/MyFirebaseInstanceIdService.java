package com.hanyangraon.kei.app_hnro.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.hanyangraon.kei.hnro_libs.manager.LogManager;

/**
 * Firebase 인스턴스 아이디 서비스
 * Copyright (c) HanyangRaon. All Rights Reserved.
 *
 * @author Kei
 * @version 1.0
 * @since 16. 9. 9.
 */
public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private static final String FRIENDLY_ENGAGE_TOPIC = "friendly_engage";

    /**
     * The Application's current Instance ID token is no longer valid and thus a new one must be requested.
     */
    @Override
    public void onTokenRefresh() {
        // If you need to handle the generation of a token, initially or after a refresh this is where you should do that.
        String token = FirebaseInstanceId.getInstance().getToken();
        LogManager.getInstance().info(new Exception("FCM Token: " + token));
        Log.d("test", "이건 찍히나");

        // Once a token is generated, we subscribe to topic.
        FirebaseMessaging.getInstance().subscribeToTopic(FRIENDLY_ENGAGE_TOPIC);
    }
}
