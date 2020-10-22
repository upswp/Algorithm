package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NHN모의테스트 {
	
	static int sizeOfMatrix, matrix[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sizeOfMatrix = Integer.parseInt(br.readLine());
		matrix = new int [sizeOfMatrix][sizeOfMatrix];
		for (int i = 0; i < sizeOfMatrix; i++) {
			String input = br.readLine();
			for (int j = 0; j < sizeOfMatrix; j++) {
				matrix[i][j] = input.charAt(j) - '0';
			}
		}
		/*input end*/
		int cnt = 1;
		
		for (int i = 0; i < sizeOfMatrix; i++) {
			for (int j = 0; j < sizeOfMatrix; j++) {
				if (matrix[i][j]  == 1) {
					bfs(i,j,++cnt);
				}
			}
		}
		
		System.out.println(cnt-1);
		int ans [] = new int [cnt+1];
		for (int i = 2; i < cnt+1; i++) {
			int countValue = 0;
			for (int j = 0; j < sizeOfMatrix; j++) {
				for (int k = 0; k < sizeOfMatrix; k++) {
					if (matrix[j][k] == i) {
						countValue ++;
					}
				}
			}
			ans[i-1] = countValue;
		}
		Arrays.sort(ans);
		for (int j = 2; j < cnt+1; j++) {
			System.out.println(ans[j]+" ");
		}
	}
	
	static int dr [] = {0,0,1,-1};
	static int dc [] = {-1,1,0,0};
	private static void bfs(int r, int c, int cnt) {
		Queue<int[]> que = new LinkedList<int[]>();
		matrix[r][c]=cnt;				//******최초 방문 지점 꼭 체크하기****** 
		que.offer(new int [] {r,c});
		while(!que.isEmpty()) {
			int [] crr = que.poll();
			int cr = crr[0];
			int cc = crr[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d]; 
				int nc = cc + dc[d];
				if (check(nr,nc)) continue;
				if (matrix[nr][nc] == 1) {
					matrix[nr][nc] = cnt;
					que.offer(new int[] {nr,nc});
				}
			}
		}
	}
	private static boolean check(int nr, int nc) {
		if (nr < 0 || nr >= sizeOfMatrix || nc < 0 || nc >= sizeOfMatrix) {
			return true;
		}else return false;
	}
}
