package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
/**
 * BOJ 1764 듣보잡
 * @author Park Sangwoo
 * @since 2020-10-07
 */
public class BOJ1764_듣보잡 {
	static int N, M;
	public static void main(String[] args) throws Exception {
		/*초기화*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		/*시간 단축을 위하여 HashSet 사용*/
		HashSet<String> Alist = new HashSet<String>();
		ArrayList<String> resList = new ArrayList<String>();
		/*AList입력*/
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			Alist.add(tmp);
		}
		/*겹치는 경우만 resList 입력*/
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			if (Alist.contains(tmp)) resList.add(tmp);
		}
		/*정렬*/
		Collections.sort(resList);
		/*출력*/
		StringBuilder sb = new StringBuilder();
		sb.append(resList.size()).append("\n");
		for (String string : resList) {
			sb.append(string).append("\n");
		}
		System.out.println(sb);
	}
}
