package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 2609 최대공약수와 최소공배수
 * @author Park Sangwoo
 * @since 2020-10-28
 * 
 * @use 유클리드 호제법
 *  유클리드 호제법은 2개의 자연수의 최대공약수를 구하는 알고리즘으로 
 *  호제법이란, 두 수가 서로 상대방 수를 나누어 결국 원한느 수를 얻는 알고리즘을 말한다. 
 *  
 *  m>= n일때, 
 *  1) m을 n으로 나눈다. 나머지를 r이라고 한다.
 *  2) 나머지 r이 0이면 n이 최대공약수이다. 
 *     나머지가 0이 아니라면 
 *     m의 값을 n으로 설정하고 , n의 값은 r로 설정한다음 (m -> n, n -> r)
 *     1)로 되돌아가서 반복한다.
 *
 */
public class BOJ2609_최대공약수와최소공배수 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long gcd = getGcd(Math.max(M, N),Math.min(M, N));
		long lcm = getLCM(M, N, gcd);
		
		System.out.println(gcd);
		System.out.println(lcm);
	}
	
	public static long getGcd(long a, long b) {
		while(b>0){
			long tmp = a;
			a = b;
			b = tmp%b;
		}
		return a;
	}
	public static long getLCM(long a, long b, long gcd) {
        return (a*b)/gcd;
    }

}

