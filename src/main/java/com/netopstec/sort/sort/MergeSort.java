package com.netopstec.sort.sort;

/**
 * 归并排序
 * @author zhenye 2019/1/24
 */
public class MergeSort {

    /**
     * 提供给开发者使用的归并排序
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    /**
     * 归并算法的具体实现
     * @param nums 待排序列
     * @param start 数组起始下标
     * @param end 数组截止下标
     * @param temp 临时数组
     */
    private static void mergeSort(int[] nums, int start, int end, int[] temp) {
        // 当[start ... end]数组可以拆分(不只一个元素)时，需要再次拆分
        if(start < end) {
            // 拆分成[start ... mid],[mid + 1 ... end]两个更小的数组）
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid, temp);
            mergeSort(nums, mid + 1, end, temp);
            // 将两个小的有序数组，合并为一个大的有序数组
            merge(nums, start, mid, end, temp);
        }
    }

    /**
     * 将两个小的有序数组，合并为一个大的有序数组
     */
    private static void merge(int[] nums, int start, int mid, int end, int[] temp) {
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
