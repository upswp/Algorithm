package algorithm.combination.nextcombi;

import java.util.Arrays;

public class NextCombi {

	static int[] p = { 1, 0,1,0, 1 };
	static int[] a = { 1, 2, 3, 4, 5 };

	public static void main(String[] args) {

		do {

			for (int i = 0; i < a.length; i++) {
				if (p[i] == 1) {
					System.out.print(a[i] + " ");
				}
			}
			
			System.out.println();
		} while (nc(p.length - 1));
	}

	static boolean nc(int size) {
		int i = size;

		while (i > 0 && p[i - 1] >= p[i])
			i--;
		if (i == 0)
			return false;
		int j = size;
		while (p[i - 1] >= p[j])
			j--;

		int tmp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = tmp;

		int k = size;
		while (i < k) {
			tmp = p[i];
			p[i] = p[k];
			p[k] = tmp;
			i++;
			k--;
		}

		return true;
	}

}
