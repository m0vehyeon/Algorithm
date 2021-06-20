package me.donghyeon.baekjoon;

import java.util.*;
import java.io.*;

public class Main_bj_15489_파스칼삼각형_이동현 {
    static int[][] dp;
    static int R, C, W;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = stoi(st.nextToken()); C = stoi(st.nextToken());
        W = stoi(st.nextToken());

        dp = new int[31][31];
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        int end = 2;
        for (int i = 2; i <= 30; i++) {
            for (int j = 0; j <= end; j++) {
                if (j == 0 || j == end) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
            end++;
        }
        int num = 0;
        long sum = 0;
        for (int i = R - 1; i < R + W - 1; i++) {
            for (int j = C - 1; j < C + num; j++) {
                sum += dp[i][j];
            }
            num++;
        }
        System.out.println(sum);
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
