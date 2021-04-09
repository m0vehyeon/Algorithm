package com.ssafy.prog;

import java.util.*;
import java.io.*;

public class Solution_prog_기능개발_스택큐 {
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < progresses.length; i++) q.offer(progresses[i]);
        int start = 0;
        while(!q.isEmpty()) {
        	int cnt = 0;
        	for(int i = start; i < progresses.length; i++) {
        		progresses[i] += speeds[i];
        	}
        	for (int i = start; i < progresses.length; i++) {
        		if (progresses[i] >= 100) {
        			cnt++;
        			q.poll();
        		} else break;
        	}
        	if(cnt > 0) {
        		list.add(cnt);
        		start += cnt;
        	}
        	
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size();i++) answer[i] = list.get(i);
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	public static void main(String[] args) {
		solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
	}

}
