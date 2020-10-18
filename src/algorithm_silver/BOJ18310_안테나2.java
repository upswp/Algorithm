package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * BOJ 18310 안테나
 * @author Park Sangwoo
 * @since 2020-10-18
 */
public class BOJ18310_안테나2 {
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
		Arrays.sort(house);
		System.out.println(house[N/2-1]);
	}
}
