package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BOJ 1676 팩토리얼 0의 개수
 * 
 * @author Park Sangwoo
 * @since 2020-10-07
 */
public class BOJ1676_팩토리얼0의개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int cnt2 = 0, cnt5 = 0;
		for (int i = 2; i < N; i *= 2) cnt2 += N / i;	//2씩 곲해서 나눈 값으로 나눈 몫 cnt2로 합
		for (int i = 5; i < N; i *= 5) cnt5 += N / i;	//5씩 곱해서 나눈 값으로 나눈 몺 cnt5로 합

		System.out.println(Math.min(cnt2, cnt5));
	}
}
