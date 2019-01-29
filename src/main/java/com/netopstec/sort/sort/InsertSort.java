package com.netopstec.sort.sort;

/**
 * 直接插入排序
 * @author zhenye 2019/1/24
 */
public class InsertSort {

    public static void sort(int[] nums) {
        // i为无序表中的元素下标，temp是待插入元素。
        int i,temp;
        for(i = 1;i < nums.length;i++) {
            temp = nums[i];
            // k记录的是待插入元素应该在数组中位置的下标
            int k;
            // 比待插入元素大的元素右移，否则就是找到待插入元素的正确位置k
            for(k = i;k > 0 && nums[k - 1] > temp;k-- ) {
                nums[k] = nums[k - 1];
            }
            nums[k] = temp;
        }
    }
}
