package me.donghyeon.baekjoon;

import java.util.*;
import java.io.*;

public class Main_bj_9081_단어맞추기_이동현 {
    static char[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());

        for (int i = 0; i < T; i++) {
            arr = br.readLine().toCharArray();
            nextWord();
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();

        }
    }

    static void nextWord() {
        int i = arr.length - 1;

        while (i > 0 && arr[i-1] >= arr[i]) {
            i--;
        }

        if (i == 0) return;

        int j = arr.length - 1;
        while (arr[i-1] >= arr[j]) {
            j--;
        }
        swap(arr, i-1, j);

        Arrays.sort(arr, i, arr.length);
    }


    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
