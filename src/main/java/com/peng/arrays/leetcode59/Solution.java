package com.peng.arrays.leetcode59;

// 螺旋矩阵II

public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startX = 0, startY = 0; // 行和列的起始位置
        int offset = 1;
        int count = 1; //矩阵中需要填写的数
        int loop = 1; //当前圈数
        int i, j;  //迭代i代表行，j代表列

        //遵循左闭右开
        while (loop <= n/2) {
            //顶部
            for (j = startY; j < n - offset; j++) {
                matrix[startX][j] = count++;
            }

            //右列
            for (i = startX; i < n - offset; i++) {
                matrix[i][j] = count++;
            }

            //底部
            for (; j > startY; j--) {
                matrix[i][j] = count++;
            }

            //左列
            for (; i > startX; i--) {
                matrix[i][j] = count++;
            }

            startX++;
            startY++;
            loop++;
            offset++;
        }

        //n为奇数时，单独处理中心值
        if (n % 2 != 0) {
            matrix[startX][startY] = count;
        }

        return matrix;
    }
}
