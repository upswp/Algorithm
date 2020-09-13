package algorithm.subset.basic;

/**
 * 부분집합의 합 구하기
 * 
 */
import java.util.Scanner;

public class S2_SubSetSumTest {
	// S = 합
	static int N, S, totalCnt;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		generateSubset(0);
		System.out.println("총 경우의 수 : " + totalCnt);

	}

	private static void generateSubset(int cnt) {
		if (cnt == N) {
			// 부분집합의 구성요소의 합

			int sum = 0;
			for (int i = 0; i < N; i++) {
				// isSelected[i]가 true 이면
				if (isSelected[i]) {
					sum += input[i];
				}
			}

			if (sum == S) {
				++totalCnt;
				for (int i = 0; i < N; i++) {
					// 삼항연산자
					// isSelected 가 true 면 input을 출력
					// false면 'X' 출력
					System.out.print(isSelected[i] ? input[i] : "X");
					System.out.print("\t");
				}
				System.out.println();

			}

			return;
		}

		// 부분집합 구성에 포함
		isSelected[cnt] = true;
		generateSubset(cnt + 1); // 부분집합에 포함되는 다음 구성원으로 넘어감

		// 부분집합 구성에 비포함
		isSelected[cnt] = false;
		generateSubset(cnt + 1); // 비포함일 경우도 동일하게 다음 원소로 넘어감 플랫하게 생각해서 될때하고 그 다음원소로 넘어가고 단순하게 생각쓰!
	}

}
