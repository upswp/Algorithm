package algorithm_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 10250 ACM 호텔
 * @author Park Sangwoo
 * @since 2020-10-05
 */
public class BOJ10250_ACM호텔 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int x = (N/H) + 1;
            int y = N%H;
            if(N%H==0) {
                x = N/H;
                y = H;
            }
            System.out.println(y*100+x);
		}
	}

}
