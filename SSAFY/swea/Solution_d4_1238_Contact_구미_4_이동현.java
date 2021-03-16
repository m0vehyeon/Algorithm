package com.ssafy.swea;

import java.util.*;
import java.io.*;
class Node {
	int num;
	Node next;
	public Node(int num, Node next) {
		super();
		this.num = num;
		this.next = next;
	}
}
public class Solution_d4_1238_Contact_구미_4_이동현 {
	static int N, V;
	static Node[] n;
	static int[] check;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t<=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			V = stoi(st.nextToken());
			n = new Node[101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int from = stoi(st.nextToken());
				int to = stoi(st.nextToken());
				n[from] = new Node(to,n[from]);
			}
			bfs(V);
			int max_depth = 0;
			for(int i = 1; i <=100; i++) {
				max_depth = Math.max(max_depth, check[i]);
			}
			int max = 0;
			for(int i = 1; i <=100; i++) {
				if (max_depth == check[i]) max = Math.max(max, i);
			}
			System.out.println("#" + t + " " + max);
		}
	}
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		check = new int[101];
		q.offer(start);
		check[start] = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (Node t = n[cur]; t != null; t = t.next) {
				if (check[t.num] == 0 && t.num != start) {
					q.offer(t.num);
					check[t.num] = check[cur] + 1;
				}
			}
		}
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
