package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14620_꽃길 {

	static int N, map[][];
	static boolean check[][];
	static int min = Integer.MAX_VALUE;
	static int dr[] = { 1, -1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer(0, 1, 0);
		System.out.println(min);
	}

	static void answer(int cnt, int start, int sum) {
		if (cnt == 3) {
			min = Math.min(min, sum);
			return;
		}
		for (int i = start; i < N-1; i++) {
			for (int j = 1; j < N-1; j++) {
				if (check[i][j] || !table(i, j)) continue;
				check[i][j] = true;
				int tmpSum = map[i][j];

				for (int k = 0; k < 4; k++) {
					check[i + dr[k]][j + dc[k]] = true;
					tmpSum += map[i + dr[k]][j + dc[k]];
				}
				answer(cnt + 1, i, sum + tmpSum);

				check[i][j] = false;
				for (int k = 0; k < 4; k++) {
					check[i + dr[k]][j + dc[k]] = false;
				}
			}
		}
	}

	static boolean table(int r, int c) {
		for (int i = 0; i < 4; i++) {
            int nx = r + dr[i];
            int ny = c + dc[i];
            
            if(r < 0 ||  r >= N || c < 0 || c >= N || check[nx][ny])
                return false;
        }
        return true;
	}

}
