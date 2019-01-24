package com.netopstec.sort.sort;

import com.netopstec.sort.util.IntArrayUtil;

/**
 * 快速排序
 * @author zhenye 2019/1/24
 */
public class QuickSort {

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
        int i = start;
        int j = end;
        while(i != j) {
            // ！！！这里一定要右边的哨兵先走。
            /*
             因为最终与基准数交换的是左哨兵。也就是说本轮循环结束时，左哨兵当前元素一定要比基准数小。
             而这里循环结束的条件有一个是左右哨兵相遇。
             如果左哨兵先行，当左右哨兵由于相遇循环结束时，左右哨兵的当前元素是基于右哨兵上次循环结束的位置。
             即此时左右哨兵所在位置的当前元素是比基准数大的！！！将该元素与基准数交换是不对的。
             */
            // 找到右边比基准数小的元素下标
            while(i < j && intArrays[j] >= base) {
                j--;
            }
            // 找到左边比基准数大的元素下标
            while (i < j && intArrays[i] <= base) {
                i++;
            }
            if (i < j) {
                // 交换，保证哨兵i左边的元素都比基准数小，哨兵j右边的元素都比基准数大
                IntArrayUtil.exchangeValue(intArrays, i, j);
            }
        }
        // 交换，保证基准数在正确的位置
        IntArrayUtil.exchangeValue(intArrays, start, i);
        // 下一次，迭代（两个子序列分别进行快速排序）
        quickSort(intArrays, start, i - 1);
        quickSort(intArrays, j + 1, end);
    }

}
