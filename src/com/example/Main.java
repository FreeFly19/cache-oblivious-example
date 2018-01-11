package com.example;

import java.util.Random;

public class Main {
    static final int M = 1000;
    static final int N = 10000;

    public static void main(String[] args) {
        int[][] arr = new int[M][N];
        Random random = new Random();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = random.nextInt(100);
            }
        }

        long rowMajorTime = 0;
        long columnMajorTime = 0;

        int sum = 0;
        for (int k = 0; k < 100; k++) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    sum += arr[i][j];
                }
            }
            rowMajorTime += System.currentTimeMillis() - start;

            start = System.currentTimeMillis();
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < M; i++) {
                    sum += arr[i][j];
                }
            }
            columnMajorTime += System.currentTimeMillis() - start;
        }


        System.out.println("Row Major Time: "+ rowMajorTime);
        System.out.println("Column Major Time: "+ columnMajorTime);
    }
}
