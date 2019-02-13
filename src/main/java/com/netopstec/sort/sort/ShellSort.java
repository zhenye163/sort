package com.netopstec.sort.sort;

/**
 * 希尔排序
 * @author zhenye 2019/1/24
 */
public class ShellSort {
    /**
     * 提供给开发者使用的希尔排序
     * @param nums 待排序列
     */
    public static void sort(int[] nums) {
        // i为无序表中的元素下标，j为有序表中的元素下标，temp是待插入元素，increment为增量。
        int i, j, temp, increment;
        for(increment = nums.length / 2;increment >= 1; increment = increment / 2){
            for(i = increment; i < nums.length; i++) {
                temp = nums[i];
                j = i - increment;
                for(;j >= 0 && temp < nums[j];j -= increment) {
                    nums[j + increment] = nums[j];
                }
                nums[j + increment] = temp;
            }
        }
    }
}
