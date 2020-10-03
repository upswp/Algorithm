package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * BOJ 10814 나이순 정렬
 * 
 * @author Park Sangwoo
 * @since 2020-10-03
 */
public class BOJ10814_나이순정렬_v2 {
	static int N;
	static String age[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		age = new String[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				age[i][j] = st.nextToken();
			}
		}
		Arrays.sort(age, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
			}

		});

		for (int i = 0; i < age.length; i++) {

			System.out.println(age[i][0] + " " + age[i][1]);

		}
	}
}
