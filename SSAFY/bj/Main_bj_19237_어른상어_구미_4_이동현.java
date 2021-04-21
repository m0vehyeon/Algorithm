package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_19237_어른상어_구미_4_이동현 {
	static class Shark {
		int num, x, y, dir;
		int[][] rankDir;
		public Shark(int num, int x, int y, int dir, int[][] rankDir) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.rankDir = rankDir;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Shark [num=").append(num).append(", x=").append(x).append(", y=").append(y).append(", dir=")
					.append(dir).append(", rankDir=").append(Arrays.toString(rankDir)).append("]");
			return builder.toString();
		}
	}

	static int N, M, k, cnt;
	static int[][] map;
	static int[][][] smell;
	static List<Shark> sharks;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };
	static int[][] sharkDir;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		k = stoi(st.nextToken());
		map = new int[N][N];
		smell = new int[N][N][2];
		sharks = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken());
				if (map[i][j] > 0) {
					sharks.add(new Shark(map[i][j], i, j, 0, new int[][] {}));
					smell[i][j][0] = map[i][j];
					smell[i][j][1] = k;
				}
			}
		}
		Collections.sort(sharks, (o1, o2) -> Integer.compare(o1.num, o2.num));
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			sharks.get(i).dir = stoi(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int[][] tmp = new int[5][4];

			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++)
					tmp[j][k] = stoi(st.nextToken());
			}
			sharks.get(i).rankDir = tmp;
		}
		boolean flag = true;
		while (cnt < 1000) {
			move();
			cnt++;
			if (sharks.size() ==1) {
				System.out.println(cnt);
				return;
			}
		}
		System.out.println(-1);
	}
	static void move() {
		ArrayList<Integer> delete = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		// 인접한 칸 중 우선순위가 빠른 아무 냄새가 없는칸 탐색
		// 그런 칸이 없으면 잣니의 냄새가 있는 칸의 방향으로 이동
		for (int i = 0; i < sharks.size(); i++) {
			boolean flag = false;
			Shark cur = sharks.get(i);
			for (int j = 0; j < 4; j++) {
				int td = cur.rankDir[cur.dir][j]; // 우선순위 선택
				int nx = cur.x + dx[td];
				int ny = cur.y + dy[td];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && smell[nx][ny][1] == 0) {
					q.offer(new int[] {i, nx, ny,td});
					flag = true;
					break;
				}
			}
			if (!flag) {
				for (int j = 0; j < 4; j++) {
					int td = cur.rankDir[cur.dir][j]; // 우선순위 선택
					int nx = cur.x + dx[td];
					int ny = cur.y + dy[td];
					if (0 <= nx && nx < N && 0 <= ny && ny < N && smell[nx][ny][0] == cur.num) {
						q.offer(new int[] {i, nx, ny, td});
						flag = true;
						break;
					}
				}
			}
		}
		minus();
		while(!q.isEmpty()) {
			int[] cur = q.poll();

			int i = cur[0]; int x = cur[1]; int y = cur[2]; int td = cur[3];
			if (smell[x][y][0] == 0 || smell[x][y][0] == sharks.get(i).num) {
				setShark(sharks.get(i), x, y, td);
			} else {
				if (smell[x][y][0] < sharks.get(i).num) {
					map[sharks.get(i).x][sharks.get(i).y] = 0;
					delete.add(sharks.get(i).num);
				}
			}
		}
		for (int d : delete) {
			for (int i = sharks.size() -1; i >= 0; i--) {
				if (sharks.get(i).num == d) {
					sharks.remove(i);
				}
			}
		}
	}
	static void minus() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (smell[i][j][1] > 0) {
					smell[i][j][1]--;
					if (smell[i][j][1] == 0) smell[i][j][0] = 0;
				}
			}
		}
	}
	static void setShark(Shark s, int nx, int ny, int dir) {
		map[s.x][s.y] = 0;
		map[nx][ny] = s.num;
		smell[nx][ny][0] = s.num;
		smell[nx][ny][1] = k;
		s.x = nx;
		s.y = ny;
		s.dir = dir;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
