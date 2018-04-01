package com.example.ling.review.sort;

/**
 * ***************************************
 * statement:  冒泡排序   623514 --> 123456
 * author: LingGuiQin
 * date created : 2018/3/7 0007
 * ***************************************
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] num = new int[]{6, 2, 3, 5, 1, 4};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(num);
    }

    public void print(int[] nums) {
        System.out.print(nums.toString());
    }


    public void sort(int[] nums) {
        int length = nums.length;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    print(nums);
                }
            }
        }

    }


    /*
    * 冒泡排序优化一
    * 设置一个标记来标志一趟比较是否发生交换
    * 如果没有发生交换，则数组已经有序
    * */
    public void sort2(int[] nums) {
        int length = nums.length;
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                    print(nums);
                }
            }
            if (!flag) {
                break;
            }
        }

    }

 /*
 * 冒泡排序优化二
 * 用一个变量记录下最后一个发生交换的位置，后面没有发生交换的已经有序
 * 所以可以用这个值来作为下一次比较结束的位置
 * */

    public void sort3(int[] nums) {
        int length = nums.length;
        int temp = 0;
        int flag = 0;
        int k = length;
        for (int i = 0; i < length; i++) {
            k = flag;
            flag = 0;
            for (int j = 0; j < k; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = j;
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

    }

}
