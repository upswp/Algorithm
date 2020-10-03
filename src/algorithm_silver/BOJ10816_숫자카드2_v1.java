package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * BOJ 10816 숫자카드2
 * 
 * @author Park Sangwoo
 * @since 2020-10-03
 */
public class BOJ10816_숫자카드2_v1 {
	static int N, M;
	static int arrN[], arrM[], countM[];

	public static void main(String[] args) throws Exception {
		/*초기화 및 입력 시작*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		arrN = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		arrM = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}
		/*초기화 및 입력 끝*/

		/*countM을 arrM과 동일한 크기로 만들고 같을경우 해당 index의 값을 +1해줌.*/
		countM = new int[M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arrN[i] == arrM[j]) {
					countM[j] += 1;
				}
			}
		}
		for (int num : countM) {
			System.out.print(num+" ");
		}
	}
}
