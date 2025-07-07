package com.peng.arrays.leetcode27;

//27.移除元素

public class Solution {
    //双指针
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                count++;
                left++;
            }
        }

        return count;

    }
}
