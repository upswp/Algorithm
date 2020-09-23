package IM대비.sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author taeheeKim
 *
 */
// B2578_빙고
public class BOJ2578_빙고 {

	private static int map[][], no[]; // map : 철수의 빙고판, no : 사회자가 부르는 숫자순서리스트
	private static int[] dr = {-1,0,-1,1,-1,1,0,1};
	private static int[] dc = {0,-1,-1,-1,1,1,1,0};
	// 상(0), 좌(1), 좌상(2), 좌하(3), 우상(4), 우하(5),우(6),  하(7)
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		no = new int[25];
		
		StringTokenizer st = null;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine(),	" ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 철수 빙고판 입력 끝
		
		
		for (int i = 0,k=0 ; i < 5; i++) {
			st = new StringTokenizer(in.readLine(),	" ");
			for (int j = 0; j < 5; j++) {
				no[k++] = Integer.parseInt(st.nextToken());
			}
		}// 사회자 숫자 순서리스트 입력 끝
		System.out.println(play());
	}

	// 빙고 게임 진행하고 빙고가 완성된 숫자 호출횟수를 반환한다.
	private static int play() {
		
		int cnt = 0; // 빙고 라인의 누적수 
		// 차례차례 사회자가 숫자를 부른다. : 숫자리스트 반복돌려 처리 
		for (int i = 0; i < 25; i++) {
			// 사회자가 부른 숫자를 빙고판에서 지운다.
			int[] pos = mark(no[i]);
			if(i<4) continue;
			// 현재 숫자로 인해 빙고라인이 몇개 형성되는지 체크한다.
			cnt += check(pos[0],pos[1]);
			// 현재까지 누적된 빙고라인의 수가  3이상일때 게임 끝.(사회자가 숫자를 몇번째 불렀는지 출력)
			if(cnt >= 3) return i+1;
		}
		return 0;
	}

	// 받은 숫자를 빙고판에서 지우고 해당 숫자의 좌표의 값을 배열로 리턴 
	private static int[] mark(int value) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 ; j++) {
				if(map[i][j] == value) { // 숫자 찾았으면
					map[i][j] = 0; // 1~25의 값이 아닌값으로 지우는 처리 
					return new int[] {i,j};
				}
			}
		}
		return null;
	}
	
	// 현재 위치의 8방을 체크하여 새롭게 추가되는 빙고라인의 수를 반환
	private static int check(int row, int col) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) { // 라인 4개 체크
			// d:0  , d:7 : 현재 방향의 반대 방향으로 라인 함께 체크
			if(checkLine(row,col,d) + checkLine(row,col,7-d) == 4) ++cnt;
		}
		return cnt;
	}

	// 현재 위치에서 지정된 방향으로만 연속성 체크하여 연속지워진 개수 리턴
	private static int checkLine(int row, int col, int d) {
		int nr=row,nc=col,temp=0;
		
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr>=0 && nr<5 && nc>=0 && nc<5 && map[nr][nc]==0) ++temp; //  경계를 벗어나지 않으며 지워진 연속된 숫자면 카운트
			else break; // 연속성 끝이므로 빠져나옴
		}
		return temp;
	}
	
}
