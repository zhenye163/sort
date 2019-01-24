package com.netopstec.sort.sort;

/**
 * 简单选择排序
 * @author zhenye 2019/1/24
 */
public class SelectSort {

    public static void sort(int[] nums) {
        int i,j,temp;
        for(i = 0; i < nums.length; i++) {
            int minValueIndex = i;
            for (j = i;j < nums.length; j++) {
                if (nums[minValueIndex] > nums[j]) {
                    minValueIndex = j;
                }
            }
            temp = nums[minValueIndex];
            nums[minValueIndex] = nums[i];
            nums[i] = temp;
        }
    }
}
