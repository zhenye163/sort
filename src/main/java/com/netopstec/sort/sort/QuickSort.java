package com.netopstec.sort.sort;

import com.netopstec.sort.util.IntArrayUtil;

/**
 * 快速排序
 * @author zhenye 2019/1/24
 */
public class QuickSort {

    /**
     * 提供给开发者使用的快速排序
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        quickSort(nums, 0 , nums.length - 1);
    }

    /**
     * 对下标从start到end的正整数数组intArrays进行快速排序
     * @param intArrays 将要排序的数组intArrays
     * @param start 数组起始下标位置
     * @param end 数组截止下标位置
     */
    private static void quickSort(int[] intArrays, int start, int end) {
        if(start > end) {
            return;
        }
        // 将数组起始下标位置的元素，作为基准数
        int base = intArrays[start];
        // 将i看作从左往右搜索的哨兵，j看作从右往左搜索的哨兵
        int left = start;
        int right = end;
        while(left != right) {
            // ！！！因为选取的基准数是左哨兵的起始位置，这里一定要右边的哨兵先走。
            /*
             这里循环结束的条件有一个是左右哨兵相遇。
             如果左哨兵先行，出现由于左哨兵找到了右哨兵（相遇）导致循环结束的情况时，
             左右哨兵的当前元素是基于右哨兵上次循环结束的位置。
             即此时左右哨兵相遇位置的当前元素是比基准数大的！！！将该元素与基准数交换是不对的。
             */
            // 找到右边比基准数小的元素下标（或哨兵相遇）
            while(left < right && intArrays[right] >= base) {
                right--;
            }
            // 找到左边比基准数大的元素下标（或哨兵相遇）
            while (left < right && intArrays[left] <= base) {
                left++;
            }
            if (left < right) {
                // 交换，保证哨兵i左边的元素都比基准数小，哨兵j右边的元素都比基准数大
                IntArrayUtil.exchangeValue(intArrays, left, right);
            }
        }
        // 交换，保证基准数在正确的位置
        IntArrayUtil.exchangeValue(intArrays, start, right);
        // 下一次，迭代（两个子序列分别进行快速排序）
        quickSort(intArrays, start, right - 1);
        quickSort(intArrays, right + 1, end);
    }
}
