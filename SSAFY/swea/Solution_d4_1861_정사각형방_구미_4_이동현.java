package com.ssafy.swea;
import java.util.*;
import java.io.*;
public class Solution_d4_1861_정사각형방_구미_4_이동현 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] arr;
	static int[][] dist;
	static int N;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int t= 1; t<= T; t++) {
			N = Integer.parseInt(br.readLine());
			dist = new int[N][N];
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j< N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					dist[i][j] = bfs(i,j,N);
					if (dist[i][j] == 0) dfs(i,j);
				}
			}
			for (int[] a : dist) System.out.println(Arrays.toString(a));
			int max = 0;
			int idx = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (dist[i][j] > max) {
						max = dist[i][j];
						idx = arr[i][j];
					}
					else if(dist[i][j] == max) {
						max = dist[i][j];
						if (arr[i][j] < idx) {
							idx = arr[i][j];
						}
					}
				}
			}
			System.out.println("#" + t+ " "+ idx +" " + max);
		}
	}
	static int bfs(int i, int j, int N) {
		int x = 0, y = 0;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int cnt = 1;
		q.offerLast(new int[] {i,j});
		while (!q.isEmpty()) {
			int[] tmp = new int[2];
			tmp = q.pollFirst();
			x = tmp[0];
			y = tmp[1];
			for (int p = 0; p < 4; p++) {
				int nx = x + dx[p];
				int ny = y + dy[p];
				if (0<= nx && nx < N && 0 <= ny && ny < N && arr[nx][ny] == arr[x][y] + 1) {
					cnt++;
					q.offerLast(new int[] {nx,ny});
				}
			}
		}
		return cnt;
	}
	static void dfs(int i, int j)  {
		dist[i][j] = 1;
		for (int d= 0 ; d< 4; d++) {
			int ni = i + dx[d];
			int nj = j + dy[d];
			if (0 <= ni && ni < N && 0 <= nj && nj < N && (arr[i][j] + 1) == arr[ni][nj])
			{
				if (dist[ni][nj] == 0) dfs(ni,nj);
				dist[i][j] = Math.max(dist[i][j], dist[ni][nj] + 1);
			}
		}
	}
}
