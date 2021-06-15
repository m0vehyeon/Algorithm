package me.donghyeon.baekjoon;

import java.io.*;
import java.util.*;

public class Main_bj_1325_효율적인해킹_이동현 {

    static int N, M, max;
    static boolean[] check;
    static int[] result;
    static List<List<Integer>> map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = stoi(st.nextToken()); M = stoi(st.nextToken());
        map = new ArrayList<>(N + 1);
        result = new int[N + 1];

        for (int i = 0; i <= N; i++) map.add(new ArrayList<Integer>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = stoi(st.nextToken());
            int right = stoi(st.nextToken());
            map.get(left).add(right);
        }

        for (int i = 0; i<= N; i++) {
            check = new boolean[N + 1];
            bfs(i);
        }
        for (int i = 1; i <= N; i++) {
            max = Integer.max(max, result[i]);
        }
        for (int i = 1; i <= N; i++) {
            if(max == result[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);

    }
    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        check[n] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int i : map.get(cur)) {
                if (!check[i]) {
                    check[i] = true;
                    q.offer(i);
                    result[i]++;
                }
            }
        }
    }


    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
