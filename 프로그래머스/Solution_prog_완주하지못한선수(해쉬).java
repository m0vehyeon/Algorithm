package com.ssafy.prog;

import java.util.*;
import java.io.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hs = new HashMap<>();
        for (String s : participant) hs.put(s, hs.getOrDefault(s, 0) + 1);
        for (String s : completion) hs.put(s, hs.get(s) - 1);

        Set<Map.Entry<String,Integer>> entries = hs.entrySet();
        /*for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() != 0) answer = entry.getKey();
        }*/
        for (String s : hs.keySet()) {
            if (hs.get(s) != 0) {
                answer = s;
                break;
            }
        }
        return answer;
    }
    static void syso(String s) {
        System.out.println(s);
    }
}