package me.donghyeon.baekjoon;

import java.util.*;
import java.io.*;

public class Main_bj_11050_이항계수1_이동현 {
    static int N, K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); K = stoi(st.nextToken());

        System.out.println(fac(N) / (fac(N-K) * fac(K)));
    }
    static int fac(int n) {
        if (n <= 1) return 1;
        return n * fac(n-1);
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
