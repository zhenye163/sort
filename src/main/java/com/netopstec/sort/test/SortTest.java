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
        int[] nums = IntArrayUtil.initIntArrays(10, 1000);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        BubbleSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 冒泡排序测试
     */
    @Test
    public void heapSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(10, 1000);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        HeapSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 冒泡排序测试
     */
    @Test
    public void insertSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(10, 1000);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        InsertSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 冒泡排序测试
     */
    @Test
    public void mergeSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(10, 1000);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        MergeSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 冒泡排序测试
     */
    @Test
    public void quickSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(10, 1000);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        QuickSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 冒泡排序测试
     */
    @Test
    public void radixSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(10, 1000);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        RadixSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 冒泡排序测试
     */
    @Test
    public void selectSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(10, 1000);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        SelectSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }

    /**
     * 冒泡排序测试
     */
    @Test
    public void shellSortTest() {
        int[] nums = IntArrayUtil.initIntArrays(10, 1000);
        System.out.println("排序前，数组顺序为：" + Arrays.toString(nums));
        ShellSort.sort(nums);
        System.out.println("排序后，数组顺序为：" + Arrays.toString(nums));
    }
}
