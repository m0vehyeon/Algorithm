package com.ssafy.swea;

import java.util.*;


import java.io.*;
public class Solution_d4_1251_하나로_구미_4_이동현_PrimPQ {
	static class Node implements Comparable<Node>{
		int vertex;
		long weight;
		public Node(int vertex, long weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.weight,o.weight);
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [vertex=").append(vertex).append(", weight=").append(weight).append("]");
			return builder.toString();
		}
	}
	static int N;
	static long[][] location;
	static long[][] weight;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1251.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 1; t<=T; t++) {
			N = stoi(br.readLine());
			double E = 0;
			
			List<Node>[] nodes = new ArrayList[N];
			PriorityQueue<Node> pq = new PriorityQueue<>();
			long[] minEdge = new long[N];
			boolean[] visited = new boolean[N];
			long[][] distance = new long[N][N];
			location = new long[N][2];
			weight = new long[N][N];
			StringTokenizer st = null;
			for (int i = 0; i < N; i++) nodes[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				location[i][0] = stoi(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				location[i][1] = stoi(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if (i != j) {
						long dist = ((location[i][0] - location[j][0])*(location[i][0] - location[j][0]))
								+ ((location[i][1] - location[j][1])*(location[i][1] - location[j][1]));
						nodes[i].add(new Node(j,dist));
						distance[i][j] = dist;
						distance[j][i] = dist;
					}
				}
				minEdge[i] = Long.MAX_VALUE;
				visited[i] = false;
			}
			minEdge[0] = 0;
			long result = 0;
			
			pq.offer(new Node(0,minEdge[0]));
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				if(visited[cur.vertex]) continue;
				
				visited[cur.vertex] = true;
				result += cur.weight;
				
				for (int i = 0; i < N; i++) {
					if (!visited[i] && distance[cur.vertex][i] < minEdge[i]) {
						minEdge[i] = distance[cur.vertex][i];
						pq.offer(new Node(i,minEdge[i]));
					}
				}
			}
			
			sb.append("#" + t + " " + Math.round(E * result)+ "\n");
		}
		System.out.println(sb);
	}
	static Long stol(String s ) {
		return Long.parseLong(s);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
