package com.ssafy.prog;

import java.util.*;
import java.io.*;

public class Solution_prog_구명보트_탐욕법 {
	public int solution(int[] people, int limit) {
        int answer = 0;
        Integer[] p = new Integer[people.length];
        for (int i = 0; i < people.length; i++) p[i] = people[i];
        Arrays.sort(p,Collections.reverseOrder());
        int left = 0;
        int right = people.length - 1;
        
        while (left < right) {
            if (p[left] + p[right] <= limit) {
                answer++;
                left++; right--;
            } else {
                answer++;
                left++;
            }
            if(left == right) {
                answer++;
                break;
            }
            
        }

        return answer;
    }

}
