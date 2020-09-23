package IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Samsung SW역량 테스트 IM대비 BOJ 2563 색종이
 * 
 * @author Park Sangwoo
 * @since 2020-09-24
 */
public class BOJ2563_색종이 {
	static int N;
	static int map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [101][101];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for (int j = r; j < r+10; j++) {
				for (int k = c; k < c+10; k++) {
					map[j][k] = 1; 
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}
//		for (int i = 1; i < 101; i++) {
//			for (int j = 1; j < 101; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(cnt);
	}

}
