package com.peng.arrays.leetcode69;

//x 的平方根

public class Solution {

    //维护一个左闭右开的区间 [0 , x + 1)
    //把 right 设成 x+1，可保证 right 一直指向“比解大 1” 的位置，避免最后还要判边界
    //目标是找到最后一个平方小于等于x的下标，等价于找到第一个大于x的下标-1
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        long left = 0, right = (long)x + 1; //避免溢出用long
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int)left - 1;
    }
}
