package com.peng.arrays.leetcode34;


//34.在排序数组中查找元素的第一个和最后一个位置

public class Solution {
    //左闭右开
    public int[] searchRange(int[] nums, int target) {
        int left = lowerBound(nums, target);
        int right = upperBound(nums, target);
        if (left == nums.length || nums[left] > target) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right-1};
    }

    //先找左边界，第一个大于等于target的值
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;  // 循环退出时 left == right
    }

    //再找右边界，应该是最后一个等于target的下标，upperBound 给出的是 再往右一格 的位置，我们的右边开区间最后要-1
    private int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left; // 返回值即“超尾一格”
    }
}
