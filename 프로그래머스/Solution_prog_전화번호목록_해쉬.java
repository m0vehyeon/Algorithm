package com.ssafy.prog;

import java.util.*;
import java.io.*;

class Solution_prog_전화번호목록_해쉬 {
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
    public static boolean solution(String[] phone_book) {
    	int min = Integer.MAX_VALUE;
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(phone_book, (o1,o2) -> Integer.compare(o1.length(), o2.length()));
        for (String s : phone_book) {
        	min = Math.min(min, s.length());
        	map.put(s, map.getOrDefault(s, 0) + 1);
        	for (int i = min; i < s.length(); i++) {
        		if (map.getOrDefault(s.substring(0, i),0)>0) return false;
        	}
        }

        return answer;
    }
}