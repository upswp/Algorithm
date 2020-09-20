package algorithm.union_find;

public class UnionTest {
	
	static int [] parents;
	static int [] rank;
	static int N =5;
	
	public static void main(String[] args) {
		int count=0;
		parents = new int [N+1];
		rank = new int[N+1];
		
		//Make Set
		for (int i = 1; i < N+1; i++) {
			parents[i] = i;
		}
		union(1,2);
		union(2,3);
		union(4,5);
		// 1 1 1 4 4 
		for (int i = 1; i < N+1; i++) {
			if (parents[i]==i) {
				
				count++;
			}
		}
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) {return;}
		
		if(rank[x]<rank[y]) {
			parents[x]=y;
		}
		else {
			parents[y] = x;
			if (rank[x]==rank[y]) {
				rank[x]++;
			}
		}
	}

	private static int find(int x) {
		if(x==parents[x])return x;
		else parents[x] = find(parents[x]);
		return 0;
	}
}
