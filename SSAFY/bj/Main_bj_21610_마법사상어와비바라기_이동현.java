package me.donghyeon.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_bj_21610_마법사상어와비바라기_이동현 {
    static int N, M;
    static int[][] map;
    static List<int[]> clouds;
    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken()); M = stoi(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }
        init();
        for (int i = 0; i < M; i++) {
            int s,d;
            st = new StringTokenizer(br.readLine());
            d = stoi(st.nextToken()); s = stoi(st.nextToken());
            moveAndFill(d-1,s);
            magic();
            makeCloud();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += map[i][j];
            }
        }
        System.out.println(answer);

    }
    static void makeCloud() {
        boolean[][] checkCloud = new boolean[N][N];
        clouds.forEach(ia -> checkCloud[ia[0]][ia[1]] = true);
        clouds = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] >= 2 && !checkCloud[i][j]) {
                    clouds.add(new int[] {i,j});
                    map[i][j] -= 2;
                }
            }
        }
    }

    static void magic() {
        clouds.forEach(cloud -> {
           int cnt = 0;
           for (int d = 1; d < 8; d+=2) {
               int nx = cloud[0] + dx[d];
               int ny = cloud[1] + dy[d];
               if (0<=nx && nx < N && 0 <= ny && ny < N && map[nx][ny] > 0) cnt++;
           }
           map[cloud[0]][cloud[1]] += cnt;
        });
    }
    static void moveAndFill(int d, int s) {
        for (int i = 0; i < clouds.size(); i++) {
            int nx = check(clouds.get(i)[0] + s * dx[d]);
            int ny = check(clouds.get(i)[1] + s * dy[d]);
            clouds.set(i,new int[]{nx,ny});
            map[nx][ny] += 1;
        }
    }
    static int check(int n) {
        while (n < 0) {
            n += N;
        }
        return n % N;
    }
    static void init() {
        clouds = new ArrayList<>();
        clouds.add(new int[] {N-1,0});
        clouds.add(new int[] {N-1,1});
        clouds.add(new int[] {N-2,0});
        clouds.add(new int[] {N-2,1});
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
