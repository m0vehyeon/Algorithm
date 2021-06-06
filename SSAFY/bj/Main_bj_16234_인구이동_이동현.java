package me.donghyeon.baekjoon;

import java.util.*;
import java.io.*;


public class Main_bj_16234_인구이동_이동현 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        L = stoi(st.nextToken());
        R = stoi(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }
        int result = 0;
        while (true) {
            boolean flag = false;
            check = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!check[i][j] && checkPopulation(i, j)) flag = true;
                }
            }
            if (!flag) break;
            result++;
        }
        System.out.println(result);
    }
    static boolean checkPopulation(int x, int y) {
        boolean flag = false;
        Queue<int[]> q = new LinkedList<>();
        List<int[]> teams = new ArrayList<>();
        int sum = map[x][y];
        q.offer((new int[]{x,y}));
        check[x][y] = true;
        teams.add(new int[] {x,y});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (conditionCheck(cur[0], cur[1], nx, ny)) {
                    check[nx][ny] = true;
                    teams.add(new int[]{nx, ny});
                    q.offer(new int[]{nx, ny});
                    sum += map[nx][ny];
                }
            }
        }
        int divide = sum / teams.size();
        teams.forEach(team -> {
            map[team[0]][team[1]] = divide;
        });
        if (sum > map[x][y]) return true;
        return false;
    }
    static boolean conditionCheck(int x, int y, int nx, int ny) {
        if (0 <= nx && nx < N && 0 <= ny && ny < N && !check[nx][ny] && L <= Math.abs(map[nx][ny] - map[x][y]) && Math.abs(map[nx][ny] - map[x][y]) <= R)
            return true;
        return false;
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
