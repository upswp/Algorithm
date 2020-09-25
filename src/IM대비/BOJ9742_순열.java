package IM대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * Samsung SW역량 테스트 IM대비 BOJ 9742 순열
 * 
 * @author Park Sangwoo
 * @since 2020-09-24
 */
public class BOJ9742_순열 {

	static char ans[];
	static String arr;
	static char input[];
	static int R, count;
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";

		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, " "); // line으로 위에서 읽어오므로 다시 읽어올 필요가 없음.
			arr = st.nextToken();
			ans = new char[arr.length()];
			input = new char[arr.length()];
			visit = new boolean[arr.length()];

			R = Integer.parseInt(st.nextToken());
			input = arr.toCharArray();
			count = 0;	//	TestCase마다 count 초기화 실시 꼭할것!
				nPr(0);
				if (count<R) {
					System.out.print(arr + " " + R + " = ");
					System.out.println("No permutation");
				}
		}
	}

	public static void nPr(int cnt) {
		
		if (cnt == arr.length()) {
			count++;
			if (count == R) {
				System.out.print(arr + " " + R + " = ");
				for (int i = 0; i < ans.length; i++) {
					System.out.print(ans[i]);
				}
				System.out.println();
			}
			return;
		}
		for (int i = 0; i < arr.length(); i++) {
			if (!visit[i]) {
				ans[cnt] = input[i];
				visit[i] = true;
				nPr(cnt + 1);
				visit[i] = false;
			}
		}
	}

}
