package me.donghyeon.baekjoon;

import java.io.*;
import java.util.*;

public class Main_bj_17142_연구소_이동현 {
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] map;
    static int[] result;
    static boolean[][] visited;
    static List<int[]> viruses;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][N];
        result = new int[M];

        viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(st.nextToken());
                if (map[i][j] == 2) viruses.add(new int[]{i,j});
            }
        }
        combi(0,0);
        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
    static void spread(int[][] tmap) {
//        for(int a : result) System.out.println(Arrays.toString(viruses.get(a)));
//        for (int[] a : tmap) System.out.println(Arrays.toString(a));
//        System.out.println();
        int max = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int a : result) q.offer(new int[]{viruses.get(a)[0],viruses.get(a)[1],0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny] && tmap[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    tmap[nx][ny] = cur[2] + 1;
                    max = Integer.max(max, cur[2] + 1);
                    q.offer(new int[]{nx, ny, cur[2] + 1});
                }
                if(isAllVirus(tmap)) {
                    answer = Math.min(answer, max);
                    return;
                }
            }
        }

    }
    static void combi(int idx, int start) {
        if (idx == M) {
            int[][] tmap = new int[N][N];
            visited = new boolean[N][N];
            for (int n : result) {
                tmap[viruses.get(n)[0]][viruses.get(n)[1]] = 3;
                visited[viruses.get(n)[0]][viruses.get(n)[1]] = true;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tmap[i][j] = map[i][j];
                }
            }

            spread(tmap);
            return;
        }
        for (int i = start; i < viruses.size(); i++) {
            result[idx] = i;
            combi(idx + 1, i + 1);
        }
    }
    static boolean isAllVirus(int[][] tmap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tmap[i][j] == 0) return false;
            }
        }
        return true;
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
