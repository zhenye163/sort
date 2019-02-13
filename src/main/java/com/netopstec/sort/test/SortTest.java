package com.netopstec.sort.test;

import com.netopstec.sort.sort.*;
import com.netopstec.sort.util.IntArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 测试算法的类
 * @author zhenye 2019/1/24
 */
public class SortTest {

    /**
     * 冒泡排序测试
     */
    @Test
    public void bubbleSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(5, 10);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        BubbleSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 堆排序测试
     */
    @Test
    public void heapSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(10, 10);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        HeapSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 直接插入排序测试
     */
    @Test
    public void insertSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(6, 100);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        InsertSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 归并排序测试
     */
    @Test
    public void mergeSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(8, 100);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        MergeSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 快速排序测试
     */
    @Test
    public void quickSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(8, 100);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        QuickSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 基数排序测试
     */
    @Test
    public void radixSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(10, 1000);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        RadixSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 简单选择排序测试
     */
    @Test
    public void selectSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(5, 100);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        SelectSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 希尔排序测试
     */
    @Test
    public void shellSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(8, 100);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        ShellSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }


    /**
     * 各排序算法的性能测试
     */
    @Test
    public void speedTest() {
        int[] initIntArrays = IntArrayUtil.initIntArrays(100000,10000);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(initIntArrays));
        int[] toBubbleSort = initIntArrays.clone();
        Long toBubbleSortStart = System.currentTimeMillis();
        BubbleSort.sort(toBubbleSort);
        Long toBubbleSortEnd = System.currentTimeMillis();
        System.out.println("冒泡排序耗时：" + (toBubbleSortEnd - toBubbleSortStart) + "毫秒。");
        System.out.println("----------------------------------------------------");
        int[] toHeapSort = initIntArrays.clone();
        Long toHeapSortStart = System.currentTimeMillis();
        HeapSort.sort(toHeapSort);
        Long toHeapSortEnd = System.currentTimeMillis();
        System.out.println("堆排序耗时：" + (toHeapSortEnd - toHeapSortStart) + "毫秒。");
        System.out.println("----------------------------------------------------");
        int[] toInsertSort = initIntArrays.clone();
        Long toInsertSortStart = System.currentTimeMillis();
        InsertSort.sort(toInsertSort);
        Long toInsertSortEnd = System.currentTimeMillis();
        System.out.println("直接插入排序耗时：" + (toInsertSortEnd - toInsertSortStart) + "毫秒。");
        System.out.println("----------------------------------------------------");
        int[] toMergeSort = initIntArrays.clone();
        Long toMergeSortStart = System.currentTimeMillis();
        MergeSort.sort(toMergeSort);
        Long toMergeSortEnd = System.currentTimeMillis();
        System.out.println("归并排序耗时：" + (toMergeSortEnd - toMergeSortStart) + "毫秒。");
        System.out.println("----------------------------------------------------");
        int[] toQuickSort = initIntArrays.clone();
        Long toQuickSortStart = System.currentTimeMillis();
        QuickSort.sort(toQuickSort);
        Long toQuickSortEnd = System.currentTimeMillis();
        System.out.println("快速排序耗时：" + (toQuickSortEnd - toQuickSortStart) + "毫秒。");
        System.out.println("----------------------------------------------------");
        int[] toRadixSort = initIntArrays.clone();
        Long toRadixSortStart = System.currentTimeMillis();
        RadixSort.sort(toRadixSort);
        Long toRadixSortEnd = System.currentTimeMillis();
        System.out.println("基数排序耗时：" + (toRadixSortEnd - toRadixSortStart) + "毫秒。");
        System.out.println("----------------------------------------------------");
        int[] toSelectSort = initIntArrays.clone();
        Long toSelectSortStart = System.currentTimeMillis();
        SelectSort.sort(toSelectSort);
        Long toSelectSortEnd = System.currentTimeMillis();
        System.out.println("简单选择排序耗时：" + (toSelectSortEnd - toSelectSortStart) + "毫秒。");
        System.out.println("----------------------------------------------------");
        int[] toShellSort = initIntArrays.clone();
        Long toShellSortStart = System.currentTimeMillis();
        ShellSort.sort(toShellSort);
        Long toShellSortEnd = System.currentTimeMillis();
        System.out.println("希尔排序耗时：" + (toShellSortEnd - toShellSortStart) + "毫秒。");
    }

}
