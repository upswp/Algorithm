package IM대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 14696 딱지놀이
 * @author Park Sangwoo
 * @since 2020-09-17
 */
public class BOJ14696_딱지놀이 {
	static int N;
	static int aSum, bSum, a[], b[];
	static int cnt1a, cnt2a, cnt3a, cnt4a;
	static int cnt1b, cnt2b, cnt3b, cnt4b;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		a:for (int t = 0; t < N; t++) {					//testcase만큼 반복
			int cnt1a=0, cnt2a=0, cnt3a=0, cnt4a =0;	//초기화
			int cnt1b=0, cnt2b=0, cnt3b=0, cnt4b =0;
														
			st = new StringTokenizer(br.readLine());	//a입력 시작
			aSum = Integer.parseInt(st.nextToken());
			a = new int[aSum];
			for (int i = 0; i < aSum; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}											//a입력 끝
			st = new StringTokenizer(br.readLine());	//b입력 시작
			bSum = Integer.parseInt(st.nextToken());
			b = new int[bSum];
			for (int i = 0; i < bSum; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}											//b입력 끝
			
			for (int i = 0; i < aSum; i++) {			//a,b 각각 구성값들에 대해서 cnt 실시.
				switch (a[i]) {
				case 1:
					cnt1a++;
					break;
				case 2:
					cnt2a++;
					break;
				case 3:
					cnt3a++;
					break;
				case 4:
					cnt4a++;
					break;
				}
			}
			for (int i = 0; i < bSum; i++) {
				switch (b[i]) {
				case 1:
					cnt1b++;
					break;
				case 2:
					cnt2b++;
					break;
				case 3:
					cnt3b++;
					break;
				case 4:
					cnt4b++;
					break;
				}
			}
			if (cnt4b > cnt4a) {						// 우선순위가 높은 4부터 1까지 비교 
				System.out.println("B");
				continue a;
			} else if (cnt4b < cnt4a) {
				System.out.println("A");
				continue a;
			} else {
				if (cnt3b > cnt3a) {
					System.out.println("B");
					continue a;
				} else if (cnt3b < cnt3a) {
					System.out.println("A");
					continue a;
				} else {
					if (cnt2b > cnt2a) {
						System.out.println("B");
						continue a;
					} else if (cnt2b < cnt2a) {
						System.out.println("A");
						continue a;
					} else {
						if (cnt1b > cnt1a) {
							System.out.println("B");
							continue a;
						} else if (cnt1b < cnt1a) {
							System.out.println("A");
							continue a;
						} else {						// 둘 값이 동일할경우 D출력
							System.out.println("D");
							continue a;
						}
					}
				}
			}
		}
	}
}