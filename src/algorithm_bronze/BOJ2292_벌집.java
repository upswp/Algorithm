package algorithm_bronze;

import java.util.Scanner;

public class BOJ2292_벌집 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		System.out.println(execute(count)); // 3
	}

	public static int execute(int N) {
		int n = 2;				
		int cnt = 1;			//cnt값 초기화
		if (n == 1 ) return 1;	//방이 하나일때는 본인으로 부터 본인까지 한번 cnt
		
		while(n<=N) {
			n +=6*cnt++; 	//방이  육각형이므로 cnt값을 기준으로 6씩 곱해져서 커짐.
		}
		return cnt; 
	}
}
