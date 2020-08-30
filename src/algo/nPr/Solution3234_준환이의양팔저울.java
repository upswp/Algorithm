package algo.nPr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Scanner;

/**
 * SSAFY SWEA 3234 준환이의 양팔저울
 * 
 * @use nPr
 * @author Park Sangwoo
 * @since 2020-08-29
 */
public class Solution3234_준환이의양팔저울 {

	static int T, N, answer;
	static int[] weights;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			weights = new int[N];
			answer = 0;
			String [] input = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(input[i]);
			}
			nPr(0,0,0);
			bw.write("#" + t + " " + answer + "\n");
		}
		br.close();
		bw.close();
	}

	public static void nPr(int cnt, int leftsum, int rightsum) { //cnt: 현재까지  뽑은 순열의 갯수
		if (cnt == N) {
			answer ++;
			return;
		}
		for (int i = cnt; i < N; i++) {
			int tmp = weights[cnt];
			weights[cnt] = weights[i];
			weights[i] = tmp;
			
			nPr(cnt+1, leftsum + weights[cnt], rightsum);
			if (weights[cnt] +rightsum <= leftsum) {
				nPr(cnt+1, leftsum, weights[cnt]+rightsum);
				
			}
			tmp = weights[cnt];
			weights[cnt] = weights[i];
			weights[i] = tmp;
		}
	}
}
