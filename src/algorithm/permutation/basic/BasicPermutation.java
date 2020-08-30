package algorithm.permutation.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * Basic Permutation
 * @author Park Sangwoo
 * @since 2020-08-30
 */
public class BasicPermutation {
	
	static int N, R;
	static boolean[] visit;
	static int[] nums;
	static int[] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		nums = new int [N];			//전체 숫자 N개 만큼 0으로 초기화
		visit = new boolean [N];	//false로 초기화
		ans = new int [R];			//뽑을 수 만큼 크기로 0으로 초기화
		
		//-----입력
		String input[] = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(input[i]);
		}
		//-----입력끝
		nPr(0);

		br.close();
		bw.close();
	}
	/**
	 * 지정된 자리에 순열 수 뽑기
	 * @param cnt : 현재까지 뽑은 순열의 갯수
	 */
	public static void nPr(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				ans[cnt] = nums[i]; // 해당 숫자 사용
				visit[cnt] = true; 	// 해당 숫자의 위치로 사용처리
				nPr(cnt+1); 		// 다음 자리 순열 뽑기
				visit[cnt] = false;	// 사용하지 않았다고 처리 다시 해주기.
			}
		}
	}

}
