package com.ssafy.prog;
import java.util.*;
import java.io.*;
public class Solution_prog_단체사진찍기 {
	static char[] arr = {'A','C','F','J','M','N','R','T'};
    static boolean[] check;
    static char[] res;
    static int ans,t;
    public static int solution(int n, String[] data) {
        int answer = 0;
        res = new char[8];
        check = new boolean[8];
        
        dfs(0,data);
        answer = ans;
        return answer;
    }
    static void dfs(int cnt, String[] data) {
        if (cnt == 8) {
            if (checkCondition(data)) {
                ans++; 
            }
        }
        for (int i = 0 ; i < 8; i++) {
            if (check[i]) continue;
            res[cnt] = arr[i];
            check[i] = true;
            dfs(cnt+1,data);
            check[i] = false;
        }
    }
    static boolean checkCondition(String[] data) {
        for (int i = 0; i < data.length; i++) {
            int f = findIndex(res,data[i].charAt(0));
            int s = findIndex(res,data[i].charAt(2));
            char op = data[i].charAt(3);
            int num = data[i].charAt(4)-'0';
            
            int dist = Math.abs(f - s);
            if (op == '>') {
                if (dist - 1 <= num) {
                	return false;
                } 
            } else if (op == '<') {
                if (dist - 1 >= num) {
                	return false;
                }
            } else if (op == '=') {
                if (dist - 1 != num) {
                	return false;
                }
            }
        }
        return true;
    }
    static int findIndex(char[] arr, char c) {
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] == c) return i;
    	}
    	return 0;
    }
	public static void main(String[] args) {
		System.out.println(solution(2,	new String[]{"N~F=0", "R~T>2"}));
	}

}
