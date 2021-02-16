package com.ssafy.jo;

import java.util.*;
import java.io.*;

public class Main_jo_1828_냉장고_구미_4_이동현 {
	static int[][] arr;
	static List<int[]> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N][2];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr[i] = new int[] {sc.nextInt(),sc.nextInt()};
		}
		Arrays.sort(arr, (o1,o2) -> {
			int diff = Integer.compare(o1[1], o2[1]);
			return diff!=0 ? diff : Integer.compare(o1[0], o2[0]);
		});
		
		list.add(arr[0]);
		for (int i = 1, size = arr.length; i < size; i++) {
			if (list.get(list.size() - 1)[1] < arr[i][0]) list.add(arr[i]);
		}
		System.out.println(list.size());
	}
}
