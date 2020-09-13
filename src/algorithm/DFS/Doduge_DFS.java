package algorithm.DFS;

import java.util.Scanner;


public class Doduge_DFS {

static int N;
static int [][] map;
static int[] count;
// FF (아파트, 단지 , 두더지 )문제
public static void main(String[] args) {
    Scanner scann=new Scanner(System.in);
    N=scann.nextInt();
    map=new int[N][N];
    count=new int[N];
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            map[i][j]=scann.nextInt();
        }
    }
    
    int cnt=0;// 단지 A, B, C 
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if(map[i][j]==1) {
                cnt++;
                dfs(i,j,cnt+1); //2단지 ,3단지
            }
        }
    }
    System.out.println(cnt);
	 for (int i = 0; i < N; i++) {
		if(count[i]!=0) {
			System.out.println(i+" "+(count[i]+1));
		}
    }
}
static int[] dr= {0,0,1,-1};
static int[] dc= {1,-1,0,0};//우좌상하

//재귀  -> 콜스텍 -> DFS  ( depth first search )
private static void dfs(int r, int c, int ct) {
    map[r][c]=ct; // 2 3단지....
    for (int d = 0; d < 4; d++) {
        int nr=r+dr[d];
        int nc=c+dc[d];
        if(!check(nr,nc)) { continue; }// 상하좌우 외부
        if(map[nr][nc]==1) {
            count[ct]++;
            dfs(nr,nc,ct);
        }
    }
}

private static boolean check(int r, int c) {
    if(r>=0 && r<N && c>=0 && c<N) {
        return true;
    }else  return false;
}
}