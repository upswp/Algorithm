package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int start = 0;
		int end = V - 1;
		final int INFINITY = Integer.MAX_VALUE;

		int[][] matrix = new int[V][V]; // 인접행렬
		int[] distance = new int[V]; // 출발지에서 자신까지 오는 최단거리
		boolean[] visited = new boolean[V];// 처리한 정점 여부 관리
		// dlqfu
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < V; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.fill(distance, INFINITY); // 자신이 가지 못하는 곳을 무한으로 처리하기 위해 전부를 일단 무한으로 채움.
		distance[start] = 0; // 자신이 자신을 경유지로 하는 경우를 0으로 처리.

		int min = 0, current = 0;

		// 1단계 : 방문하지 않은 정점들 중 출발지에서 자신까지 오는 비용이 최단인 정점을 고려할 경유지로 선택.
		/*
		 * 최단거리를 선택하는 부분. 이 부분에서 시간복잡도 logv 로 시간복잡도를 줄인다면 더욱 빠르게 진행할 수 있음. --> 우선순위 큐 사용.
		 */
		for (int i = 0; i < V; i++) {

			min = INFINITY;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j]; // 최소 거리를 나타내는 경유지를 min에 넣음
					current = j; // 현재 고려해야하는 정점을 current에 저장.
				}

			}
			visited[current] = true;

			if (current == end) break;
			

			// 2단계 : 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단 거리 비용 계산하여 유리하면 update
			for (int j = 0; j < V; j++) {
				// distance[current] : min값
				if (!visited[j] && matrix[current][j] != 0 && distance[j] > distance[current] + matrix[current][j]) {
					distance[j] = min + matrix[current][j];
				}
			}

		}
		System.out.println(distance[end]);

	}

}
