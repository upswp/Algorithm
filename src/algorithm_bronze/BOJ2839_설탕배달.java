package algorithm_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BOJ 2839 설탕배달
 * 
 * @author Park Sangwoo
 * @since 2020-10-02
 */
public class BOJ2839_설탕배달 {
	static int N, min;

	public static void main(String[] args) throws Exception {
		/*초기화*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		/*초기화*/
		
		/*함수호출*/
		recursion(0, 0);
		
		
		/*print*/
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}

	public static void recursion(int sum, int cnt) {
		if (sum > N) {					//N 보다 클 경우 종료
			return;
		}
		if (sum == N) {					//N 값과 더한 값이 같을 경우 cnt 넘겨주기
			min = Math.min(min, cnt);	//최소값 비교
			return;
		}
		if ((N - sum) % 5 == 0) {		//sum 값이 3씩 증가하며 N값에서 뺏을때 5로 나누어 떨어지는 경우.
			cnt += (N - sum) / 5;		//cnt를 N-sum을 5로 나눈 몫만큼 더해준다.
			min = Math.min(min, cnt);	//최소 값 비교.
			return;
		}
		recursion(sum + 3, cnt + 1);	//resursion
	}
}