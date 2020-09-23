package 미완성;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SSAFY SWEA 스도쿠검증
 * 
 * @author Park Sangwoo
 * @since 2020-09-07
 */
public class Solution1974_스도쿠검증 {
	static int T, map[][];
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		map = new int [9][9];
		
		for (int t = 1; t <= T; t++) {
			answer = 1;
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			a:for (int i = 0; i < 9; i++) {
				int sum =0;
				for (int j = 0; j < 9; j++) {
					sum += map[i][j];
					if (sum != 45) {
						answer = 0;
						break a;
					}
				}
			}
			a:for (int i = 0; i < 9; i++) {
				int sum =0;
				for (int j = 0; j < 9; j++) {
					sum += map[j][i];
					if (sum != 45) {
						answer = 0;
						break a;
					}
				}
			}
			
//			a:for (int i = 0; i < 9; i+=3) {
//				for (int j = 0; j < 9; j+=3) {
//					int sum =0;
//					sum += map[i][j];
//					if (sum != 45) {
//						answer = 1;
//						break a;
//					}
//				}
//			}
			
			System.out.println("#"+t+" "+answer);
			
		}
	}

}
