package IM대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Samsung SW역량 테스트 IM대비 BOJ 2605 줄세우기
 * 
 * @author Park Sangwoo
 * @since 2020-09-23
 */
public class BOJ2605_줄세우기 {
	static int N;
	static int num[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			list.add(list.size() - num[i],i+1);			// list의 (list.size() - num[i])의 위치에 i+1값을 대입한다.
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}

}
