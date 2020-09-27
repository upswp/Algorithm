package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * BOJ 9375 패션왕 신혜빈
 * @author Park Sangwoo
 * @since 2020-09-27
 */
public class BOJ9375_패션왕신혜빈 {

	static int T ,N;
	static HashMap<String, Integer> cloth;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			cloth = new HashMap<String, Integer>();
			int ans = 0;
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st=new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String kind = st.nextToken();
				
				// headgear*2 	eyewear*1
				// head1 , head2, head1+eye, head2+eye, eye
				// head 0 , head1 , head 2
				// eye 0 , eye 1
				// 3*2 = 6
				// 아무것도 안입는 경우는 없으므로 -1
				// 5
				
				if (cloth.containsKey(kind)) {
					cloth.put(kind, cloth.get(kind)+1);
				}else {
					cloth.put(kind, 1);
				}
			}
			ans = 1;
//			for (int i = 0; i < cloth.size(); i++) {
//				ans *= cloth.get(i)+1;
//			}
			for (int num : cloth.values()) {
				ans *= num+1;
			}
			
			System.out.println(ans-1);
		}
	}
}
