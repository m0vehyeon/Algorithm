package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class Solution_swea_5644_무선충전_구미_4_이동현 {
	static int T,M,A, Apower, Bpower, result, tsum;
	static int[][] map, move, AP;
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,-1,0,1,0};
	static int[] nums;
	static boolean[] check;
	static ArrayList<Integer> bc;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_swea_5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = stoi(st.nextToken()); A = stoi(st.nextToken());
			map = new int[11][11];
			move = new int[M+1][M+1];
			AP = new int[A+1][4];
			result = 0;
			move[0][0] = 0; move[0][1] = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				move[i][0] = stoi(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				move[i][1] = stoi(st.nextToken());
			}
			for (int i = 1; i <= A ;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					AP[i][j] = stoi(st.nextToken());
				}
			}
			find();
			
			System.out.println("#" + t + " "+result);
		}
	}
	static void find() {
		int Ax = 1, Ay = 1, Bx = 10, By = 10;

		for (int i = 0; i <= M; i++) {
			int Anx = Ax + dx[move[i][0]];
			int Any = Ay + dy[move[i][0]];
			int Bnx = Bx + dx[move[i][1]];
			int Bny = By + dy[move[i][1]];
			bc = new ArrayList<Integer>();
			for (int j = 1; j <= A; j++) {
				if (getDistance(Anx,Any,AP[j][0],AP[j][1]) <= AP[j][2]) bc.add(j);
				if (getDistance(Bnx,Bny,AP[j][0],AP[j][1]) <= AP[j][2]) bc.add(j);
			}
			tsum = 0;
			if (bc.size()>1) {
				nums = new int[2];
				check = new boolean[bc.size()];
				permu(0,Anx,Any,Bnx,Bny);
				result+= tsum;
			} else if (bc.size() == 1) {
				int a = 0, b = 0;
				if (getDistance(Anx,Any,AP[bc.get(0)][0],AP[bc.get(0)][1]) <= AP[bc.get(0)][2]) a= AP[bc.get(0)][3];
				if (getDistance(Bnx,Bny,AP[bc.get(0)][0],AP[bc.get(0)][1]) <= AP[bc.get(0)][2]) b = AP[bc.get(0)][3];
				if (a == b) result+= a;
				else result += a+b;
			}
			Ax = Anx; Ay = Any;
			Bx = Bnx; By = Bny;
		}
	}
	static void permu(int idx,int Anx , int Any, int Bnx, int Bny) {
		if (idx == 2) {
			int sum = 0;
			if (getDistance(Anx,Any,AP[nums[0]][0],AP[nums[0]][1]) <= AP[nums[0]][2]) sum += AP[nums[0]][3];
			if (getDistance(Bnx,Bny,AP[nums[1]][0],AP[nums[1]][1]) <= AP[nums[1]][2]) sum += AP[nums[1]][3];
			if (nums[0] == nums[1]) sum /= 2;
			tsum = Math.max(tsum, sum);
			return;
		}
		for (int i = 0; i < bc.size(); i++) {
			if(check[i]) continue;
			check[i] = true;
			nums[idx] = bc.get(i);
			permu(idx+1,Anx,Any,Bnx,Bny);
			check[i] = false;
		}
	}
	static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x2-x1) + Math.abs(y2-y1);
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
