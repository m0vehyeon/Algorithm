package com.ssafy.prog;

import java.util.*;
import java.io.*;

public class Solution_prog_위장_해쉬 {
	public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        for (String[] s : clothes) {
        	map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        }
        for (int a : map.values()) {
        	answer *= (a + 1);
        }
        return answer - 1;
    }
	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		int result = solution(clothes);
		System.out.println(result);
	}

}
