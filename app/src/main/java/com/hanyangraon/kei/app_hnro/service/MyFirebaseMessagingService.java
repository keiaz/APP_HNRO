package com.hanyangraon.kei.app_hnro.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.hanyangraon.kei.hnro_libs.manager.LogManager;

/**
 * Firebase 메시징 서비스
 * Copyright (c) HanyangRaon. All Rights Reserved.
 *
 * @author Kei
 * @version 1.0
 * @since 16. 9. 9.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public MyFirebaseMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        LogManager.getInstance().info(new Exception("FCM Message Id: " + remoteMessage.getMessageId()));
        LogManager.getInstance().info(new Exception("FCM Notification Message: " + remoteMessage.getNotification()));
        LogManager.getInstance().info(new Exception("FCM Data Message: " + remoteMessage.getData()));
    }

}
