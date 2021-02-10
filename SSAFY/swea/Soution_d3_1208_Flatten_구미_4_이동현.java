package com.ssafy.swea;

import java.util.*;
import java.io.*;
public class Soution_d3_1208_Flatten_구미_4_이동현 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		for(int i = 0; i < T; i++) {
			int dump = Integer.parseInt(br.readLine());
			
			int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			while (dump > 0) {
				Arrays.sort(nums);
				if (nums[nums.length - 1] == nums[0]) break;
				nums[nums.length - 1] -= 1;
				nums[0] += 1;
				dump--;
			}
			Arrays.sort(nums);
			System.out.println("#"+ (i+1) + " " +(nums[nums.length-1] - nums[0]));
		}
	}
}
