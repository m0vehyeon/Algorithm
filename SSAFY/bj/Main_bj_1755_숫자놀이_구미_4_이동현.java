package com.ssafy.bj;
import java.util.*;
import java.io.*;
public class Main_bj_1755_숫자놀이_구미_4_이동현 {
	static int M, N;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기 위한 BufferedReader
		StringTokenizer st = new StringTokenizer(br.readLine()); // N과 M을 끈어읽기 위한 StringTokenkizer
		StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder
		M = stoi(st.nextToken()); // N 입력
		N = stoi(st.nextToken()); // M 입력
		
		String[] eng = {"zero","one","two", "three","four","five","six","seven","eight","nine"}; // 영어와 숫자 매칭 배열
		String[][] arr = new String[N-M+1][2]; // 숫자와 바꾼 영어 같이 저장할 배열
		
		int j = 0; // arr 인덱스 증가용 변수
		for (int i = M; i<=N; i++) {
			StringBuilder tsb = new StringBuilder(); // 영어 앞자리와 뒷자리 합치기 위한 StringBuilder
			Integer ti = new Integer(i); // Integer 객체
			char[] tarr = ti.toString().toCharArray(); // Integer -> String -> char[]
			for (char c : tarr) { // tsb에 숫자 영어 매칭해서 추가
				tsb.append(eng[c - '0']).append(" ");
			}
			tsb.setLength(tsb.length()-1); // 마지막 띄어쓰기 제거
			arr[j][0] = tsb.toString(); // 숫자를 영어로 바꾼 것을 0번에 저장
			arr[j][1] = ti.toString(); // 원래 숫자를 1번에 저장
			j++;
		}
		Arrays.sort(arr, (o1,o2) -> o1[0].compareTo(o2[0])); // 영어로 정렬
		int cnt = 0; // 10줄씩 끈기 위한 변수
		for (String[] t : arr) {
			sb.append(t[1] + " "); // 1번 방에 있는 원래 숫자 StringBuilder에 추가
			cnt++; // cnt 증가
			if (cnt == 10) { // 10글자가 되면
				cnt = 0; // 초기화
				sb.setLength(sb.length()-1); // 마지막 띄어쓰기 제거
				sb.append("\n"); // 줄바꿈 추가
			}
		}
		System.out.println(sb); // 결과 출력
	}
	static int stoi(String s) {
		return Integer.parseInt(s); // String을 int 로 변환
	}
}
