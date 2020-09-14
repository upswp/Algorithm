package algorithm_gold;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1707_이분그래프 {
	static int T;
	static int V, E;
	static int parents[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; // 입력시작
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parents = new int[V + 1];

			// makeset
			for (int i = 1; i <= V; i++) {
				parents[i] = i;
			}

			// union
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				union(A, B);
			}
//			3
//			0 1 2 3
//			1 2 3 
			boolean check = false;
			for (int i = 1; i < parents.length-1; i++) {
				if (parents[1] != parents[i+1]) {
					check = true;
					break;
				}
				
			}
			System.out.println(check?"Yes":"No");
//			System.out.println(Arrays.toString(parents));
		}
	}

	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb) {
			return;
		} else {
			parents[pb] = pa;
		}
	}

	public static int find(int a) {
		if (parents[a] == a) {
			return a;
		} else {
			return parents[a] = find(parents[a]);
		}
	}
}