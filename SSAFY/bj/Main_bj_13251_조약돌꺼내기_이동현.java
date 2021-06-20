package me.donghyeon.baekjoon;

import java.util.*;
import java.io.*;

public class Main_bj_13251_조약돌꺼내기_이동현 {
    static int[] colors;
    static double[][] dp;
    static int M, K, total;
    static double result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        colors = new int[M];
        for (int i = 0; i < M; i++) {
            colors[i] = stoi(st.nextToken());
            total += colors[i];
        }
        K = stoi(br.readLine());

        initCombi();
        double sum = 0;
        for (int i = 0; i < M; i++) {
            sum += dp[colors[i]][K];
        }
        System.out.println(sum / dp[total][K]);

    }
    static void initCombi() {
        dp = new double[2501][2501];
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        int end = 2;
        for (int i = 2; i <= 2500; i++) {
            for (int j = 0; j <= end; j++) {
                if (j == 0 || j == end) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
            end++;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
