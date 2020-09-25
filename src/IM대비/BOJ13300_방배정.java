package IM대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Samsung SW역량 테스트 IM대비 BOJ 13300 방배정
 * 
 * @author Park Sangwoo
 * @since 2020-09-24
 */
public class BOJ13300_방배정 {
	static int Mgrade[], Wgrade[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Mgrade = new int[7];
		Wgrade = new int[7];
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			switch (gender) {
			case 0:
				for (int j = 1; j <= 6; j++) {
					if (grade == j) {
						Wgrade[j] += 1;
					}
				}
				break;
			case 1:
				for (int j = 1; j <= 6; j++) {
					if (grade == j) {
						Mgrade[j] += 1;
					}
				}
				break;
			}
		}
		int count = 0;
		for (int i = 1; i <= 6; i++) {
			if (Mgrade[i]!=0) {
				if (Mgrade[i] > K) {
					if (Mgrade[i]%K == 0) {
						count = count + Mgrade[i]/K;
					}else {
						count = count + Mgrade[i]/K+1;
					}
				}else {
					count++;
				}
			}
			if(Wgrade[i]!=0){
				if (Wgrade[i] > K) {
					if (Wgrade[i]%K == 0) {
						count = count + Wgrade[i]/K;
					}else {
						count = count + Wgrade[i]/K+1;
					}
				}else{
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
