package algorithm.BFS;

import java.util.LinkedList;
import java.util.Queue;
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
public class RemoteControl_BFS {

	static int start, end;
	static int min = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		start = sc.nextInt();
		end = sc.nextInt();
		
		min = 10000;
		remote();
		System.out.println(min);
	}

	private static void remote() {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {start,0});
		while(!que.isEmpty()) {
			//현재 온도 가져와
			int[] curr = que.poll(); //current
			int cs = curr[0]; //현재온도 //current start
			int cnt = curr[1]; //최소한의 버튼 숫자 횟수
			if (end ==cs) {
				min = Math.min(min, cnt);
				return;
			}
			if (cnt>min) {
				return;
			}
			if (end<cs) {
				que.offer(new int[] {cs+10,cnt+1});
				que.offer(new int[] {cs+5,cnt+1});
				que.offer(new int[] {cs+1,cnt+1});
			}
			else {
				que.offer(new int[] {cs-10,cnt+1});
				que.offer(new int[] {cs-5,cnt+1});
				que.offer(new int[] {cs-1,cnt+1});
				
			}
		}
	}

}
