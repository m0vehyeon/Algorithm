package me.donghyeon.baekjoon;

import java.util.*;
import java.io.*;

public class Main_bj_16395_파스칼의삼각형_이동현 {
    static int N, K;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); K = stoi(st.nextToken());

        dp = new int[31][31];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        int end = 3;
        for (int i = 3; i < 31; i++) {
            for (int j = 1; j <= end; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
            end++;
        }
        System.out.println(dp[N][K]);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
