package 미완성;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 3985 롤케이크
 * 
 * @author Park Sangwoo
 * @since 2020-09-02
 */
public class BOJ3985_롤케이크 {

	static int N, P;
	static int[] cake;
	static int[][] pick;
	static Point pt;

	static class Point{
		int start;
		int end;
		public Point(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		cake = new int[N];
		pick = new int[P][2];

		for (int i = 0; i < args.length; i++) {
			cake[i] = 0;
		}
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < P; i++) {
			pick[i][0] = Integer.parseInt(st.nextToken());
			pick[i][1] = Integer.parseInt(st.nextToken());
			new Point(pick[i][0], pick[i][1]);
			check(pt.start,pt.end);
		}
	}
	public static void check(int start, int end) {
		
	}
}
