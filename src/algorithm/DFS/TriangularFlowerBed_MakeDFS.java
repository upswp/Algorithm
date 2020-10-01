package algorithm.DFS;

import java.util.HashSet;
import java.util.Scanner;

/**
 * SSAFY 문제해결을 위한 창의적 알고리즘
 * 
 * 삼각화단 만들기
 * 
 * 
 * DFS를 쓸 경우 중복을 제거해줘야하는 경우가 많다.
 * 많은 경우의 수를 전부 찾아주기 때문이다.
 * @use DFS문
 * @author Park Sangwoo
 */
public class TriangularFlowerBed_MakeDFS {

	static int N, count;
	static HashSet<Point> ts = new HashSet<>();
	static class Point{
		int a;
		int b;
		int c;
		public Point(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
		//중복안돼 set
		//실제로 찍히는 것은 없지만 중복을 막아주는 역할을 하는 친구.
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a;
			result = prime * result + b;
			result = prime * result + c;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			Point other = (Point) obj;
//			if (this.a != other.a) this 생략되어있음.
			if (a != other.a)
				return false;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			return true;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		count = 0;
		ts.clear();
		dfs(N, 1, 1, 1);
//		System.out.println(count);
		System.out.println(ts.size());
	}
	
	
	private static void dfs(int n, int a, int b, int c) {
		if (a + b + c == N) {
			if (a + b > c && a + c > b && b + c > a && a <= b && b <= c) {
				//count++;
				// 중복 안되게 저장시킴.
				ts.add(new Point(a,b,c));
//				System.out.println(a + " " + b + " " + c);
			}
			return;
		}
		dfs(n, a + 1, b, c);
		dfs(n, a, b + 1, c);
		dfs(n, a, b, c + 1);
	}
}
