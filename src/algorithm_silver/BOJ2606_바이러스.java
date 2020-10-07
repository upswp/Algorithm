package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2606 바이러스
 * 
 * @author Park Sangwoo
 * @since 2020-10-07
 */
public class BOJ2606_바이러스 {
	static int N, node, x, y;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		node = Integer.parseInt(br.readLine());
		parents = new int[N + 1];

		// make set
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
		// 입력
		for (int i = 0; i < node; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			union(x,y);
		}
		int cnt = 0;
		for (int i = 0; i < parents.length; i++) {
			if(find(i)==find(1))cnt++;
		}
		System.out.println(cnt-1);
		
	}
	//union
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x!=y) parents[y]=x;
	}
	//find
	public static int find(int x) {
		if(x ==parents[x])return x;
		return parents[x] = find(parents[x]);
	}

}
