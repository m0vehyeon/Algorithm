package com.ssafy.prog;

import java.util.PriorityQueue;

public class Solution_prog_더맵게_힙 {
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        long s = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) pq.add(scoville[i]);
        
        while (!pq.isEmpty()) {
        	if (pq.peek() >= K) return answer;
        	if (pq.size() < 2) return -1;
        	int a = pq.poll();
        	int b = pq.poll();
        	pq.offer(a + 2 * b);
        	answer++;
        }
        return answer;
    }

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,3,9,10,12},7));
	}

}
