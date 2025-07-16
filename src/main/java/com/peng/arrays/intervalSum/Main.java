package com.peng.arrays.intervalSum;

//区间和

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] tempSum = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
            tempSum[i] = sum;
        }

        while (in.hasNextInt()) {
            int start = in.nextInt();
            int end = in.nextInt();

            int diff = 0;
            if (start == 0 ) {
                diff = tempSum[end];
            } else {
                diff = tempSum[end] - tempSum[start - 1];
            }

            System.out.println(diff);
        }

        in.close();
    }
}
