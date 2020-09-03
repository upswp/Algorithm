package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 1697 숨바꼭질
 * @author Park Sangwoo
 * @since 2020-09-02
 */
public class Solution1767_프로세서연결하기 {
	static int T, N;
	static int[][] metrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			metrix = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < args.length; j++) {
					metrix[i][j] = Integer.parseInt(st.nextToken());
					if (metrix[i][j] == 1) {
						
					}
				}
			}
			
		}
	}
}
