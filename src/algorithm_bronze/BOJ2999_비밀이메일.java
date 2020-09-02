package algorithm_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * BOJ 2999 비밀 이메일
 * @author Park Sangwoo
 * @since 2020-09-02
 */
public class BOJ2999_비밀이메일 {
	static char[] input;
	static int R, C;
	static char [][] metrix;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		int N = input.length;

		for (int i = 1; i < N; i++) {
			if (N % i == 0 && i <= N / i) {
				R = i;
				C = N/i;
			}
		}
		if(R == 0 && C == 0) {
			R = 1;
			C = 1;
		}
		int index = 0;
		metrix = new char [R][C];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				metrix[j][i] = input[index++];
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(metrix[i][j]);
			}
		}
	}
}
