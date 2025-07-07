package com.peng.arrays.leetcode26;

import java.util.HashMap;

//26.删除有序数组中的重复项

public class Solution {
    //27题自己演化来的解法，重要的就是明确要删除的val是什么，这里维护一个不重复的哈希表
//    public int removeDuplicates(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int count = 0;
//        for (int left = 0, right = 0; right < nums.length; right++) {
//            if (!map.containsKey(nums[right])) {
//                map.put(nums[right], 1);
//                nums[left] = nums[right];
//                left++;
//                count++;
//            }
//        }
//
//        return count;
//    }

    //优化版，利用数组有序的特性，重复元素的下标必然是连续的，如果nums[fast] != nums[fast-1]，说明nums[fast]和之前的元素都不相同
    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int slow = 1, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast-1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;  //此时slow即是剩余数组的长度
    }
}
