package com.ssafy.prog;

import java.util.*;
import java.io.*;

public class Solution_prog_짝지어제거하기 {
	public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (!stack.empty()) return 0;
        return 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
