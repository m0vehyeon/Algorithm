package me.donghyeon.baekjoon;


import java.util.*;
import java.io.*;

public class Main_bj_9375_패션왕신해빈_이동현 {
    static boolean[] check;
    static String[][] wears;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        for (int t = 0; t < T; t++) {
            N = stoi(br.readLine());
            wears = new String[N][N];
            check = new boolean[N];
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0 ; i < N; i++) {
                wears[i] = br.readLine().split(" ");
                map.put(wears[i][1],map.getOrDefault(wears[i][1],0) + 1);
            }
            Count.count = 1;
            map.forEach((k, v) -> {
                Count.count *= (v + 1);
            });
            System.out.println(Count.count - 1);
        }
    }
    public static class Count {
        public static int count;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
