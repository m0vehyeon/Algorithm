package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_d4_3124_최소스패닝트리_구미_4_이동현 {
	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Edge [from=").append(from).append(", to=").append(to).append(", weight=").append(weight)
					.append("]");
			return builder.toString();
		}
	}
	
	static int V, E;
	static int[] parents;
	static Edge[] edges;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_3124.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 1; t <=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = stoi(st.nextToken());
			E = stoi(st.nextToken());
			parents = new int[V+1];
			edges = new Edge[E];
			make();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = stoi(st.nextToken());
				int to = stoi(st.nextToken());
				int weight = stoi(st.nextToken());
				edges[i] = new Edge(from,to,weight);
			}
			Arrays.sort(edges, (o1,o2) -> Integer.compare(o1.weight,o2.weight));
			int count = 0;
			long sum = 0;
			for(Edge e : edges) {
				if (union(e.from, e.to)) {
					sum += e.weight;
					count++;
				}
				if (count == V-1) break;
			}
			System.out.println("#" + t + " " + sum);
		}
	}
	static void make() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	static int find(int n) {
		if (parents[n] == n) return n;
		return parents[n] = find(parents[n]);
	}
	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA==rootB) return false;
		parents[rootB] = rootA;
		return true;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
