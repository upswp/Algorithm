package algorithm_gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1953_탈주범검거_sol {

	static int N,M,R,C,L;
	static int[][] map;
	static int[][] visited;
	static int T;
	static int cnt; 
	static int[] dr= {-1, 0,0,1};// 상0좌1우2하3
	static int[] dc= { 0,-1,1,0};
	static int [][] dd= {{0},
			{0,1,2,3},
			{0,3},
			{1,2},
			{0,2},
			{2,3},
			{1,3},
			{0,1}};
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();
			M=scann.nextInt();
			R=scann.nextInt();
			C=scann.nextInt();
			L=scann.nextInt();
			map=new int[N][M];
			visited=new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j]=scann.nextInt();
				}
			}
			cnt=0;
			bfs();
			counting();
			System.out.println("#"+t+" "+cnt);
		}

	}
	static void counting() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j]>0 && visited[i][j]<L+1) {
					cnt++;
				}
			}
		}
	}
	static void bfs() {
		Queue<int[]> que=new LinkedList<int[]>();
		que.add(new int[] {R,C,map[R][C],1});//r c d방향 시간
		visited[R][C]=1;// 1 2 3 거리 자취
		while(!que.isEmpty()) {
			int[] cur=que.poll();
			int cr=cur[0];
			int cc=cur[1];
			int cd=cur[2];// 현 방향
			int ct=cur[3];
			if(ct==L) {
				return ;
			}
			for (int d = 0; d < dd[cd].length; d++) {
				int dir=dd[cd][d];// 다음방향
				int nr=cr+dr[dir];
				int nc=cc+dc[dir];
				if(!check(nr, nc)) continue;
				if(map[nr][nc]==0) continue;
				if(visited[nr][nc]!=0)continue;
				// 현방향+다음방향p의 파이프 연결가능?
				int p=map[nr][nc];// 다음방향
				if(dir==0) {//위
					if(p==3 || p==4 || p==7) continue;
				}else if(dir==1) {
					if(p==2 || p==6 || p==7) continue;
				}else if(dir==2) {
					if(p==2 || p==4 || p==5) continue;
				}else if(dir==3) {
					if(p==3 || p==5 || p==6) continue;
				}
				visited[nr][nc]=visited[cr][cc]+1;
				que.add(new int[] {nr,nc,map[nr][nc],ct+1});//r c d방향 시간
			}
		}
	}
	
	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
