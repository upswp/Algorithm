package algorithm_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 3985 롤케이크
 * 
 * @author Park Sangwoo
 * @since 2020-09-06
 */
public class BOJ3985_롤케이크 {
	static int N, P;
	static int max1,max2,res1,res2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		int cake [] = new int [N+1];
		int pick [][] = new int[P+1][2];
		for (int i = 1; i <= P; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pick[i][0] = Integer.parseInt(st.nextToken());
			pick[i][1] = Integer.parseInt(st.nextToken());
			
			int gap = pick[i][1] - pick[i][0];
			int cnt = 0;
			
			for (int j = pick[i][0]; j <= pick[i][1]; j++) {
				if (cake[j]==0) {
					cake[j] = i;
					cnt++;
				}
			}
			if (max1 < gap ) {
				max1 = gap;
				res1 = i;
			}
			if (max2 < cnt) {
				max2 = cnt;
				res2 = i;
			}
		}
		System.out.println(res1+"\n"+res2);
	}
}
