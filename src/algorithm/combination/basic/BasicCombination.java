package algorithm.combination.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Array;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * Basic Combination
 * @author Park Sangwoo
 * @since 2020-08-30
 */
public class BasicCombination {
	
	static int N, R;
	static int[] nums;
	static int[] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		nums = new int [N];			//전체 숫자 N개 만큼 0으로 초기화
		ans = new int [R];			//뽑을 수 만큼 크기로 0으로 초기화
		
		//-----입력
		String input[] = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(input[i]);
		}
		//-----입력끝
		nCr(0,0);

		br.close();
		bw.close();
	}
	/**
	 * 지정된 자리에 조합 수 뽑기.
	 * @param cnt	: 현재까지 뽑은 조합수의 갯수
	 * @param start	: 조합에 시작점으로 시도할 원소 index
	 */
	public static void nCr(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		/*
		 * 현재 자리에 시작 위치 수 부터 끝 위치 수까지 시도.
		 */
		for (int i = start; i < N; i++) {
			ans[cnt] = nums[i];
			nCr(cnt+1, i+1);
		}
	}

}
