package algorithm.BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Doduge_BFS {

    static int N;
    static int[][] map;
    static int[][] b;

    public static void main(String[] args) {

        Scanner scann=new Scanner(System.in);
        N=scann.nextInt();
        map=new int[N][N];
        b=new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j]=scann.nextInt();
            }
        }
        int cnt=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N; j++) {
                if(map[i][j]==1 && b[i][j]==0) {
                    cnt++;
                    bfs(i,j,cnt+1);
                }
            }
        }
        System.out.println(cnt);// 두더지굴 개수
        for (int i = 2; i <= cnt+1; i++) {// 2, 3, 4
            int count=0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(b[j][k]==i) {  //2,3,4 굴
                        count++;      //의 개수
                    }
                }
            }
            System.out.println(count);
        }
         
        
    }
    static int[] dr= {0,0,1,-1};
    static int[] dc= {1,-1,0,0};//우좌상하
    private static void bfs(int r, int c, int k) {
        Queue<int[]> que=new LinkedList<>();
        que.offer(new int[] {r,c});
        b[r][c]=k;
        while(!que.isEmpty()) {
            int[] curr=que.poll();
            int cr=curr[0];
            int cc=curr[1];
            for (int d = 0; d < 4; d++) {
                int nr=cr+dr[d];
                int nc=cc+dc[d];
                if(!check(nr,nc)) {continue;}
                if(map[nr][nc]==1 && b[nr][nc]==0) {
                    b[nr][nc]=k;
                    que.offer(new int[] {nr,nc});
                }
            }
        }

    }
    private static boolean check(int r, int c) {
        if(r>=0 && r<N && c>=0 && c<N) {
            return true;
        }else return false;
    }



}