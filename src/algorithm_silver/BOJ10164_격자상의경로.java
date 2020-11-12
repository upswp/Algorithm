package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10164_격자상의경로 {

	static int dr[] = {0,1};
	static int dc[] = {1,0};
	static int N,M,K,map[][],cnt;
	static boolean flag, visited[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = num++; 
			}
		}
		
		visited[0][0] = true;
		dfs(0,0);
		System.out.println(cnt);
	}

	static void dfs(int r, int c) {
		if(K == 0) flag = true;
		if (map[r][c] == N*M && flag) {
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(visited[i][j]?1:0);
//				}
//				System.out.println();
//			}
//			System.out.println();
			cnt++;
			return;
		}
		for (int d = 0; d < 2; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr,nc)) continue;
			if (K != 0 && map[nr][nc] == K) flag = true;
			
			if (!visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
				visited[nr][nc] = false;
				
			}
			if (K != 0 && map[nr][nc] == K) flag = false;
		}
	}
	static boolean check(int nr, int nc) {
		return nr>=0 && nr <N && nc>=0 && nc<M;
	}
}
