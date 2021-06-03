package me.donghyeon.prog;

import java.util.*;
import java.io.*;

public class Solution_prog_카카오프렌즈컬러링북 {
    static int numberOfArea, maxSizeOfOneArea;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    bfs(i,j,picture,m,n);
                    numberOfArea++;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static void bfs(int i, int j, int[][] picture,int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;
        int cnt = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (0<=nx && nx < m && 0 <= ny && ny < n && picture[nx][ny] == picture[cur[0]][cur[1]] && !visited[nx][ny]) {
                    q.offer(new int[] {nx, ny});
                    cnt++;
                    visited[nx][ny] = true;
                }
            }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
    }

    public static void main(String[] args) {
        int[][] pic = new int[][] {{1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3}};
        int[][] pic2 = new int[][] {{0,1,0},{1,1,0},{0,0,0}};
        System.out.println(Arrays.toString(solution(3,3,pic2)));
    }
}
