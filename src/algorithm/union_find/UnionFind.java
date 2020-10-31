package algorithm.union_find;

import java.util.Arrays;

public class UnionFind {

	private static int [] parent;
	private static int [] rank;
	private static int N;
	
	public static void main(String[] args) {
		
		N = 6;
		parent = new int [N];
		rank = new int [N];
		
		/*초기화*/
		for (int i = 0; i < N; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		union(3,4);
		union(2,5);
		union(3,2);
		union(0,1);
		
		System.out.println(find(5));
		System.out.println(find(3));
		System.out.println(Arrays.toString(parent));
	}
	
	public static int find (int x) {
		if(x==parent[x]) {
			return parent[x];
		}else {
			return parent[x] = find(parent[x]);
		}
	}
	
	public static boolean isConnected(int x, int y) {
		return find(x)==find(y);
	}
	
	public static void union(int x, int y) {
		int xp = find(x);
		int yp = find(y);
		
		if (xp == yp) return;
		if (rank[xp] < rank[yp]) {
			rank[yp] += rank[xp];
			parent[xp] = yp;
		}else {
			rank[xp] += rank[yp];
			parent[yp] = xp;
		}
	}

}
