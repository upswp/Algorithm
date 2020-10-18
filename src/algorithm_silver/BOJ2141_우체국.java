package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ2141_우체국 {

	static int N, ans,tmp;
//	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int arr[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		 postOffice();
		 System.out.println(ans);
	}

	public static void postOffice() {
		int max = Integer.MIN_VALUE;
		a: for (int i = 0; i < N; i++) {
			int sum  = 0;
			for (int j = 0; j < N; j++) {
				sum += Math.abs(arr[i][1] - arr[j][1]);
				if(max>sum)continue a;
			}
			if(max<sum) {
				max = sum;
				tmp = arr[i][0];
			}
		}
		ans = tmp;
	}
}

//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine()," ");
//			int index = Integer.parseInt(st.nextToken());
//			int value = Integer.parseInt(st.nextToken());
//			map.put(index, value);
//		}
//		store();
//		System.out.println(ans);
//	}
//	public static void store() {
//		int min = Integer.MAX_VALUE;
//		int res = 0;
//		for (int i = 0; i < N; i++) {
//			int sum = 0;
//			for (int j = 0; j < N; j++) {
//				sum += map.get(i) - map.get(j);
//			}
//			if (min>sum) {
//				min = sum;
//				res = map.get(i);
//			}
//		}
//		ans = min;
//	}
