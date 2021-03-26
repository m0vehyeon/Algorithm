package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d6_1263_사람네트워크2_구미_4_이동현_다익스트라 {
	static class Node implements Comparable<Node>{
		int idx;
		int weight;
		public Node(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight,o.weight);
		}
		
	}
	static int N;
	static int[][] dist;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d6_1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			dist = new int[N][N];
			int min = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int tnum = stoi(st.nextToken());
					if (i == j) {
						dist[i][j] = 0;
						continue;
					}
					dist[i][j] = tnum;
				}
			}
			
			for (int i = 0; i < N; i++) {
				min = Math.min(min, dijkstra(i));
			}
			System.out.println("#" + t + " " + min);
		}
	}
	static int dijkstra(int start) {
		int ret = 0;
		boolean[] visited = new boolean[N];
		int[] cost = new int[N];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,cost[start]));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if (visited[n.idx]) continue;
			
			visited[n.idx] = true;
			
			for (int i = 0; i < N; i++) {
				if (!visited[i] && dist[n.idx][i] != 0 && cost[i] > n.weight + dist[n.idx][i]) {
					cost[i] = n.weight + dist[n.idx][i];
					pq.offer(new Node(i,cost[i]));
				}
			}
		}
		for (int i = 0; i < N; i++) {
			ret += cost[i];
		}
		return ret;
	}
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
