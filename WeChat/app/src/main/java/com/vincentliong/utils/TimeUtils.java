package com.vincentliong.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by RongMa on 16/3/24.
 */
public class TimeUtils
{
    private TimeUtils(){}

    /**
     * 处理时间文本
     * @param timeFromWeb
     * @return
     */
    public static String getTimeText(String timeFromWeb)
    {
        //获取时间文本中的日期
        int webTimeDay = Integer.parseInt(timeFromWeb.substring(8,10));
        //获取月份
        int webTimeMonth = Integer.parseInt(timeFromWeb.substring(5,7));
        //获取年份
        int webTimeYear = Integer.parseInt(timeFromWeb.substring(0, 4));
        //获取时间
        String webTimeText = timeFromWeb.substring(11, 16);
        int webHour = Integer.parseInt(timeFromWeb.substring(11,13));
        int webMinute = Integer.parseInt(timeFromWeb.substring(14, 16));
        //将日期转换为long
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date webDate = sdf.parse(timeFromWeb);
            long webTime = BigNumberUtils.getlongDivide(webDate.getTime(), 1000l, 0);
            long timeNow = BigNumberUtils.getlongDivide(System.currentTimeMillis(), 1000l, 0);
            String dateNowText = sdf.format(new Date(timeNow));
            int nowTimeDay = Integer.parseInt(dateNowText.substring(8, 10));
            int nowTimeYear = Integer.parseInt(dateNowText.substring(0,4));
            if(BigNumberUtils.getlongSub(timeNow,webTime) <= 60*60*24)
            {
                if(nowTimeDay == webTimeDay)
                {
                    return webTimeText;
                }
                else
                {
                    return "昨天";
                }
            }
            else if(BigNumberUtils.getlongSub(timeNow,webTime) <= 60*60*24)
            {
                if(nowTimeDay - webTimeDay < 1)
                {
                    return "昨天";
                }
                else
                {
                    return webTimeMonth+"月"+webTimeDay+"日";
                }
            }
            else if(nowTimeYear == webTimeYear)
            {
                return webTimeMonth+"月"+webTimeDay+"日";
            }
            else
            {
                return webTimeYear+"年"+webTimeMonth+"月"+webTimeDay+"日";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
