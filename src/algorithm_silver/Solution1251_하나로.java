package algorithm_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SSAFY SWEA 1251 하나로
 * @author Park Sangwoo
 * @since 2020-09-03
 * @use prim
 */
public class Solution1251_하나로 {
	
	static int T , N;
	static long E;
	static int [][] land;
	static boolean [] visited;
	static int [] minEdge;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		/*
		 * T : testcase
		 * N : 섬의 갯수 (1<=N<=1000)
		 * land : 각 섬들의 X,Y 좌표 (0≤X≤1,000,000, 0≤Y≤1,000,000)
		 * E: 해저터널 건설의 환경 부담 세율 실수 E (0<=E<=1)
		 */
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			land = new int [N][2];
			visited = new boolean[N];
			minEdge = new int [N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < N; j++) {
					land[i][0] = Integer.parseInt(st.nextToken());
					land[i][1] = Integer.parseInt(st.nextToken());
				}
				minEdge[i] = Integer.MAX_VALUE;
			}
			E = Long.parseLong(br.readLine());
			//end input
			int minVertex,min,result = 0;
	        minEdge[0] = 0;
	        
	        for (int c = 0; c < N; c++) {
				min = Integer.MAX_VALUE;
				minVertex = 0;
				
				for (int i = 0; i < N; i++) {
					if (!visited[i] && minEdge[i] < min) {
						min = minEdge[i];
						minVertex = i;
					}
				}
				result = min;
				visited[minVertex] = true;
				
				for (int j = 0; j < N; j++) {
					if (!visited[j] && land[minVertex][j] != 0 && land[minVertex][j] < minEdge[j]) {
						minEdge[j] = land[minVertex][j];
					}
				}
			}
		System.out.println(result);	
			
		}//end Testcase
	}//end main

}
