package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * BOJ 2751 수 정렬하기 2
 * 
 * @author Park Sangwoo
 * @since 2020-10-05
 */
public class BOJ2751_수정렬하기2_v1 {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		for (int val : list) {
			sb.append(val).append("\n");
		}
		System.out.println(sb);
	}
}
