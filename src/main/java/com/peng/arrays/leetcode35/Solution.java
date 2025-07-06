package com.peng.arrays.leetcode35;

//35.搜索插入位置

public class Solution {
    //左闭右开
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; //返回left -- 返回他将会被按顺序插入的位置
    }
}
