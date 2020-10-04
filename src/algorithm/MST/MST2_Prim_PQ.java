package algorithm.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
// 프림 알고리즘 이용 : PriorityQueue 버전
/*
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0
==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0
==>175
 */
/**
 * 
 * @author taeheekim
 *
 */
public class MST2_Prim_PQ{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine().trim());
        int[][] input = new int[cnt][cnt];
        boolean[] visited = new boolean[cnt];
        int[] minEdge = new int[cnt];
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        
        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cnt; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }// i노드에서 j노드까지의 비용을 모두 배열에 저장
        
        int result = 0, nodeCount= 0;
        minEdge[0] = 0;
        queue.offer(new Node(0,0));
        
		while(!queue.isEmpty()){

			Node minVertex = queue.poll();			
			if(visited[minVertex.no]) continue;
			
            result += minVertex.edge; 
            visited[minVertex.no] = true; 
            if(++nodeCount == cnt) break; 
            
            for (int j = 0; j < cnt; j++) { 
                if (!visited[j] && input[minVertex.no][j] != 0 &&  input[minVertex.no][j] < minEdge[j] ) {
                	minEdge[j] = input[minVertex.no][j];
                	queue.offer(new Node(j, input[minVertex.no][j])); 
                }
            }
        }
        System.out.println(result);
    }
    static class Node implements Comparable<Node>{
    	int no; 
    	int edge;
		public Node(int no, int edge) {
			super();
			this.no = no;
			this.edge = edge;
		}
		@Override
		public int compareTo(Node o) {
			return this.edge - o.edge;
		}
    }
}// end class
