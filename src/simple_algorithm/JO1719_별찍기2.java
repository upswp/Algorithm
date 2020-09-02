package simple_algorithm;

import java.util.Scanner;

/**
 * SSAFY JO 1719 별찍기 2
 * 
 * @since 2020-08-19
 * @author Park Sangwoo
 *
 */
public class JO1719_별찍기2 {
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if (N%2==0) {
			System.out.println("INPUT ERROR!");
		}
		M = sc.nextInt();
		switch (M) {
		case 1:
			for (int i = 0; i < N/2; i++) {
				for (int j =0; j < i+1; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = 0; i <= N/2; i++) {
				for (int j = N/2+1; i <j; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = 0; i < N/2; i++) {
				for (int k = (N-1)/2; k > i; k--) {
					System.out.print(" ");
				}
				for (int j = 0; j <=i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = 0; i < N/2+1; i++) {
				for (int k = 0; k < i; k++) {
					System.out.print(" ");
				}
				for (int j = (N/2)+1; j > i ; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 0; i < N; i++) {
				if (i <= N/2) {
					for (int j = 1; j <= i; j++) {
						System.out.printf(" ");
					}
					for (int k = N; k > 2 * i; k--) {
						System.out.printf("*");
					}
					System.out.println();
				}
				if (i > N/2) {
					for (int j = N - i - 1; j > 0; j--) {
						System.out.printf(" ");
					}
					for (int k = N - 1; k < 2 * i + 1; k++) {
						System.out.printf("*");
					}
					System.out.println();
				}
			}
			break;
		case 4:
			for (int i = 0; i < N; i++) {
				if (i <= N/2) {
					for (int j = 1; j <= i; j++) {
						System.out.printf(" ");
					}
					for (int k = N/2 + 1; k > i; k--) {
						System.out.printf("*");
					}
					System.out.println();
				}

				if (i > N/2) {
					for (int j = 1; j <= N/2; j++) {
						System.out.printf(" ");
					}
					for (int k = N/2 - 1; k < i; k++) {
						System.out.printf("*");
					}
					System.out.println();

				}
			}
			break;
		default:
			System.out.println("INPUT ERROR!");
			break;

		}

	}
}
