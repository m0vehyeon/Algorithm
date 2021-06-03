package me.donghyeon.prog;

import java.util.*;
import java.io.*;

public class Solution_prog_프린터 {
    public static int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1,o2));
        Queue<int[]> q = new LinkedList<>();
        int i = 0;
        for (int n : priorities) {
            pq.offer(n);
            q.offer(new int[] {n,i++});
        }

        while(true) {
            int[] tmp = q.poll();
            if (tmp[0] == pq.peek()) {
                if (tmp[1] == location) break;
                pq.poll();
                answer++;
            } else {
                q.offer(tmp);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
