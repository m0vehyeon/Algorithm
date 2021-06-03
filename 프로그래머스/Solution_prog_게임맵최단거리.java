package me.donghyeon.prog;

import java.util.*;
import java.io.*;

public class Solution_prog_게임맵최단거리 {
    static int N, M, answer = -1;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        bfs(maps);
        return answer;
    }
    static void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && maps[nx][ny] == 1) {
                    if (nx == N-1 && ny == M-1) {
                        answer = cur[2] + 1;
                        return;
                    }
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny,cur[2] + 1});
                }
            }
        }

    }
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }
}
