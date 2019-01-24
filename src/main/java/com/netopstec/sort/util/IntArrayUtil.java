package com.netopstec.sort.util;

import java.util.Random;

/**
 * 整数数组相关的工具类
 * @author zhenye 2019/1/24
 */
public class IntArrayUtil {

    /**
     * 初始化一个正整数数组
     * @param length 数组长度
     * @param maxNum 数组中元素的最大值
     * @return 正整数数组
     */
    public static int[] initIntArrays (int length, int maxNum) {
        if (length <= 0 || maxNum <= 0) {
            throw new RuntimeException("参数非法");
        }
        int[] nums = new int[length];
        Random random = new Random();
        for(int i = 0; i < length; i++) {
            nums[i] = random.nextInt(maxNum);
        }
        return nums;
    }

    /** 交换数组中下标i与下标j的值
     * @param intArrays 目标数组
     * @param i 数组下标i
     * @param j 数组下标j
     */
    public static void exchangeValue(int[] intArrays, int i, int j) {
        // 这里交换下标i与下标j元素，不能通过加减法算出，只能通过定义临时变量来交换值
        // ！！！因为i==j时，通过加减法会把该下标元素值变为0
        int temp = intArrays[i];
        intArrays[i] = intArrays[j];
        intArrays[j] = temp;
    }
}
