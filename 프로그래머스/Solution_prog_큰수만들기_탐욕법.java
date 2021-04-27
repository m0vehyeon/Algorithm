package com.ssafy.prog;

import java.util.*;
import java.io.*;

public class Solution_prog_큰수만들기_탐욕법 {
	public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < number.length(); i++) {
        	int num = (int)(number.charAt(i)-'0');
        	while(!dq.isEmpty() && dq.peekLast() < num && k > 0) {
        		dq.pollLast();
        		k--;
        	}
        	dq.offerLast(num);
        }
        while (k > 0) {
        	dq.pollLast();
        	k--;
        }
        while(!dq.isEmpty()) {
        	answer.append(dq.poll());
        }
        return answer.toString();
    }
	public static void main(String[] args) {
		System.out.println(solution("7",1));
		System.out.println(solution("1231234",3));
		System.out.println(solution("4177252841",4));
	}

}
