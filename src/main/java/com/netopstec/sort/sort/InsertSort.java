package com.netopstec.sort.sort;

/**
 * 直接插入排序
 * @author zhenye 2019/1/24
 */
public class InsertSort {

    public static void sort(int[] nums) {
        // i为无序表中的元素下标，j为有序表中的元素下标，temp是待插入元素。
        int i,j,temp;
        for (i = 1;i < nums.length;i++) {
            // 此时第i个元素为无序表的第一个元素（待插入元素）
            temp = nums[i];
            // 此时第j个元素为有序表的最后一个元素（有序表最大值下标）
            j = i - 1;
            for(;j >= 0 && temp < nums[j]; j--) {
                // 当有序表中较大值比“待插入元素”大的元素，需要后移一位
                nums[j + 1] = nums[j];
            }
            // 此时（第j个元素 不大于 “待插入元素”），因此其正确下标应该是（j+1）
            nums[j + 1] = temp;
        }
    }
}
