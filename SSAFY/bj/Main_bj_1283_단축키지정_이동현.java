package me.donghyeon.baekjoon;

import java.util.*;
import java.io.*;

public class Main_bj_1283_단축키지정_이동현 {
    static int N;
    static boolean[] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        check = new boolean[30];
        for (int n = 0; n < N; n++) {
            boolean flag = false;
            String[] sarr = br.readLine().split(" ");
            for (int i = 0; i < sarr.length;i++) {
                if (!check[(int)(sarr[i].toLowerCase().charAt(0) - 'a')]) {
                    check[(int)(sarr[i].toLowerCase().charAt(0) - 'a')] = true;
                    sarr[i] = "[" + sarr[i].substring(0,1) + "]" + sarr[i].substring(1,sarr[i].length());
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                loop:for (int i = 0; i < sarr.length;i++) {
                    for (int j = 0; j < sarr[i].length(); j++) {
                        if (!check[(int)(sarr[i].toLowerCase().charAt(j) - 'a')]) {
                            check[(int)(sarr[i].toLowerCase().charAt(j) - 'a')] = true;
                            sarr[i] = sarr[i].substring(0,j) + "[" + sarr[i].substring(j,j+1) + "]" + sarr[i].substring(j+1,sarr[i].length());
                            flag = true;
                            break loop;
                        }

                    }
                }
            }
            for (String s : sarr) System.out.print(s + " ");
            System.out.println();
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
