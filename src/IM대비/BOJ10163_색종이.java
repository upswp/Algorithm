package IM대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10163_색종이 {
	static int N, X, Y, weight, height, tmp;
	static int map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		tmp = 0;
		for (int i = 0; i < N; i++) {
			++tmp;
			StringTokenizer st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			for (int j = X; j < X+weight; j++) {
				for (int k = Y; k < Y+height; k++) {
					map[j][k] = tmp;
				}
			}
		}
		
//		for (int i = 0; i < 101; i++) {
//			for (int j = 0; j < 101; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		tmp = 0;
		int cnt =0;
		while (N > tmp) {
			++tmp;
			for (int j = 0; j < 101; j++) {
				for (int k = 0; k < 101; k++) {
					if (map[j][k] == tmp) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
			cnt=0;
		}
	}

}
