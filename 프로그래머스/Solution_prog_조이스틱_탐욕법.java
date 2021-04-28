package com.ssafy.prog;
import java.util.*;
import java.io.*;
public class Solution_prog_조이스틱_탐욕법 {
	static char[] sname;
	static String result;
    static int answer, cur, minus, plus, mCnt, pCnt;
    public static int solution(String name) {
        sname = new char[name.length()];
        result = name;
        for (int i = 0; i < name.length(); i++) {
            sname[i] = 'A';
        }
        while(true) {
            change();
            if (String.valueOf(sname).equals(name)) break;
            minusMove();
            plusMove();
            if (pCnt > mCnt) {
            	cur = minus;
            	answer+=mCnt;
            } else if (pCnt < mCnt) {
            	cur = plus;
            	answer += pCnt;
            } else {
            	cur = plus;
            	answer += pCnt;
            }
            
            System.out.println(String.valueOf(sname));
        }
        return answer;
    }
    static void minusMove() {
    	minus = cur;
        for (int i = 1; i < sname.length; i++) {
            int idx = minus - i;
            if (idx < 0) idx = sname.length + idx;
            if (result.charAt(idx) != sname[idx]) {
                mCnt = i;
                minus = idx;
                return;
            }
        }
    }
    static void plusMove() {
    	plus = cur;
    	for (int i = 1; i < sname.length;i++) {
    		int idx = plus + i;
    		if (idx >= sname.length) break;
    		if (result.charAt(idx) != sname[idx]) {
    			pCnt = i;
    			plus = idx;
    			return;
    		}
    	}
    	pCnt = 21;
    	plus = 0;
    }
    static void change() {
        int sub = (int)(result.charAt(cur) - 'A');
        int n = sub > 13 ? 26 - sub : sub;
        sname[cur] = result.charAt(cur);
        
        answer+= n;
    }
	public static void main(String[] args) {
		//System.out.println(solution("BBBAAAB")); //#9
		//System.out.println(solution("ABABAAAAABA")); //#11
		System.out.println(solution("CANAAAAANAN")); //#48
		System.out.println(solution("ABAAAAABAB")); //#8
		System.out.println(solution("ABABAAAAAB")); //#8
		System.out.println(solution("BABAAAAB")); //#7
		System.out.println(solution("AAA"));// #0
		System.out.println(solution("ABAAAAAAABA")); //#6
		System.out.println(solution("AAB")); //#2
		System.out.println(solution("AABAAAAAAABBB")); //#11
		System.out.println(solution("ZZZ")); //#5
		System.out.println(solution("BBBBAAAAAB")); //#10
		System.out.println(solution("BBBBAAAABA"));//#12
	}

}
