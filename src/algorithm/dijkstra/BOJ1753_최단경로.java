package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1753_최단경로 {

	static class Edge{
		int v;
		int w;
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		public Edge() {}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // vertex
		int E = Integer.parseInt(st.nextToken()); // edge
		int K = Integer.parseInt(br.readLine());
		//해당 정점에서 연결된 다른 정점들을 저장할라고 List
		//인접 리스트
		List<Edge> [] adj = new ArrayList[V];
		for (int i = 0; i < adj.length; i++) {
			adj [i] = new ArrayList<>(); //초기화
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u-1].add(new Edge(v-1,w)); //배열이라 -1
		}
		int [] D = new int[V]; // distance min(D[V],D[w]+A[w][v])
		Arrays.fill(D,Integer.MAX_VALUE);
		boolean[] check = new boolean[V];
		D[K-1] = 0; // start
		/*
		 * 비교해야해서 V-1돌고 V까지 도는 형식.
		 */
		for (int i = 0; i < V-1; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int j = 0; j < V; j++) {
				if (!check[j] && (min>D[j])) {
					min=D[j];
					index = j;
				}
			}
			if (index == -1) {
				break;
			}
			for (Edge next : adj[index]) {
				if (!check[next.v] && (D[next.v])>D[index]+next.w) {
					D[next.v] = D[index]+next.w;
					
				}
			}
			check[index] = true;
		}
		for (int i = 0; i < V; i++) {
			if(D[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(D[i]);
			}
		}
		
		
	}

}
