package algorithm_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1868_파핑파핑지뢰찾기 {

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }
    
    static int T, N, cnt;
    static char map[][];
    static boolean visited[][];
    static int min = Integer.MAX_VALUE;

    static int dr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int dc[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = input[j];
                }
            }
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j] && zeroCheck(i, j)) {
                        ++cnt;
                        bfs(i, j); // 좌표, 좌표, count
                    }
                }
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == '.' && !visited[i][j]) {
                        ++cnt;
                    }
                }
            }
            
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static boolean zeroCheck(int r, int c) {
        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (!check(nr, nc))
                continue;
            if (map[nr][nc] == '*') {
                return false;
            }
        }
        return true;
    }

    static boolean check(int r, int c) {
        if (r >= 0 && r < N && c >= 0 && c < N) {
            return true;
        }
        return false;
    }

    static void bfs(int r, int c) {
        Queue<Point> que = new LinkedList<>();
        visited[r][c] = true;
        que.add(new Point(r,c));
        while (!que.isEmpty()) {
            Point now = que.poll();
            if (zeroCheck(now.r, now.c)) {                /*체크를 하며 나눠주면서 확실히 주변에 지뢰가 없는지 체크*/
                int cr = now.r;
                int cc = now.c;
                
                for (int d = 0; d < 8; d++) {
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];
                    if (!check(nr, nc))continue;
                    if (!visited[nr][nc] && map[nr][nc] =='.') {
                        visited[nr][nc] = true;
                        que.add(new Point(nr,nc));
                    }
                }
            }else {                                        /*주변에 지뢰가 하나라도 있을때는 visit처리하고 넘어가기*/
                visited[now.r][now.c] = true;
            }
        }
    }
}