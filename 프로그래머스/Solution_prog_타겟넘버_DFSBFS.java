package com.ssafy.prog;

import java.util.*;
import java.io.*;

public class Solution_prog_타겟넘버_DFSBFS {
	static int len, tar,answer;
    static int[] nums;
    public int solution(int[] numbers, int target) {
        nums = numbers;
        len = numbers.length;
        tar = target;
        dfs(0,0);
        return answer;
    }
    static void dfs(int sum, int cnt) {
        if (cnt == len) {
            if (sum == tar) answer++;
            return;
        }
        dfs(sum + nums[cnt], cnt+1);
        dfs(sum - nums[cnt], cnt+1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
