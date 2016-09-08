package com.hanyangraon.kei.hnro_libs.manager;

import android.util.Log;

/**
 * 로그 관리자
 * Copyright (c) HanyangRaon. All Rights Reserved.
 *
 * @author Kei
 * @version 1.0
 * @since 16. 8. 25.
 */
public class LogManager {

    // const
    private static final String LOG_TAG = "APP_LOG";

    private static final int VERBOSE = 1; // 잡다한 로그 출력. 최하위
    private static final int INFO = 2; // 정보 로그 출력
    private static final int DEBUG = 3; // 디버그 로그 출력
    private static final int WARN = 4; // 경고 로그 출력
    private static final int ERROR = 5; // 에러 로그 출력. 최상위

    private static LogManager sInstance = null;

    // parameters
    private int mLogDepth = VERBOSE; // 로그 출력 단계 설정


    /**
     * 생성자를 private로 설정
     */
    private LogManager() {
        // nothing...
    }

    /**
     * 인스턴스 획득
     *
     * @return LogManager 인스턴스
     */
    public static LogManager getInstance() {
        if (sInstance == null) {
            sInstance = new LogManager();
        }
        return sInstance;
    }

    /**
     * 로그 출력 단계 설정
     *
     * @param logDepth 로그 출력 단계
     */
    public void setLogDepth(int logDepth) {
        this.mLogDepth = logDepth;
    }

    /**
     * 동작 여부를 자세히 살필 목적으로 남기는 로그
     *
     * @param exception Exception
     */
    public void vervose(Exception exception) {
        log(VERBOSE, exception);
    }

    /**
     * 처리중 발생하는 진행 과정 모니터링을 위해 남기는 로그
     *
     * @param exception Exception
     */
    public void info(Exception exception) {
        log(INFO, exception);
    }

    /**
     * 디버깅 목적으로 남기는 로그
     *
     * @param exception Exception
     */
    public void debugging(Exception exception) {
        log(DEBUG, exception);
    }

    /**
     * 경고 메시지 로그
     *
     * @param exception Exception
     */
    public void warning(Exception exception) {
        log(WARN, exception);
    }

    /**
     * 심각한 에러 발생시 출력되는 로그
     *
     * @param exception Exception
     */
    public void error(Exception exception) {
        log(ERROR, exception);
    }

    /**
     * 로그 출력
     *
     * @param type 로그 타입
     * @param e    Exception
     */
    private void log(int type, Exception e) {
        if (type >= mLogDepth) {
            StackTraceElement element = e.getStackTrace()[0];

            String fullClassName = element.getClassName();
            String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);

            String fullMessage = "[" + className + "." + element.getMethodName() + "():" + element.getLineNumber() + "] " + e.getMessage();
            Throwable throwable = e.getCause();

            switch (type) {
                case VERBOSE:
                    Log.v(LOG_TAG, fullMessage, throwable);
                    break;
                case DEBUG:
                    Log.d(LOG_TAG, fullMessage, throwable);
                    break;
                case INFO:
                    Log.i(LOG_TAG, fullMessage, throwable);
                    break;
                case WARN:
                    Log.w(LOG_TAG, fullMessage, throwable);
                    break;
                case ERROR:
                    Log.e(LOG_TAG, fullMessage, throwable);
                    break;
                default:
                    break;
            }

        }
    }

}
