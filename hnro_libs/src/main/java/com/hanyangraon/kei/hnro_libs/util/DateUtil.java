package com.hanyangraon.kei.hnro_libs.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    // Consts
    private static final int DAY_MS = (24 * 60 * 60 * 1000); // 1일의 밀리세컨드 값

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

    /**
     * 날짜를 0시 0분 0초 0밀리세컨드로 설정
     *
     * @param date 변경할 날짜
     * @return 변경된 날짜
     */
    public static Date setZeroOclock(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 두 날짜 기간 사이가 얼마나 되는지 계산
     *
     * @param baseDate    기준일
     * @param compareDate 비교일
     * @return 0이면 같은 날짜, 음수값이면 첫번째 날짜보다 두번째 날짜가 더 과거, 양수값이면 첫번째 날짜보다 두번째 날짜가 미래
     */
    public static int diffOfDate(Date baseDate, Date compareDate) {
        Date zbd = setZeroOclock(baseDate);
        Date zcd = setZeroOclock(compareDate);

        long diff = zcd.getTime() - zbd.getTime();

        return (int) (diff / DAY_MS);
    }

    /**
     * 두 날짜 기간 사이가 얼마나 되는지 계산
     *
     * @param baseCalendar    기준일
     * @param compareCalendar 비교일
     * @return 0이면 같은 날짜, 음수값이면 첫번째 날짜보다 두번째 날짜가 더 과거, 양수값이면 첫번째 날짜보다 두번째 날짜가 미래
     */
    public static int diffOfDate(Calendar baseCalendar, Calendar compareCalendar) {
        return diffOfDate(baseCalendar.getTime(), compareCalendar.getTime());
    }

}
