package algorithm_silver;

/**
 * SSAFY BOJ 2527
 * @author Park Sangwoo
 * @since 2020-09-09
 */
import java.util.Scanner;

public class BOJ2527_직사각형 {

	static int x1, y1, x2, y2, a1, b1, a2, b2;
	static char answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			a1 = sc.nextInt();
			b1 = sc.nextInt();
			a2 = sc.nextInt();
			b2 = sc.nextInt();
			
			/* 각 꼭지점이 같을 경우 */
			if ((x2 == a1 && y2 == b1) || (x1 == a2 && y2 == b1) || (x2 == a1 && y1 == b2)
					|| (x1 == a2 && y1 == b2)) {
				answer = 'c';
			/* x축만 같거나 y축만 같은 경우 선이 쳐지므로  */
			} else if ((x2 == a1 && y2 != b1) || (x1 == a2 && y2 != b1) || (x2 != a1 && y1 == b2)
					|| (x1 != a2 && y1 == b2)) {
				answer = 'b';
			/* 가로기준으로 세로기준으로 각각 크기를 비교하여 기준값보다 큰 경우 안겹침. */
			} else if (x2 < a1 || a2 < x1 || y2 < b1 || b2 < y1) {
				answer = 'd';
			/* 경우의 수가 가장 많으므로 c, b, d가 아닌경우 전부 a */
			} else {
				answer = 'a';
			}
			System.out.println(answer);
		}
	}

}
