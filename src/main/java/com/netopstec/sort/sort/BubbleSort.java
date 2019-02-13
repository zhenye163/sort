package com.netopstec.sort.sort;

import com.netopstec.sort.util.IntArrayUtil;

/**
 * 冒泡排序
 * @author zhenye 2019/1/24
 */
public class BubbleSort {

    public static void sort(int[] nums) {
        for(int i = 0;i < nums.length;i++) {
            for(int j = 0; j < nums.length - i - 1;j++) {
                if(nums[j] > nums[j+1]) {
                    IntArrayUtil.exchangeValue(nums, j, j+1);
                }
            }
        }
    }
}
