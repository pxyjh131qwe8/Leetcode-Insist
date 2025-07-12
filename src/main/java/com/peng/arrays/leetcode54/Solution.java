package com.peng.arrays.leetcode54;

import java.util.ArrayList;
import java.util.List;

//54. 螺旋矩阵

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;

        //左闭右闭
        while (left <= right && top <= bottom) {
            // 顶行：左 → 右   （含 right）
            for (int col = left; col <= right; col++) {
                res.add(matrix[top][col]);
            }
            // 右列：上 → 下   （跳过顶行，所以从 top+1 开始）
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }

            // 如果至少剩下两行两列，再走底行和左列，避免重复
            if (top < bottom && left < right) {
                // 底行：右 → 左
                for (int col = right - 1; col >= left; col--) {
                    res.add(matrix[bottom][col]);
                }
                // 左列：下 → 上
                for (int row = bottom - 1; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }

            left++;   right--;
            top++;    bottom--;
        }
        return res;
    }

}
