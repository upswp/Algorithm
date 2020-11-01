package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1249_보급로 {

	static int T, N, map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j)-'0';
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[0][0] = -1;			//S 출발지점
					map[N-1][N-1] = -2;		//G 도착지점
				}
			}
		}
	}
}
