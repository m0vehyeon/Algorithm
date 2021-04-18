package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_20056_마법사상어와파이어볼_구미_4_이동현 {
	static class Fireball{
		int x, y, m,s,d;
		public Fireball(int x, int y, int m, int s, int d) {
			super();
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}

	}
	
	static int N, M, K;
	static ArrayList<Fireball> list;
	static int[][] map, msum, ssum, dsum;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		
		map = new int[N][N];
		msum = new int[N][N];
		ssum = new int[N][N];
		dsum = new int[N][N];
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Fireball(stoi(st.nextToken())-1,stoi(st.nextToken())-1,stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken())));
			map[list.get(i).x][list.get(i).y] = 1;
			msum[list.get(i).x][list.get(i).y] = list.get(i).m;
			ssum[list.get(i).x][list.get(i).y] = list.get(i).s;
			dsum[list.get(i).x][list.get(i).y] = list.get(i).d;
		}
		int k = 0;
		while (k < K) {
			move();
			divide();
			k++;
		}
		int sum = 0;
		for (Fireball f : list) sum+=f.m;
		System.out.println(sum);
	}
	static void divide() {
		// map 배열을 돌면서 1 보다 큰 위치 좌표가 포함된 list를 삭제한다
		// 파이어볼 생성 규칙에 따라 파이어볼을 list 에 넣는다.
		// 질량이 0인 애들은 삭제한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] > 1) {
					remove(i, j);
					int m = msum[i][j] / 5;
					if (m == 0) continue;
					int s = ssum[i][j] / map[i][j];
					int d = dsum[i][j] == 1 || dsum[i][j] == 2 ? 0 : 1;
					for (int k = 0; k <4; k++) {
						list.add(new Fireball(i,j,m,s,d+k*2));
					}
				}
			}
		}
	}
	static void move() {
		map = new int[N][N];
		msum = new int[N][N];
		ssum = new int[N][N];
		dsum = new int[N][N];
		
		for (Fireball f : list) {
			f.x = (f.x + dx[f.d] * (f.s%N));
			f.y = (f.y + dy[f.d] * (f.s%N));
			f.x = check(f.x);
			f.y = check(f.y);
			map[f.x][f.y]++;
			msum[f.x][f.y]+=f.m;
			ssum[f.x][f.y]+=f.s;
			
			if (dsum[f.x][f.y] == 0) { 
				if(f.d % 2 == 0) dsum[f.x][f.y] = 2;
				else dsum[f.x][f.y] = 1;
 			} else if (dsum[f.x][f.y] == 1){
 				if (f.d % 2 == 0) dsum[f.x][f.y] = -1;
 			} else if (dsum[f.x][f.y] == 2) {
 				if (f.d % 2 == 1) dsum[f.x][f.y] = -1;
 			} else if (dsum[f.x][f.y] == -1) continue;
		}

	}
	static void remove(int x, int y) {
		for (int i = list.size() - 1; i > -1; i--) {
			if (list.get(i).x == x && list.get(i).y == y) list.remove(i);
		}
	}
	
	static int check(int a) {
		if (a < 0) {
			a += N;
		} else if(a >= N) {
			a -= N;
		}
		return a;
	}
	
	
	static int stoi(String s) {
		return Integer.parseInt(s);
	}

}
