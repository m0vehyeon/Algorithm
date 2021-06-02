package com.ssafy.prog;

public class Solution_prog_멀쩡한사각형 {
	public long solution(int w,int h) {
        long answer = 0;
        for(int i=0;i<w;i++){
            answer+=(long)h*i/w;
        }
        return answer*2;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
