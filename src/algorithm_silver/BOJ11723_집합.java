package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 11723 집합
 * @author Park Sangwoo
 * @since 2020-10-11
 */
public class BOJ11723_집합 {
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		
		boolean S[] = new boolean[21]; //(1 ≤ x ≤ 20) S
		
		for (int input = 0; input < M; input++) {
			StringTokenizer st = null;
			st = new StringTokenizer(br.readLine());
			String check = st.nextToken();
			//S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
			if (check.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				S[num] = true;
			//S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)	
			}else if (check.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if (S[num]) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			// S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
			}else if (check.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				S[num] = false;
				
			//S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)	
			}else if (check.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if (S[num]) {
					S[num] = false;
				}else {
					S[num] = true;
				}
			//S를 {1, 2, ..., 20} 으로 바꾼다.	
			}else if (check.equals("all")) {
				for (int i = 1; i < S.length; i++) {
					S[i] = true;
				}
			//S를 공집합으로 바꾼다. 	
			}else if (check.equals("empty")) {
				for (int i = 1; i < S.length; i++) {
					S[i] = false;
				}
			}
		}
		System.out.println(sb);
	}
}
