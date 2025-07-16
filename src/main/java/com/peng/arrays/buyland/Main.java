package com.peng.arrays.buyland;

//开发商买土地

import java.util.Scanner;

public class Main {
    //前缀和的运用
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] vec = new int[n][m];

        //先计算总和
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vec[i][j] = scanner.nextInt();
                sum += vec[i][j];
            }
        }

        //计算每一行的和，统计横向
        int[] horizontal = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                horizontal[i] += vec[i][j];
            }
        }

        //计算每一列的和，统计纵向
        int[] vertical = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                vertical[j] += vec[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        //如果按横向分割
        int horizontalCut = 0;
        for (int i = 0; i < n; i++) {
            //行间和
            horizontalCut += horizontal[i];
            result = Math.min(Math.abs((sum - horizontalCut) - horizontalCut), result);
        }

        //如果按列向分割
        int verticalCut = 0;
        for (int j = 0; j < m; j++) {
            verticalCut += vertical[j];
            result = Math.min(Math.abs((sum - verticalCut) - verticalCut), result);
        }

        System.out.println(result);
        scanner.close();
    }
}
