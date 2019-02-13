package com.netopstec.sort.util;

import java.util.Arrays;
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
        // 如果i==j，通过这种方法交换，会将当前位置的值重置为0
        if(i == j) {
            return;
        }
        intArrays[i] = intArrays[i] ^ intArrays[j];
        intArrays[j] = intArrays[i] ^ intArrays[j];
        intArrays[i] = intArrays[i] ^ intArrays[j];
    }
}
