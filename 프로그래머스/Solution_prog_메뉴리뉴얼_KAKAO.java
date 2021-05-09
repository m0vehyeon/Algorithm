package com.ssafy.prog;

import java.util.*;
import java.io.*;

public class Solution_prog_메뉴리뉴얼_KAKAO {
	static Map<String, Integer> map;
	static List<String> removeList, list;
	static int[] count;
	public static String[] solution(String[] orders, int[] course) {
        String[] answer;
        map = new TreeMap<>();
        removeList = new ArrayList<>();
        list = new ArrayList<>();
        count = new int[11];
        for (int i = 0; i < orders.length; i++) {
        	char[] arr = orders[i].toCharArray();
        	Arrays.sort(arr);
        	String cur = String.valueOf(arr);
        	for (int j = 0; j < course.length; j++) {
        		combi(0,0,course[j],"",cur);
        	}
        }
        Set<String> set = map.keySet();
        for (String s : set) {
        	if (map.get(s) < 2) {
        		removeList.add(s);
        	} else list.add(s);
        }
        for (String s : removeList) map.remove(s);
        
        removeList.clear();
        int listSize = list.size();
        Collections.sort(list, (o1,o2) -> {
        	int diff = -Integer.compare(map.get(o1), map.get(o2));
        	return diff == 0 ? -Integer.compare(o1.length(), o2.length()) : diff;
        });
        
        for (int i = 0; i < listSize; i++) {
        	String cur = list.get(i);
        	int num = map.get(cur);
        	count[cur.length()] = Math.max(count[cur.length()], num);
        }
        for (int i = listSize - 1; i >= 0; i--) {
        	String cur = list.get(i);
        	int num = map.get(cur);
        	if (count[cur.length()] != num) list.remove(i);
        }
        Collections.sort(list);
        answer = list.toArray(new String[list.size()]);
        return answer;
    }
	static boolean contain(String small, String big) {
		char[] bigarr = big.toCharArray();
		for (int i = 0; i < small.length(); i++) {
			if (Arrays.binarySearch(bigarr, small.charAt(i)) < 0) {
				return false;
			}
		}
		return true;
	}
	static void combi(int idx, int start, int end, String result, String cur) {
		if (idx == end) {
			map.put(result, map.getOrDefault(result, 0) + 1);
			return;
		}
		for (int i = start; i < cur.length(); i++) {
			combi(idx + 1, i + 1, end, result + cur.charAt(i), cur);
		}
	}
	
	public static void main(String[] args) {
		String[] result = solution(new String[] {"ABCD", "ABCD", "ABCD"}, new int[] {2,3,4});
		//String[] result = solution(new String[] {"ABCD", "ABCD", "ABCD"}, new int[] {2,3,4});
		//String[] result = solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2,3,5});
		System.out.println(Arrays.toString(result));
	}

}
