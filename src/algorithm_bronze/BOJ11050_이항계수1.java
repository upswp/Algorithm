package algorithm_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 11050 이항계수1
 * 
 * @author Park Sangwoo
 * @since 2020-10-02
 */
public class BOJ11050_이항계수1 {
	static int N,K,ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nCr(0,0);
		System.out.println(ans);
	}
	private static void nCr(int start, int cnt) {
		if (cnt == K) {
			ans++;
		}
		for (int i = start; i < N; i++) {
			nCr(i+1, cnt+1);
		}
	}

}
