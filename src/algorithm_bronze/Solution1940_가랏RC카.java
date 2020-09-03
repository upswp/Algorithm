package algorithm_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1940_가랏RC카 {

	static int T, N;
	static int second, speed, distance;
	static int[][] control;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			control = new int [N][2];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < 2; j++) {
					control[i][0] = Integer.parseInt(st.nextToken());
					control[i][1] = Integer.parseInt(st.nextToken());
					controlRC(control[i][0], control[i][1]);
				}
				System.out.println("#"+t+" "+distance);
			}
		}
	}

	private static void controlRC(int Con, int miniCon) {
		switch (Con) {
		case 1:
			speed += miniCon;
			distance += speed;
			break;
		case 2:
			speed -= miniCon;
			if (speed<0) speed = 0;
			distance += speed;
			break;
		case 0:
			distance += speed;
			break;
		}
	}

}
