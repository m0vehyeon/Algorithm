package me.donghyeon.baekjoon;

import java.util.*;
import java.io.*;

public class Main_bj_1359_복권_이동현 {
    static double[][] dp;
    static int N, M, K;
    static double result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new double[9][9];
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        int end = 2;
        for (int i = 2; i <= 8; i++) {
            for (int j = 0; j <= end; j++) {
                if (j == 0 || j == end) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
            end++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken()); M = stoi(st.nextToken());
        K = stoi(st.nextToken());
        while(M >= K) {
            if (N-M < M-K) {
                K++;
                continue;
            }
            double percent = dp[M][K] * dp[N-M][M-K] / dp[N][M];

            result += percent;
            K++;
        }

        System.out.println(result);
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
