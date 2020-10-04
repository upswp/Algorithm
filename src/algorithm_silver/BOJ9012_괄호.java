package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BOJ 9012 괄호
 * @author Park Sangwoo
 * @since 2020-10-05
 */
public class BOJ9012_괄호 {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			/*괄호 수 만큼 arr생성*/
			char[] text = br.readLine().toCharArray();
			/*동일하게 방문여부를 알 수 있는 boolean형식 생성*/
			boolean [] visit = new boolean [text.length];
			for (int i = 0; i < text.length; i++) {
				if (text[i]=='(') {
					for (int j = i; j < text.length; j++) {
						if (text[j]==')'&& !visit[j]) {
							visit[i] = true;
							visit[j] = true;
							break ;
						}
					}
				}
			}
			/*결과출력*/
			String res ="";
			for (int i = 0; i < visit.length; i++) {
				if (visit[i]==true) {
					res = "YES";
				}else {
					res = "NO";
					break;
				}
			}
			System.out.println(res);
		}
	}

}
