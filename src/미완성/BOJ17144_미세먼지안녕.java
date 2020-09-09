package 미완성;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17144_미세먼지안녕 {

	static class Point{
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int R, C, T;
	static int [][] map;
	static int [][] E; // 임시 배열
	static ArrayList<Point> cleaner;
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int [R][C];
		//객체를 초기화 시켜주는 작업. (main 안에서 하는것이 좋음.)
		cleaner = new ArrayList<>();
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				check(map[i][j],i,j);
			}
		}// 입력받았음
		
		for(int time=0; time<1; time++) {
			
			spread();
			
			// 공기청정기 작동 -> 먼지 이동
			
			// 처음 공기청정기 cleaner 0
			Point c1 = cleaner.get(0);
			// 밑 공기청정기
			Point c2 = cleaner.get(1);
			
			/* 위쪽 공기청정기 시작 */
			// 오른쪽으로 밀기
			int right = map[c1.r][C-1];
			
			for(int col=C-1; col>0; col--) {
				map[c1.r][col] = map[c1.r][col-1];
			}
			map[c1.r][1] = 0; // 공기청정기 바로 오른쪽에 있는 먼지
			
			// 위로 밀기
			// c1.r 위의 두 칸위까지만
			int up = map[0][C-1]; // 위로 올렸을 때 사라질 애를
			for(int row=0; row<c1.r-1; row++) {
				map[row][C-1] = map[row+1][C-1];
			}
			map[c1.r-1][C-1] = right;
			
			// 왼쪽으로 밀기
			int left = map[0][0];
			for(int col=0; col<C-1; col++) {
				map[0][col] = map[0][col+1]; // 뒤에있는애를 한칸씩 떙겨오는
			}
			map[0][C-2] = up;
			
			// 아래쪽으로 밀기
			for(int row=c1.r-1; row > 0; row--) {
				map[row][0] = map[row-1][0];
			}
			map[1][0] = left;
			
			// -1 0 1 2 3
			// -1 -1 0 1 2
			/* 아래쪽 공기청정기 시작 */
			// 오른쪽으로 밀기
			int right2 = map[c2.r][C-1];
			for (int col = C-1; col > 0; col--) {
				map[0][col] = map[0][col-1];
			}
			map[c2.r][1] =0;
			
			//밑으로 밀기
			/*
			  0 1 2 3          0 0 1 2
			        4				 2 				 
			        5                4
			        6				 5	
			 */
			/*
			 0    왼쪽에서부터
			 1    밀린값
			 2    1
			 3    2
			 */
			for (int row = R-1; row > c2.r; row++) {
				map[row][C-1] = map[row-1][C-1];
			}
			
		}
	}
	
	public static void spread() {
		// 먼저 먼지가 확산이 다 된후에
		E = new int[R][C]; // 확산할 때마다 새로 만들어준다.
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				// 공기청정기 이거나, 먼지가 없는 부분은 건너뛰고
				if(map[i][j] == -1 || map[i][j] == 0) continue;
				
				// 먼지 확산
				int dust = map[i][j]/5; // 양
				int count = 0;			// 몇방향으로
				
				for(int d=0; d<4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d]; // 방향으로 더해준
					
					if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
					if(map[nx][ny] == -1) continue;
					
					// 확산이 될 수 있는 경우
					E[nx][ny] += dust;
					count += 1;
				}
				
				// 확산이 끝났으면
				E[i][j] += map[i][j] - (count * dust);
			}
		}
		
		for(int i=0; i<R; i++) { 
			for(int j=0; j<C; j++) {
				map[i][j] = E[i][j];
			}
		}
		
		// i 0, 1
		for(int i=0; i<cleaner.size(); i++) {
			Point p = cleaner.get(i);
			map[p.r][p.c] = -1;
		}
	}
	
	public static void check(int map,int i,int j) {
		if (map == -1) {
			//ArrayList안에 들어가는 i,j는 Point 형식이므로 Point형식으로 생성이 필요.
			cleaner.add(new Point(i,j));
		}
	}

}
