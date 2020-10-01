package algorithm.DFS;

import java.util.Scanner;

/**
 * SSAFY 문제해결을 위한 창의적 알고리즘
 *  
 * 리모컨
 * 
 * 선택의 여지가 많을때 사용하는 것은 DFS
 * 
 * @use DFS && 가지치기
 * @author Park Sangwoo
 */
public class RemoteControl_DFS {

	static int start, end;
	static int min = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		start = sc.nextInt();
		end = sc.nextInt();
		
		min = 10000;
		remote(start,0);
		System.out.println(min);
	}

	private static void remote(int tmp, int cnt) {
		if (cnt>min) {
			return;
		}
		//여기 최소값 구하는 소스는 너무 기본적인것이니 꼭 외우기
		if (tmp == end) {
			if (cnt<min) {
				min = cnt;
			}
		}
		//가지치기
		if (tmp < end) {
			//큰온도 부터 채우기 --> 그리드 탐욕기법
			remote(tmp+10,cnt+1);
			remote(tmp+5,cnt+1);
			remote(tmp+1,cnt+1);
		}
		else {
			remote(-10, cnt);
			remote(-5, cnt);
			remote(-1, cnt);
		}
	}

}
