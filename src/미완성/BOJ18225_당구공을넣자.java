package 미완성;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18225_당구공을넣자 {

	static int rowA, colB, targetX, targetY, rightP, upQ, cnt;
	static int[] dr = { rightP, -rightP, upQ, -upQ };
	static int[] dc = { upQ, -upQ, rightP, -rightP };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		rowA = Integer.parseInt(st.nextToken());
		colB = Integer.parseInt(st.nextToken());
		targetX = Integer.parseInt(st.nextToken());
		targetY = Integer.parseInt(st.nextToken());
		rightP = Integer.parseInt(st.nextToken());
		upQ = Integer.parseInt(st.nextToken());
		cnt = 0;
		for (int r = targetX; r < rowA; r++) {
			for (int c = targetY; c < colB; c++) {
				dfs(r, c, 0, 0);// 0 1 2 3
			}
		}
		System.out.println(cnt);
	}
	private static void dfs(int r, int c, int ct, int d) {
		//rightP,upQ만큼 이동을 4방 진행.
		//for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			//check
//			if (nr >= 0 && nr <= rowA && nc >= 0 && nc <= colB)
//				continue;
			//당구공이 꼭지점을 만났을때
			if ((nr == 0 && nc == 0) || (nr == 0 && nc == colB) || (nr == rowA && nc == 0) || (nr == rowA && nc == colB)) {
				ct++;
				cnt = ct;
				return;
			//무한히 계속 돌아갈 경우, targetX,Y값에 그대로 다시 돌아올때.
			}
			//그렇지 않을경우는 cnt를 늘려주고 재귀호출
			else if (nr == 0 || nc == 0 || nr == rowA || nc == colB) {
				ct++;
				dfs(nr, nc, ct, d+1);
			}
			else if (nr == targetX && nc == targetY) {
				System.out.println(-1);
			}
			//벽을 만나지는 않았고 이동거리 만큼 갔을 경우 추가로 더 이동거리를 갈 수 있도록 하는 것.
			else {
				dfs(nr, nc, ct, d);
			}
		//}
	}
}
