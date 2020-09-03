//하나로_프림(NO PQ)
package algorithm_silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * SSAFY SWEA 1251 하나로
 * @author Park Sangwoo
 * @since 2020-09-03
 * @use prim
 */
public class Solution1251_하나로2 {
    static int N;
    static long[][] adjMatrix;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            int[] x = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            } // N개 섬의 x좌표
            int[] y = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            } // N개 섬의 y좌표
            adjMatrix = new long[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    adjMatrix[i][j] = adjMatrix[j][i] = getDist(x[i], x[j], y[i], y[j]);
                }
            } // 인접행렬 완성
            double E = Double.parseDouble(br.readLine()); // 나중에 곱해줄 환경세율
            System.out.println("#" + tc + " " + Math.round(E * maskMST()));
        }
    }
    // 프림 알고리즘
    private static long maskMST() {
        long[] minEdge = new long[N];
        boolean[] visited = new boolean[N];
        long result = 0; // 최소 신장트리비용
        int cnt = 0; // 처리한 정점수
        Arrays.fill(minEdge, Long.MAX_VALUE);
        minEdge[0] = 0; // 0을 시작점으로
        while (true) {
            // 1단계 : 신장 트리에 포함되지 않은 정점 중 최소 간선비용의 정점 선택
            long min = Long.MAX_VALUE;
            int minNo = 0; // 최소 간선 비용의 정점
            for (int i = 0; i < N; i++) {
                //방문하지 않은 정점 중에 최소 비용가지고 있는 정점을 선택
                if (!visited[i] && min > minEdge[i]) {
                    min = minEdge[i];
                    minNo = i;
                }
            }
            visited[minNo] = true; // 정점 방문 처리(신장트리에 포함)
            result += min; // 간선비용 누적
            if (++cnt == N)
                break;
            // 2단계 : 선택된 정점에서 신장트리에 포함되지 않은 다른 정점들로의 간선의 비용을 고려해서 minEdge 업데이트
            for (int i = 0; i < N; i++) {
                //선택하지 않은 정점이면서 인접한 정점 중에 간선비용 고려하여 작은 것으로 업데이트 
                if (!visited[i] && adjMatrix[minNo][i] > 0 && minEdge[i] > adjMatrix[minNo][i]) {
                    minEdge[i] = adjMatrix[minNo][i];
                }
            }
        }
        return result;
    }
    // 거리
    private static long getDist(int x1, int x2, int y1, int y2) {
        return (long) (Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
}