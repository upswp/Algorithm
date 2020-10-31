package algorithm.permutation.nextpermu;

import java.util.Arrays;

public class PrevPermu {

	static int[] p = {5,4,3,2,1};

	public static void main(String[] args) {
		do {
			System.out.println(Arrays.toString(p));
		} while (np(p.length - 1));
	}

	static boolean np(int size) {
		int i = size;
		
		while(i > 0 && p[i-1] <= p[i]) i--;
		if(i == 0) return false;
		int j = size;
		while(i<=j && p[i-1] <= p[j]) j--;
		
		int tmp = p[i-1];
		p[i-1] = p[j];
		p[j] = tmp;
		
		int k = size;
		while(i < k) {
			tmp = p[i];
			p[i] = p[k];
			p[k] = tmp;
			i++;
			k--;
		}
		
		return true;
	}
}
