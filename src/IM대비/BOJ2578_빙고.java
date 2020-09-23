package IM대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Samsung SW역량 테스트 IM대비 BOJ 2578 빙고
 * 
 * @author Park Sangwoo
 * @since 2020-09-23
 */
public class BOJ2578_빙고 {
	static int [][] map;
	static int []check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int [5][5];	
		check = new int [25];
		
		for (int i = 0; i < 5; i++) {
			String input[] = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for (int i = 0, k =0; i < 5; i++) {
			String input[] = br.readLine().split(" ");
			for (int j = 0; j < 5; j++,k++) {
				check[k] = Integer.parseInt(input[j]);
			}
		}
		
		
	}
}
