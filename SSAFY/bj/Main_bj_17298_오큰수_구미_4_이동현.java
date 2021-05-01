package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_17298_오큰수_구미_4_이동현 {
	static int N;
	static Stack<Integer> first, second;
	static ArrayList<Integer> result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = stoi(br.readLine());
		
		first = new Stack<>();
		second = new Stack<>();
		result = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			first.push(stoi(st.nextToken()));
		}
		
		second.push(first.pop());
		result.add(-1);
		
		while(!first.isEmpty()) {
			int cur= first.pop();
			while(!second.isEmpty()) {
				if (second.peek() > cur) {
					result.add(second.peek());
					break;
				}
				second.pop();
			}
			if(second.isEmpty()) result.add(-1);
			second.push(cur);
		}
		
		for (int i = result.size()-1; i >= 0; i--) {
			sb.append(result.get(i)).append(" ");
		}
		
		System.out.println(sb);
		
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
