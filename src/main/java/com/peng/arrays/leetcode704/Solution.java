package com.peng.arrays.leetcode704;


//704.二分查找

public class Solution {
    //左闭右开
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;  //因为左闭右开，如果-1就一开始少判断了一个

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
