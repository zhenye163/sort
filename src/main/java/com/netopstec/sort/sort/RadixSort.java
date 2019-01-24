package com.netopstec.sort.sort;

/**
 * 基数排序
 * @author zhenye 2019/1/24
 */
public class RadixSort {

    public static void sort(int[] nums) {
        int maxBit = getMaxBit(nums);
        // temp临时二维数组，列是余数（0-9），行是0或者待排序列中元素的值
        int[][] temp = new int[10][nums.length];
        // order对应下标，即待排序列元素对应余数的个数
        int[] order = new int[10];
        int n = 1;
        int m = 1;
        int k = 0;
        while(m <= maxBit) {
            for (int num : nums) {
                int reminder = (num / n) % 10;
                // 将余数为reminder的元素归到二维数组temp的第reminder列，并记录此时第reminder列元素的个数order[reminder]
                temp[reminder][order[reminder]] = num;
                order[reminder]++;
            }
            // 重排待排序列
            for(int i = 0; i < order.length;i++) {
                if (order[i] != 0) {
                    for(int j = 0;j < order[i];j++) {
                        nums[k] = temp[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            // 重置相关变量
            n *= 10;
            k = 0;
            m++;
        }
    }

    /**
     * 找到数组中最大值的位数（如：{32,43,101,2}的最大值是101，位数是3）
     * @param nums 给定数组
     * @return 数组中最大值位数
     */
    private static int getMaxBit(int[] nums) {
        int max = nums[0];
        for(int i = 1;i < nums.length;i++) {
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int maxBit;
        for(maxBit = 1; max >= 10; maxBit++){
            max = max / 10;
        }
        return maxBit;
    }
}
