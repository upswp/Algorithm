package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * BOJ 11650 좌표정렬하기
 * 
 * @author Park Sangwoo
 * @since 2020-10-02
 */
public class BOJ11650_좌표정렬하기 {
	/*
	 * Comparable
	 */
	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int compareTo(Point o) {
			return Integer.compare(this.x, this.y);
		}

		@Override
		public String toString() {
			return x + " " + y;
		}
	}
	/*
	 * Comparator
	 */
	static class PointComaprator implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			if (o1.x == o2.x) {
				return (o1.y - o2.y);
			}
			return (o1.x - o2.x);
		}

	}

	static int N;
	static Point[] point;

	public static void main(String[] args) throws Exception {
		/*초기화 시작*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		point = new Point[N];
		/*초기화  끝*/
		
		/*입력  시작*/
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			point[i] = new Point((Integer.parseInt(st.nextToken())), (Integer.parseInt(st.nextToken())));
		}
		/*입력  입력 끝*/
		
		Arrays.sort(point, new PointComaprator());	// sort
		print(point);	//print
	}

	/*
	 * print 메서드
	 */
	private static void print(Point[] point) {
		for (Point ans : point) {
			System.out.println(ans);
		}
	}

}
