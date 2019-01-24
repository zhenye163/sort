package com.netopstec.sort.sort;

/**
 * 归并排序
 * @author zhenye 2019/1/24
 */
public class MergeSort {

    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 归并算法
     * @param nums 待排序列
     * @param start 数组起始下标
     * @param end 数组截止下标
     */
    private static void mergeSort(int[] nums, int start, int end) {
        // 当[start ... end]数组可以拆分(不只一个元素)时，需要再次拆分
        if(start < end) {
            // 拆分成[start ... mid],[mid + 1 ... end]两个更小的数组）
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            // 将两个小的有序数组，合并为一个大的有序数组
            merge(nums, start, mid, end);
        }
    }

    /**
     * 将两个小的有序数组，合并为一个大的有序数组
     */
    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[nums.length];
        // 定义两个旗帜i,j(旗帜i在数组[start ... mid]移动，旗帜j在数组[mid + 1 ... end]移动)
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if(nums[i] > nums[j]) {
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        // 将临时数组copy到原数组的相应位置
        for(k = 0;start <= end; start++, k++) {
            nums[start] = temp[k];
        }
    }
}
