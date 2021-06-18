package me.donghyeon.baekjoon;

import java.util.*;
import java.io.*;

public class Main_bj_16561_3의배수_이동현 {
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N < 9) {
            System.out.println(0);
            return;
        } else {
            int sum = 1;
            int plus = 2;
            for (int i = 9; i < N; i+=3) {
                sum += plus++;
            }
            System.out.println(sum);
        }
    }
}
