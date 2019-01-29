# 八大排序算法

<font color="red">程序 = 数据结构 + 算法</font>。<br/>
设计优良程序的两个要点：选用正确的存储结构、采用合理的解决方案。<br/>
算法说的就是“解决方案”。而排序，是一种非常常见的业务场景，如：“前100名下单的打八折”、“成绩前三的获一等奖”、“绩效最差的扣工资”等等。但排序的实现有很多不同的解决方案，不同的解决方案需要的运算时间和存储空间不同。<br/>
这里说的八大排序算法，都是内部排序（不需要额外的空间存储数据，所有运算时存储的数据都是放在内存中）。他们分别是：<font color="red">冒泡排序、堆排序、直接插入排序、归并排序、快速排序、基数排序、简单选择排序、希尔排序。</font><br/>
接下来，我们来学习并归纳这八种排序的思想以及Java实现。<br/>
具体的Java实现以及测试代码详见于[我的Github](https://github.com/zhenye163/sort)。

由于这些排序里面有一些公用的方法，预先新建工具类如下：

```JAVA
/**
 * 整数数组相关的工具类
 * @author zhenye 2019/1/24
 */
public class IntArrayUtil {

  /**
    * 初始化一个正整数数组
    * @param length 数组长度
    * @param maxNum 数组中元素的最大值
    * @return 正整数数组
    */
  public static int[] initIntArrays (int length, int maxNum) {
    if (length <= 0 || maxNum <= 0) {
      throw new RuntimeException("参数非法");
    }
    int[] nums = new int[length];
    Random random = new Random();
    for(int i = 0; i < length; i++) {
      nums[i] = random.nextInt(maxNum);
    }
    return nums;
  }

  /** 交换数组中下标i与下标j的值
    * @param intArrays 目标数组
    * @param i 数组下标i
    * @param j 数组下标j
    */
  public static void exchangeValue(int[] intArrays, int i, int j) {
    intArrays[i] = intArrays[i] ^ intArrays[j];
    intArrays[j] = intArrays[i] ^ intArrays[j];
    intArrays[i] = intArrays[i] ^ intArrays[j];
  }
}
```

## 冒泡排序

基本思想：从前往后比较相邻的两个元素，如果左边元素比右边元素大，交换左右元素。即每轮比较完后，最大值都能到最右边。当所有的轮次比较完后，就是从小到大的顺序。

图解冒泡排序如下图：

![图解冒泡排序](images/1.png)

冒泡排序的java实现如下：

```JAVA
/**
 * 冒泡排序
 * @author zhenye 2019/1/24
 */
public class BubbleSort {

  public static void sort(int[] nums) {
    for(int i = 0;i < nums.length;i++) {
      for(int j = 0; j < nums.length - i - 1;j++) {
        if(nums[j] > nums[j+1]) {
          int temp = nums[j];
          nums[j] = nums[j+1];
          nums[j+1] = temp;
        }
      }
    }
  }
}
```

冒泡排序的执行结果如下图所示：

![冒泡排序的执行结果图](images/2.png)

## 堆排序

基本思想：堆是一颗顺序存储的完全二叉树。每个节点的值都不大于其子节点的值，这样的称之为“小根堆”，反之则称之为“大根堆”。因此“大根堆”的堆顶元素就是这个堆的最大值。利用将无序序列初始化为“大根堆”，取出其堆顶元素作为最大值，然后将剩余的元素看做无序序列，并再次变为“大根堆”并取出其堆顶元素。重复迭代直到无序序列只有一个元素即排序完毕。

堆排序的java实现如下：

```JAVA
/**
 * 堆排序
 * @author zhenye 2019/1/24
 */
public class HeapSort {

  public static void sort(int[] nums) {
    // 预先初始化为大根堆
    initBigHeap(nums);
    for(int i = nums.length; i >= 1; i--) {
      // 堆顶元素为最大值，交换到其应该在的位置
      IntArrayUtil.exchangeValue(nums, 0, i - 1);
      // 重新调整，保证数组的前i个元素符合大根堆
      adjustBigHeap(nums, 0, i);
    }
  }

  /**
    * 将数组初始化为大根堆
    * @param nums 待排数组
    */
  private static void initBigHeap(int[] nums) {
    // 从最后一个有子节点的节点往前遍历，遍历过程中保证当前节点的左右子节点的值均不大于该节点的值
    // 则遍历到根节点（堆顶元素）时也保证其左右子节点的值均不大于该节点的值，则初始化成功。
    // 即从第i个元素的父节点(第i个元素的下标为i - 1,其父节点的下标为i/2 - 1)开始往前遍历：
    for(int i = nums.length / 2 - 1;i >= 0; i--) {
      adjustBigHeap(nums,i,nums.length);
    }
  }

  /**
    * 保证数组nums的前count个元素中，下标为parent的节点及其子孙节点符合大根堆要求
    * @param nums 待排数组
    * @param parentIndex 目标节点
    * @param count 待排元素个数（nums数组的前count个元素）
    */
  private static void adjustBigHeap(int[] nums, int parentIndex, int count) {
    int leftChildIndex = 2 * parentIndex + 1;
    int rightChildIndex = 2 * parentIndex + 2;
    while(leftChildIndex < count) {
      int toBeComparedIndex;
      // 如果j节点有右子节点，且右子节点比左子节点的值大，则j节点跟右子节点比较，否则跟左子节点比较
      if (rightChildIndex < count && nums[rightChildIndex] > nums[leftChildIndex]) {
        toBeComparedIndex = rightChildIndex;
      } else {
        toBeComparedIndex = leftChildIndex;
      }
      if (nums[toBeComparedIndex] > nums[parentIndex]) {
        IntArrayUtil.exchangeValue(nums, parentIndex, toBeComparedIndex);
        // 交换后，然后还要保证交换后的节点也符合大根堆要求
        adjustBigHeap(nums, toBeComparedIndex, count);
      } else {
        // 当父节点是最大时，停止递归
        break;
      }
    }
  }
}
```

图解堆排序如下图：

1. 如果将一个无序序列，初始化为一个“大根堆”，如下图：

![大根堆初始化](images/3.png)

2. 将堆顶元素与最后一个元素交换，将剩余的n-1个元素的无序序列再次初始化为
“大根堆”，并重复。

![大根堆排序](images/4.png)

堆排序的执行结果如下图所示：

![堆排序的执行结果图](images/5.png)

## 直接插入排序

基本思想：将n个待排序的元素分成一个有序表和一个无序表。开始时有序表只包含第一个元素，无序表包含后面的n-1个元素。排序过程中每次从无序表中取出第一个元素，并直接插入有序表中的合适位置。重复n-1次即排序完毕。

直接插入排序的java实现如下：

```JAVA
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
```