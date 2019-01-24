package com.netopstec.sort.sort;

import com.netopstec.sort.util.IntArrayUtil;

/**
 * 堆排序
 * @author zhenye 2019/1/24
 */
public class HeapSort {

    public static void sort(int[] nums) {
        for(int i = nums.length; i >= 1; i--) {
            // 将数组中的前i个元素，初始化为大根堆
            initBigHeap(nums, i);
            // 堆顶元素为最大值，交换到其应该在的位置
            IntArrayUtil.exchangeValue(nums, 0, i - 1);
        }
    }

    /**
     * 将数组nums中的前i个元素，按“大根堆”的方式排序（当前节点的值不小于其左右子节点的值）
     * 下标为n的节点，其左子节点下标为2n+1,其右子节点为2n+2
     * @param nums 待排数组
     * @param i 限定的前i个元素
     */
    private static void initBigHeap(int[] nums, int i) {
        // 从最后一个有子节点的节点往前遍历，遍历过程中保证当前节点的左右子节点的值均不大于该节点的值
        // 则遍历到根节点（堆顶元素）时也保证其左右子节点的值均不大于该节点的值，则初始化成功。
        // 即从第i个元素的父节点(第i个元素的下标为i - 1,其父节点的下标为i/2 - 1)开始往前遍历：
        for(int j = i / 2 - 1;j >= 0; j--) {
            // 该节点的左右子节点下标如下：
            int leftChildIndex = 2 * j + 1;
            int rightChildIndex = 2 * j + 2;
            // 这个节点一定有左子节点，如果左子节点比当前节点大，交换
            if(nums[leftChildIndex] > nums[j]) {
                IntArrayUtil.exchangeValue(nums, j, leftChildIndex);
            }
            // 如果有右子节点且右子节点比当前节点大，交换
            if (rightChildIndex < i && nums[rightChildIndex] > nums[j]) {
                IntArrayUtil.exchangeValue(nums, j, rightChildIndex);
            }
            // 这样就保证了（左右子节点的值均不大于当前节点的值）
        }
    }
}
