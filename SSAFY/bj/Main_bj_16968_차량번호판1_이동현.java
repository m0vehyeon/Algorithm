package me.donghyeon.baekjoon;

import java.io.*;
import java.util.*;

public class Main_bj_16968_차량번호판1_이동현 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] rules = br.readLine().toCharArray();
        int mul = 0;
        if (rules[0] == 'c') mul = 26;
        else if (rules[0] == 'd') mul = 10;
        for (int i = 1; i < rules.length; i++) {
            if (rules[i] == 'c') {
                if (rules[i-1] == 'c') {
                    mul *= 25;
                } else mul *= 26;
            } else {
                if (rules[i-1] == 'd') mul *= 9;
                else mul *= 10;
            }
        }
        System.out.println(mul);
    }
}
