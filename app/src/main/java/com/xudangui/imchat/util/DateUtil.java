package com.xudangui.imchat.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xudangui on 2018/4/15.
 */

public class DateUtil {

    public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";

    public static final String yyyyMMdd = "yyyy-MM-dd";

    public static final String HHmmss = "HH:mm:ss";

    public static final String HHmm = "HH:mm";

    public static String parseDateToString(Date date,String formatter){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatter);
        String dateStr = simpleDateFormat.format(date);
        return dateStr;
    }

    public static Date parseStringToDate(String date){
        Date dateResult = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.yyyyMMddHHmmss);
        try {
            dateResult = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateResult;
    }

}
