package me.donghyeon.baekjoon;

import java.util.*;
import java.io.*;

public class Main_bj_1010_다리놓기_이동현 {
    static int[][] dp;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
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
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = stoi(st.nextToken()); N = stoi(st.nextToken());
            System.out.println(dp[N][M]);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
