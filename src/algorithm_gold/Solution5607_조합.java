package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * SSAFY SWEA 5607 조합
 * @author Park Sangwoo
 * @since 2020-09-28
 * @use 페르마의 소정리
 * @use 조합
 */
public class Solution5607_조합 {
	
	static int T,N,R;
	static int mod = 1234567891;
	static long fac[] = new long[1000001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			fac[0] = 1;
			for (int i = 1; i < fac.length; i++) {
				fac[i] = (fac[i-1]*i)%mod;
			}
			
			long problem = (fac[R]*fac[N-R]) %mod;		//problem 1234567891로 나눌 값을 구하기.
			long ans = ferma(problem,mod-2);
			
			System.out.println();
		}
	}

	private static long ferma(long problem, int i) {
		if (i ==0) {
			
		}
		if (i%2==0) {
			
		}
		return 0;
	}

}
