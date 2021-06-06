package me.donghyeon.baekjoon;

import java.util.*;
import java.io.*;

public class Main_bj_16235_나무재테크_이동현 {
    static int N, M, K;
    static int[][] grow, map;
    static List<Integer>[][] trees;
    static List<int[]> death;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());
        grow = new int[N][N];
        map = new int[N][N];

        trees = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grow[i][j] = stoi(st.nextToken());
                trees[i][j] = new ArrayList<>();
                map[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            trees[stoi(st.nextToken()) - 1][stoi(st.nextToken()) - 1].add(stoi(st.nextToken()));
        }

        while (K > 0) {
            death = new ArrayList<>();
            spring();
            summer();
            fall();
            winter();
            K--;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += trees[i][j].size();
            }
        }
        System.out.println(answer);
    }

    private static void spring() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Collections.sort(trees[i][j]);
                int start = -1;
                for (int k = 0; k < trees[i][j].size(); k++) {
                    if (map[i][j] >= trees[i][j].get(k)) {
                        map[i][j] -= trees[i][j].get(k);
                        trees[i][j].set(k, trees[i][j].get(k) + 1);
                    } else {
                        start = k;
                        break;
                    }

                }
                if (start >= 0) {
                    for (int k = trees[i][j].size()-1; k >= start; k--) {
                        death.add(new int[]{i,j,trees[i][j].get(k)});
                        trees[i][j].remove(k);
                    }
                }
            }
        }
    }

    private static void summer() {
        death.forEach(ia -> {
            map[ia[0]][ia[1]] += ia[2]/2;
        });
    }

    private static void fall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < trees[i][j].size(); k++) {
                    if (trees[i][j].get(k) % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                                trees[nx][ny].add(1);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += grow[i][j];
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
