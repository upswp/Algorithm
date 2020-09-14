package algorithm_bronze;
import java.util.Scanner;

public class BOJ2839_설탕배달2 {
	static int T, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();//testcase입력
		int five = 5;	//5kg
		int three = 3;	//3kg
		int divide5 = 0;//M을 5으로 나눈 몫
		int divide3 = 0;//M을 3으로 나눈 몫
		int rest5 = 0;	//M을 5로 나눈 나머지
		int rest3 = 0;	//M을 3으로 나눈 나머지
		int res = 0;	//3이나 5로 바로 나누어 떨어지지 않을 경우의 계산 값
		int res3 = 0;	//3으로 바로 나누어 떨어지는 경우의 계산값
		int res5 = 0;	//5로 바로 나누어 떨어지는 경우의 계산값

		for (int t = 0; t < T; t++) {//
			M = sc.nextInt();						//목표 테스트 값
			if (M % five == 0) {					//목표값이 5로 다 나누어질 경우
				res5 = M / five;					//res5에 저장
			} else if (M % three == 0) {			//목표값이 3으로 다 나누어질 경우
				res3 = M / three;					//res3에 저장
			}
			if (M % five != 0 || M % three != 0) {	//목표값이 5나 3으로 나누어 떨어지지 않을 경우
				divide5 = M / five;					//divide5에 5로나눈 몫을 저장
				rest5 = M % five;					//res5에 5로 나눈 나머지를 저장
				divide3 = rest5 / three;			//5로 나눈 나머지 값을 3으로 나눈 몫
				rest3 = rest5 % three;				//5로 나눈 나머지 값을 3으로 나눈 나머지
				if (rest3 == 0) {					//5로 나눈 나머지 값을 3으로 나눈 나머지 값이 0일경우 
					res = divide5 + divide3;		//res에 divide5와 divide3를 저장
				} else {							//아닐경우
					res = -1;						//목표값에 도달할 수 없다 판단하여 -1 res에 저장.
				}
			}
			if (res > 0 && M % five == 0 && res > res5) {			//res가 -1이 안나오고 5로 나누어 떨어지고 res5 가 더 작을 경우 
				System.out.println(res5);							
			} else if (res > 0 && M % three == 0 && res > res3) {	//res가 -1이 안나오고 3으로 나누어 떨어질경우 res3가 더 작을경우
				System.out.println(res3);
			} else if (res > 0 && M % five == 0 && res < res5) {	//res가 -1이 안나오고 5로 나누어 떨어지고 res가 더 작을 경우 
				System.out.println(res);
			} else if (res > 0 && M % three == 0 && res < res3) {	//res가 -1이 안나오고 3으로 나누어 떨어질경우 res가 더 작을경우
				System.out.println(res);
			} else if (res < 0 && M % three == 0 && res3 > 0) {		//res가 -1이 나오고 3으로 나누어 떨어질 경우
				System.out.println(res3);							
			} else if (res < 0 && M % five == 0 && res5 > 0) {		//res가  -1이 나오고 5로 나누어 떨어질 경우
				System.out.println(res5);							
			} else {												//나머지는 전부 -1
				System.out.println(res);							
			}
		}
	}
}
