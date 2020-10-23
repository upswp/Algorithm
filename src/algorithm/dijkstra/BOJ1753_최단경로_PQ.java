package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


class Edge {
    int end;
    int value;

    Edge(int end, int value) {
        this.end = end;
        this.value = value;
    }
}
public class BOJ1753_최단경로_PQ {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int vertex = Integer.parseInt(str[0]);
        int edge = Integer.parseInt(str[1]);

        int K = Integer.parseInt(br.readLine());

        int[] distance = new int[vertex + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
//       distance array에 integer의 가장 큰 수로 초기화

        boolean[] visited = new boolean[vertex + 1];
//        방문했는지 아닌지 확인하는 visited

        ArrayList<Edge>[] list = new ArrayList[vertex + 1];
        for (int i = 0; i <= vertex; i++) {
            list[i] = new ArrayList<Edge>();
        }
        //        행렬 만들기

        for (int i = 0; i < edge; i++) {
//            값 집어넣기
            str = br.readLine().split(" ");
            int start = Integer.parseInt(str[0]) ;
            int end = Integer.parseInt(str[1]);
            int value = Integer.parseInt(str[2]);
            list[start].add( new Edge(end, value));
        }

        // 우선순위 큐를 사용해야 한다. 성능이 더 좋아짐
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        // 시작점 설정해주고 시작점 - 시작점 거리는 0이다.
        q.add(K);
        distance[K] = 0;
        while (!q.isEmpty()) {
            // 다음에 방문할 vertex 설정
            int current = q.poll();
            // 방문했기 떄문에 true, INF는 아니다.
            visited[current] = true;


            for (int i = 0; i < list[current].size(); i++) {

                // 현재 vertex에서 다음 vertex를 차근차근 비교해서 우선순위 큐에 넣어야한다.
                int next = list[current].get(i).end; // 다음 vertex
                int value = list[current].get(i).value; // 현재 - 다음 간 edge값

                if (distance[next] > distance[current] + value) {
                    //한번도 안간 곳이면 무조건 distance[next]가 크다. Integer.MAX_VALUE해놨으니까
                    distance[next] =  value + distance[current];
                    q.add(next);
                }
            }
        }
        // 출력
        for (int i = 1; i <= vertex; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

}