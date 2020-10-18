package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 18310 안테나
 * @author Park Sangwoo
 * @since 2020-10-18
 */
public class BOJ18310_안테나 {
	static int N,house[],ans,tmp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		house = new int [N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(st.nextToken());
		}
		
		distance();
		System.out.println(ans);
	}
	public static void distance() {
		int min = Integer.MAX_VALUE;
		a :for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if(min<sum)continue a;
				sum += Math.abs(house[i] - house[j]);
			}
			if (min>sum) {
				min = sum;
				tmp = house[i];
			}
		}
		ans = tmp;
	}
}
