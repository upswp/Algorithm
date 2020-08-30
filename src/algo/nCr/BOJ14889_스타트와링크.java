package algo.nCr;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ14889_스타트와링크 {
	static int N ,min;
	static int [][] team;
	static boolean [] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		visit = new boolean[N];
		team = new int[N][N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(input[j]);
			}
		}
		combination(0,0);
		System.out.println(min);
		
	}
	public static void combination(int cnt, int start) {
		if (start>=N) {
			return;
		}
		if (cnt == N/2) {
			int STARTteam = 0;
			int LINKteam = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if (visit[i] != visit[j]) {
						continue;
					}
					if (visit[i]) {
						STARTteam += team[i][j] + team[j][i];
					}
					else {
						LINKteam += team[i][j] + team[j][i];
					}
				}
			}
			min = Math.min(min, Math.abs(STARTteam - LINKteam));
			return;
		}
		for (int i = start; i < N; i++) {
			visit[i] = true;
			combination(cnt+1, i+1);
			visit[i] = false;
		}
	}
}
