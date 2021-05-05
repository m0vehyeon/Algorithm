package com.ssafy.prog;

import java.util.*;
import java.io.*;

public class Solution_prog_문자열압축_KAKAO {
	
	public static int solution(String s) {
		int len = s.length();
        int answer = len;
        for (int slice = 1; slice <= len/2; slice++) {
        	StringBuilder sb = new StringBuilder();
        	int i = 0;
        	while(true) {
        		int cnt = 1;
        		int j = i + slice;
        		String cur = s.substring(i,j);
        		while (j + slice <= len) {
        			if (cur.equals(s.substring(j,j+slice))) cnt++;
        			else {
        				break;
        			}
        			j+=slice;
        		}
        		if (cnt > 1) {
        			sb.append(Integer.valueOf(cnt).toString());
        		}
        		sb.append(cur);
        		i = j;
        		if (i + slice > len) {
        			sb.append(s.substring(i,len));
        			break;
        		}
        	}
        	answer = Math.min(answer, sb.length());
        }
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
	}

}
