package com.ssafy.bj;

import java.util.*;
import java.io.*;

public class Main_bj_20061_모노미노도미노2_구미_4_이동현 {
	static int N, score, count;
	
	static int[][] blue;
	static int[][] green;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		blue = new int[4][6];
		green = new int[6][4];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t, x, y;
			t = stoi(st.nextToken());
			x = stoi(st.nextToken()); y = stoi(st.nextToken());

			downBlue(t, x, y);
			downGreen(t,x,y);
			checkBlue();
			checkGreen();
			
		}
		System.out.println(score);
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c <6; c++) {
				if (green[c][r] > 0) count++;
				if (blue[r][c] > 0) count++;
			}
		}
		System.out.println(count);
	}
	
	private static void checkGreen() {
		// 꽉찬 곳 0으로 만들고 해당 줄 번호 list 에 추가
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 5; i >= 2; i--) {
			boolean flag = true;
			for (int j = 0; j < 4; j++) {
				if (green[i][j] == 0) flag = false;
			}
			if (flag) {
				score++;
				list.add(i);
				for (int j = 0; j < 4; j++) green[i][j] = 0;
			}
		}
		// 없어진 곳 한칸씩 당기기
		for (int l = list.size() -1; l >= 0; l--) {
			for (int j = 0; j < 4; j++) {
				for (int i = list.get(l); i > 0; i--) {
					green[i][j] = green[i-1][j];
				}
			}
		}
		// 연화된 부분 갯수 새기
		int cnt = 0;
		for (int i = 1; i >= 0; i--) {
			boolean flag = true;
			for (int j = 0; j < 4; j++) {
				if (green[i][j] > 0) flag = false;
			}
			if (!flag) {
				cnt++;
			}
		}
		// 연화된 줄 갯수만큼 없애기
		while (cnt != 0) {
			for (int j = 0; j < 4; j++) {
				for (int i = 5; i > 0; i--) {
					green[i][j] = green[i-1][j];
				}
				green[0][j] = 0;
			}
			cnt--;
		}
	}

	private static void checkBlue() {
		// 꽉찬 곳 0으로 만들고 해당 줄 번호 list 에 추가
		ArrayList<Integer> list = new ArrayList<>();
		for (int j = 5; j >= 2; j--) {
			boolean flag = true;
			for (int i = 0; i < 4; i++) {
				if (blue[i][j] == 0) flag = false;
			}
			if (flag) {
				score++;
				list.add(j);
				for (int i = 0; i < 4; i++) blue[i][j] = 0;
			}
		}
		// 없어진 곳 한칸씩 당기기
		for (int l = list.size() -1; l >= 0; l--) {
			for (int i = 0; i < 4; i++) {
				for (int j = list.get(l); j > 0; j--) {
					blue[i][j] = blue[i][j-1];
				}
			}
		}
		// 연화된 부분 갯수 새기
		int cnt = 0;
		for (int j = 1; j >= 0; j--) {
			boolean flag = true;
			for (int i = 0; i < 4; i++) {
				if (blue[i][j] > 0) flag = false;
			}
			if (!flag) {
				cnt++;
			}
		}
		// 연화된 줄 갯수만큼 없애기
		while (cnt != 0) {
			for (int i = 0; i < 4; i++) {
				for (int j = 5; j > 0; j--) {
					blue[i][j] = blue[i][j-1];
				}
				blue[i][0] = 0;
			}
			cnt--;
		}
	}

	private static void downGreen(int t, int x, int y) {
		if (t == 1) {
			for (int i = 5; i >= 0; i-- ) {
				if (green[i][y] == 0) {
					boolean flag = true;
					for (int j = i-1; j >= 0; j--) {
						if (green[j][y] != 0) flag = false;
					}
					if (flag) {
						green[i][y] = 1;
						break;
					}
				}
			}
		} else if(t == 2){
			for (int i = 5; i>= 0; i--) {
				if (green[i][y] == 0 && green[i][y + 1] == 0) {
					boolean flag = true;
					for (int j = i-1; j >= 0; j--) {
						if (green[j][y] != 0 || green[j][y+1] != 0) flag = false;
					}
					if (flag) {
						green[i][y] = 1;
						green[i][y + 1] = 1;
						break;
					}
				}
			}
		}
		else if (t == 3) {
			for (int i = 4; i >= 0; i--) {
				if (green[i][y] == 0 && green[i + 1][y] == 0) {
					boolean flag = true;
					for (int j = i-1; j >= 0; j--) {
						if (green[j][y] != 0 || green[j+1][y] != 0) flag = false;
					}
					if (flag) {
						green[i][y] = 1;
						green[i+1][y] = 1;
						break;
					}
				}
			}
		}
	}

	private static void downBlue(int t, int x, int y) {
		if (t == 1) {
			for (int i = 5; i >= 0; i-- ) {
				if (blue[x][i] == 0) {
					boolean flag = true;
					for (int j = i-1; j >= 0; j--) {
						if (blue[x][j] != 0) flag = false;
					}
					if (flag) {
						blue[x][i] = 1;
						break;
					}
				}
			}
		} else if(t == 2){
			for (int i = 4; i>= 0; i--) {
				if (blue[x][i] == 0 && blue[x][i+1] == 0) {
					boolean flag = true;
					for (int j = i-1; j >= 0; j--) {
						if (blue[x][j] != 0 || blue[x][j+1] != 0) flag = false;
					}
					if (flag) {
						blue[x][i] = 1;
						blue[x][i+1] = 1;
						break;
					}
				}
			}
		}
		else if (t == 3) {
			for (int i = 5; i >= 0; i-- ) {
				if (blue[x][i] == 0 && blue[x+1][i] == 0) {
					boolean flag = true;
					for (int j = i-1; j >= 0; j--) {
						if (blue[x][j] != 0 || blue[x+1][j] != 0) flag = false;
					}
					if (flag) {
						blue[x][i] = 1;
						blue[x+1][i] = 1;
						break;
					}
				}
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
