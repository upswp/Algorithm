package algorithm.permutation.basic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Park Sangwoo
 *
 */

public class P2_PermutationInputTest {

	// 1,2,3
	// 3P2 = 3!/1!= 6
	// 1,2,3
	// 3P3 = 3!
	static int N,R;
	static int[] input,numbers;
	static boolean[] isSelected;
	static int totalCount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0);
		System.out.println("총 경우의 수 : "+totalCount);
	}

	// cnt 인덱스 위치의 순열 추출하기 
	private static void permutation(int cnt) {
		if(cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=0; i<N; ++i) {
			if(isSelected[i]) continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
