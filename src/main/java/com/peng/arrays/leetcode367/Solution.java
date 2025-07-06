package com.peng.arrays.leetcode367;

//有效的完全平方数

public class Solution {

    //左闭右开区间
    public boolean isPerfectSquare(int num) {
        long left = 0, right = num+1;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return false;
    }
}
