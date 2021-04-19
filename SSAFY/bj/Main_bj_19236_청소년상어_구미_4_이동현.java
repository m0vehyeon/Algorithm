package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_19236_청소년상어_구미_4_이동현 {
	static class Shark {
		int x,y,dir,sum;

		public Shark(int x, int y, int dir, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.sum = sum;
		}
		
	}
	static class Fish{
		int num, x, y, dir;
		boolean life;
		public Fish(int num, int x, int y, int dir, boolean life) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.life = life;
		}
		
	}
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	static ArrayList<Fish> fishes;
	static int[] dx = {0,-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,0,-1,-1,-1,0,1,1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[4][4];
		fishes = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <4; j++) {
				int num = stoi(st.nextToken());
				int dir = stoi(st.nextToken());
				map[i][j] = num;
				fishes.add(new Fish(num,i,j,dir,true));
			}
		}
		fishes.add(new Fish(0,-1,-1,-1,false));
		Collections.sort(fishes, (o1,o2) -> Integer.compare(o1.num, o2.num));
		Fish next = fishes.get(map[0][0]);
		Shark shark = new Shark(0,0,next.dir,next.num);
		next.life = false;
		map[0][0] = -1;
		dfs(shark, map, fishes);
		System.out.println(max);
	}
	static void dfs(Shark shark, int[][] curMap, ArrayList<Fish> curFish) {
		max = Math.max(max, shark.sum);
		fishMove(curMap, curFish);

		for (int i = 1; i < 4; i++) {
			int nx = shark.x + dx[shark.dir] * i;
			int ny = shark.y + dy[shark.dir] * i;
			if (isSharkAvailable(nx,ny,curMap)) {
				int[][] tmap = init(curMap);
				ArrayList<Fish> tFish = init(curFish);
				
				tmap[shark.x][shark.y] = 0;
				Fish next = tFish.get(curMap[nx][ny]);
				Shark nShark = new Shark(next.x,next.y,next.dir,shark.sum + next.num);
				next.life = false;
				tmap[next.x][next.y] = -1;
				dfs(nShark, tmap, tFish);
			}
		}
	}
	static void fishMove(int[][] tmap, ArrayList<Fish> tFish) {
		for (int i = 1; i <= 16; i++) {
			if (tFish.get(i).life) {
				Fish cur = tFish.get(i);
				int cnt = 0;
				while(cnt < 8) {
					int nx = cur.x + dx[cur.dir];
					int ny = cur.y + dy[cur.dir];
					if (isAvailable(nx,ny,tmap)) {
						tmap[cur.x][cur.y] = 0;
						if (tmap[nx][ny] == 0) {
							cur.x = nx;
							cur.y = ny;
						} else {
							Fish tmp = tFish.get(tmap[nx][ny]);
							tmp.x = cur.x;
							tmp.y = cur.y;
							tmap[cur.x][cur.y] = tmp.num;
							
							cur.x = nx;
							cur.y = ny;
						}
						tmap[nx][ny] = cur.num;
						break;
					}
					cur.dir++;
					if (cur.dir == 9) cur.dir = 1;
					cnt++;
				}
			}
			
		}
	}
	static boolean isSharkAvailable(int x, int y, int[][] tmap) {
		if (0<= x && x < 4 && 0 <= y && y < 4 && tmap[x][y] > 0) return true;
		return false;
	}
	static int[][] init(int[][] curMap) {
		int[][] tmp = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <4; j++) {
				tmp[i][j] = curMap[i][j];
			}
		}
		return tmp;
	}
	static ArrayList<Fish> init(ArrayList<Fish> curFish) {
		ArrayList<Fish> tmp = new ArrayList<>();
		for (Fish t : curFish) tmp.add(new Fish(t.num,t.x,t.y,t.dir,t.life));
		return tmp;
	}
	static boolean isAvailable(int x, int y, int[][] tmap) {
		if (0<= x && x < 4 && 0<=y && y < 4 && tmap[x][y] >= 0) return true;
		return false;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
