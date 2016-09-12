package com.hanyangraon.kei.hnro_libs.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 날짜 관련 유틸
 * Copyright (c) HanyangRaon. All Rights Reserved.
 *
 * @author Kei
 * @version 1.0
 * @since 16. 9. 12.
 */
public class DateUtil {

    /**
     * long 형 숫자를 날짜로 변환
     *
     * @param num 날짜 long 수치값
     * @return 날짜로 획득한 Date
     */
    public static Date convertLongToDate(long num) {
        return new Date(num);
    }

    /**
     * 해당 포멧으로 현재 날짜를 리턴
     *
     * @param date   날짜
     * @param format 날짜 포멧
     * @param locale 지역
     * @return 포멧된 날짜
     */
    public static String getDateByFormat(Date date, String format, Locale locale) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
        return sdf.format(date);
    }

    /**
     * 해당 포멧으로 현재 날짜를 리턴
     *
     * @param date   날짜
     * @param format 날짜 포멧
     * @return 포멧된 날짜
     */
    public static String getDateByFormat(Date date, String format) {
        return getDateByFormat(date, format, Locale.KOREA);
    }

    /**
     * long 형 숫자를 포멧된 날짜형태로 변환
     *
     * @param num    날짜의 밀리세컨드값
     * @param format 날짜 포멧
     * @return 포멧된 날짜
     */
    public static String getLongToStringDate(long num, String format) {
        return getDateByFormat(convertLongToDate(num), format);
    }

}
