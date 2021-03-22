package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_1753_최단경로_구미_4_이동현 {
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight,o.weight);
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [vertex=").append(vertex).append(", weight=").append(weight).append("]");
			return builder.toString();
		}
		
		
	}
	static int V,E,K;
	static int[] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = stoi(st.nextToken());
		E = stoi(st.nextToken());
		K = stoi(br.readLine());
		dist = new int[V + 1];
		List<Node>[] nodes = new ArrayList[V+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for (int i = 0; i < V+1; i++) nodes[i] = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = stoi(st.nextToken());
			int to = stoi(st.nextToken());
			int weight = stoi(st.nextToken());
			nodes[from].add(new Node(to,weight));
		}

		boolean[] visited = new boolean[V+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		
		pq.offer(new Node(K,dist[K]));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.vertex]) continue;
			
			visited[cur.vertex] = true;
			
			for (Node next : nodes[cur.vertex]) {
				if (dist[next.vertex] > dist[cur.vertex] + next.weight) {
					dist[next.vertex] = dist[cur.vertex] + next.weight;
					pq.offer(new Node(next.vertex,dist[next.vertex]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dist[i] + "\n");
		}
		System.out.println(sb);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
