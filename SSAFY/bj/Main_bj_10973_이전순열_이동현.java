package me.donghyeon.baekjoon;

import java.util.*;
import java.io.*;

public class Main_bj_10973_이전순열_이동현 {
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = stoi(st.nextToken());

        if(prevPermu()) {
            for(int a : arr) System.out.print(a + " ");
        } else {
            System.out.println(-1);
        }
    }
    static boolean prevPermu() {
        int i = arr.length - 1;
        while (i > 0 && arr[i] > arr[i-1]) {
            i--;
        }
        if (i == 0) return false;

        int j = arr.length - 1;
        while (arr[i-1] < arr[j]) {
            j--;
        }
        swap(arr, i - 1, j);
        j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
        return true;
    }
    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
