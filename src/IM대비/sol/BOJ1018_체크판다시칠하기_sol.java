package IM대비.sol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Samsung SW역량 테스트 IM대비 
 * BOJ 1018 체스판 다시 칠하기
 * @author Park Sangwoo
 * @since 2020-09-22
 */
public class BOJ1018_체크판다시칠하기_sol {
	static int N,M,map[][],mapW[][],mapB[][];
	public static void main(String[] args) throws Exception  {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		mapW = new int[8][8]; // 왼쪽상단모서리 흰색으로 시작하는 체스판
		mapB = new int[8][8]; // 왼쪽상단모서리 검정색으로 시작하는 체스판
		initMap(); // 두 체스판 생성
		
		for (int i = 0; i < N; i++) {
			char[] line = in.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = line[j]=='W'?0:1; // 흰색은 0, 검정색 1
			}
		}
		System.out.println(process());
	}
	
	private static int process() {

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				// i,j를 왼쪽 상단 모서리로해서 8*8 처리
				int cntW=0,cntB=0;
				for (int r = i,r2=0; r<i+8; r++,r2++) {
					for (int c = j,c2=0; c <j+8; c++,c2++) {						
						// 매칸마다 두개의 mapW,mapB랑 색깔이 몇개나 다른지 체크
						if(map[r][c] != mapW[r2][c2]) cntW++;
						if(map[r][c] != mapB[r2][c2]) cntB++;
					}
				}
				int cnt = Math.min(cntW,cntB);// 두 체스판 바꿔칠해야하는 칸수 중 최소값.
				if(min>cnt) min = cnt; // 기존 최소값과 비교후 최소값 갱신
			}
		}
		return min;
	}

	//01010101	//
	//1         // 0
	// 왼쪽모서리 하얀색시작, 왼쪽모서리 검정색 시작 두개의 체스판 색칠하기
	private static void initMap() {
		int size = 64,r,c,v = 0;
		for(int s=0; s<size; ++s) {
			// s=10 :  1행 2열    s/8 : 행,  s%8 : 열
			r = s/8;
			c = s%8;
			mapW[r][c] = v; // 0
			mapB[r][c] = v^1; // 0^1: 1 ,mapW와 반대색으로 색칠 
			
			if(c<7) v = v^1; // 8개의 열이므로 마지막열에서 다음행으로 넘어갈때는 색깔 반대로 하지 않아야한다.
							 // 따라서, 마지막 열이 아닐때만 현재색과 반대로.
		}
	}
}
