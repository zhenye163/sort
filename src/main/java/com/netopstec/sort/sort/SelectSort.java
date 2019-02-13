package com.netopstec.sort.sort;

import com.netopstec.sort.util.IntArrayUtil;

/**
 * 简单选择排序
 * @author zhenye 2019/1/24
 */
public class SelectSort {
    /**
     * 提供给开发者使用的简单选择排序
     * @param nums 待排序列
     */
    public static void sort(int[] nums) {
        int i,j;
        for(i = 0; i < nums.length; i++) {
            int minValueIndex = i;
            for (j = i;j < nums.length; j++) {
                if (nums[minValueIndex] > nums[j]) {
                    minValueIndex = j;
                }
            }
            IntArrayUtil.exchangeValue(nums, i, minValueIndex);
        }
    }
}
