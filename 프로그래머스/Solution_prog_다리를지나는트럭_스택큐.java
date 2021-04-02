package com.ssafy.prog;

import java.util.*;
import java.io.*;
public class Solution_prog_다리를지나는트럭_스택큐 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Deque<int[]> wait = new LinkedList<>();
        ArrayList<int[]> running = new ArrayList<>();
        Deque<int[]> finish = new LinkedList<>();
        	
        int bridgeWeight = 0;
        int truck = truck_weights.length;
        for (int i = 0; i < truck; i++) {
        	wait.offerLast(new int[] {truck_weights[i], 0});
        }
        
        while (finish.size() != truck) {
        	if(wait.size() > 0 && bridgeWeight + wait.peek()[0] <= weight) {
        		int[] t = wait.pollFirst();
        		bridgeWeight+=t[0];
        		running.add(t);
        	}
        	for (int i = running.size()-1; i > -1; i--) {
        		running.get(i)[1]++;
        		if (running.get(i)[1] == bridge_length) {
        			int[] ft = running.get(i);
        			bridgeWeight -= ft[0];
        			finish.offerLast(ft);
        			running.remove(i);
        		}
        	}
        	answer++;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(2,10,new int[] {7,4,5,6}));
	}

}
