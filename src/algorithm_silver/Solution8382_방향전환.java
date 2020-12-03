package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8382_방향전환 {

	static int T, x1,y1,x2,y2,min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			
			Move(true);
			Move(false);
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	static void Move(boolean flag) {
		int cnt = 0;
		int dx = x1, dy = y1;
		while(true) {
			if (dx==x2 && dy==y2) {
				if (min>cnt) min = cnt; 
				break;
			}
			if (flag) {
				if (dx>x2)dx--;
				else dx++;
				flag = false;
			}else {
				if (dy>y2)dy--;
				else dy++;
				flag = true;
			}
			cnt++;
		}
	}
}
