package com.ssafy.swea;

import java.util.*;
import java.io.*;
public class Solution_d4_1251_하나로_구미_4_이동현_Kruskal {
	static class Edge implements Comparable<Edge>{
		int from, to;
		long weight;

		public Edge(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Edge [from=").append(from).append(", to=").append(to).append(", weight=").append(weight)
					.append("]");
			return builder.toString();
		}
		
	}
	
	static void make() { // 크기가 1인 단위집합을 만든다.
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if (parents[a] == a) return a;
		//return findSet(parents[a]); // path compression 전
		return parents[a] = findSet(parents[a]); // path compression 후
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	static int N;
	static int parents[];
	static List<Edge> edgeList;
	static long[][] location;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1251.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int t = 1; t<=T; t++) {
			N = stoi(br.readLine());
			double E = 0;
			parents = new int[N];
			edgeList = new ArrayList<>();
			location = new long[N][2];
			StringTokenizer st = null;
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
						edgeList.add(new Edge(i,j,dist));
					}
				}
			}
			Collections.sort(edgeList);
			//for (Edge e : edgeList) System.out.println(e);
			make();
			long result = 0;
			int count = 0; // 선택한 간선수
			//System.out.println(Arrays.toString(parents));
			for (Edge edge : edgeList) {
				if (union(edge.from, edge.to)) { // 싸이클이 발생하지 않았다면
					result += edge.weight;
					if (++count == N-1) break;
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
