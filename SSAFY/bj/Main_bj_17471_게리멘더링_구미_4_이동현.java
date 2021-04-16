package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_17471_게리멘더링_구미_4_이동현 {
	static int N , min = Integer.MAX_VALUE;
	static int[][] map;
	static int[] popul;
	static boolean[] check,visit;
	static List<Integer> first, second;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		map = new int[N+1][N+1];
		popul = new int[N+1];
		check = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			popul[i] = stoi(st.nextToken());
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = stoi(st.nextToken());
			for (int j = 0; j < n; j++) {
				int num = stoi(st.nextToken());
				map[num][i] = map[i][num] = 1;
			}
		}
		subset(0);
		if (min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	static void subset(int idx) {
		if (idx == N) {
			find();
			return;
		}
		check[idx] = true;
		subset(idx+1);
		
		check[idx] = false;
		subset(idx+1);
	}
	static void find() {
		first = new ArrayList<>();
		second = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if (check[i]) first.add(i+1);
			else second.add(i+1);
		}
		
		if (first.size() == N || second.size() == N) return;
		
		int a = bfs(first);
		int b = bfs(second);
		if (a > 0 && b > 0) {
			min = Math.min(min, Math.abs(a-b));
		}
	}
	static int bfs(List<Integer> comp) {
		int sum = 0, cnt = 1;
		visit = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(comp.get(0));
		sum += popul[comp.get(0)];
		visit[comp.get(0)] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if (map[cur][i] == 1 && !visit[i] && comp.contains(i)) {
					visit[i] = true;
					q.add(i);
					sum += popul[i];
					cnt++;
				}
			}
		}
		if (cnt == comp.size()) return sum;
		else return 0;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
