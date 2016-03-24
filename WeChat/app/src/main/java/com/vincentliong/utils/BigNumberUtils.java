package com.vincentliong.utils;

import java.math.BigDecimal;

/**
 * Created by RongMa on 16/3/24.
 */
public class BigNumberUtils
{
    private BigNumberUtils(){}

    /**
     * 加
     * @param l1
     * @param l2
     * @return
     */
    public static long getlongAdd(long l1,long l2){
        BigDecimal bd1 = new BigDecimal(l1);
        BigDecimal bd2 = new BigDecimal(l2);
        BigDecimal bd3 = bd1.add(bd2);
        return bd3.longValue();
    }

    /**
     * 减
     * @param l1
     * @param l2
     * @return
     */
    public static long getlongSub(long l1,long l2){
        BigDecimal bd1 = new BigDecimal(l1);
        BigDecimal bd2 = new BigDecimal(l2);
        BigDecimal bd3 = bd1.subtract(bd2);
        return bd3.longValue();
    }

    /**
     * 乘
     * @param l1
     * @param l2
     * @return
     */
    public static long getlongMultiply(long l1,long l2){
        BigDecimal bd1 = new BigDecimal(l1);
        BigDecimal bd2 = new BigDecimal(l2);
        BigDecimal bd3 = bd1.multiply(bd2);
        return bd3.longValue();
    }


    /**
     * 除
     * @param l1
     * @param l2
     * @param point
     * @return
     */
    public static long getlongDivide(long l1,long l2,int point){
        BigDecimal bd1 = new BigDecimal(l1);
        BigDecimal bd2 = new BigDecimal(l2);
        BigDecimal bd3 = bd1.divide(bd2,point,0); //point为小数点后几位
        return bd3.longValue();
    }
}
