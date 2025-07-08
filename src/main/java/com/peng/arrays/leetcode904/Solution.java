package com.peng.arrays.leetcode904;

//904. 水果成篮
//题目转化为相当于要求一个数组中最长只含两个元素的最长子数组

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //滑动窗口
    public int totalFruit(int[] fruits) {
        //统计窗口内每个数出现的个数
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, maxLen = Integer.MIN_VALUE;

        for (int right = 0; right < fruits.length; right++) {
            if (map.containsKey(fruits[right])) {
                map.put(fruits[right], map.get(fruits[right]) + 1);
            } else {
                map.put(fruits[right], 1);
            }

            //查看key的个数是否大于2，如果是的话要移动左端点
            while (map.size() > 2) {
                //移动左端点，个数-1，一直到0就移除这个数
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
