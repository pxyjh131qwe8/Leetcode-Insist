package com.peng.arrays.leetcode977;

//977. 有序数组的平方


import java.util.Arrays;

public class Solution {
    
    //平方后直接排序, O(n + nlogn)
//    public int[] sortedSquares(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = nums[i] * nums[i];
//        }
//        //排序
//        Arrays.sort(nums);
//        return nums;
//    }

    //双指针
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        int index = nums.length - 1;

        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[index] = nums[left] * nums[left];
                left++;
                index--;
            } else {
                res[index] = nums[right] * nums[right];
                right--;
                index--;
            }
        }
        return res;
    }
}
