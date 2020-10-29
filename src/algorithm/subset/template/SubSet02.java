package algorithm.subset.template;

public class SubSet02 {

	static int[] A = { 1, 2, 3, 4, 5 };
	static int N, R, count;
	static boolean[] v;

	public static void main(String[] args) {
		count = 0;
		N = A.length;
		R = 3;
		v = new boolean[N];
		subset();
	}

	/**
	 * subset
	 * 
	 * @param cnt  횟수
	 * @param sum  합
	 * @param list 담을 list
	 */
	static void subset() {
		for (int i = 0; i < (1 << N); i++) {
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					System.out.print(A[j] + " ");
				}
			}
			System.out.println();
		}
	}
}
