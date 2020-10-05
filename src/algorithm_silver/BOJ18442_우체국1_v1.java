package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18442_우체국1_v1 {
	
	static int T,V,P,count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());		//testcase
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());	//마을갯수
			P = Integer.parseInt(st.nextToken());	//경찰서갯수
			
			count = 0;								//총합 초기화
			nCr(0,0);								//조합
			System.out.println("#"+t+" "+count);
		}
	}
	public static void nCr(int start, int cnt) {
		if (cnt == P) {
			count++;								//V개 중 P개가 조건이 맞을때
			return;									//count++ 실시.
		}
		for (int i = start; i < V; i++) {
			nCr(i+1, cnt+1);
		}
	}

}
