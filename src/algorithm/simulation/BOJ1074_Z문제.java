package algorithm.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * SSAFY BOJ 1074
 * 
 * Z문제
 * 
 * @author Park Sangwoo
 * @since 2020-08-25
 */
public class BOJ1074_Z문제 {
	static int N,n,r,c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int R = 0;
		int C = 0;
		int result =0;
		N = 1<<n;
//		N =getSize(n);
		/**
         * 사각형 절반으로 나눠서 각 사분면으로 계산
         * n이 1이 된다는 것은 x, y 좌표가 r, c랑 같아진다는 것
         */
		/* result 값.
		 * (n/2) * (n/2) * 0
		 * (n/2) * (n/2) * 1
		 * (n/2) * (n/2) * 2
		 * (n/2) * (n/2) * 3
		 * 각 분면의 첫번째 값을 가르킴.
		 */
		while(N > 0) {
			N = N/2;
			if (r<N+R && c<N+C) {		//1사분면
				result += N * N *0;
			}else if(r<N+R){			//2사분면
				result += N * N *1;
				C += N;
			}else if(c<N+C){			//3사분면
				result += N * N *2;
				R += N;
			}else {						//4사분면
				result += N * N *3;
				R += N;
				C += N;
			}
			if(N == 1) {
                System.out.println(result);
                break;
            }
		}
		
	}
//	static int getSize(int n) {
//        int result = 1;
//        for(int i=0; i<n; i++)
//            result *= 2;
//        return result;
//    }

}
