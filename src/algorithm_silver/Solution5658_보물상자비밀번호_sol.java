package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution5658_보물상자비밀번호_sol {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int C = N/4; // 한변의 길이 --> 회전횟수 결정
			int K = Integer.parseInt(st.nextToken());
			char [] nums = br.readLine().toCharArray();
			
			TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o2.compareTo(o1); // TreeSet을 내림차순으로 나올 수 있게 조정. 정수일때 o2-o1
				}
			});
			
			int c = 0;
			while(c++<C) { // 회전관련 처리 C번
				// 현상태에서 각 변의 길이만큼의 문자열 비밀번호를 추출하여 set에 넣기
				for (int i = 0; i < N; i+=C) {
					String s = "";
					for (int j = 0; j < C; j++) {
						s += nums[i+j];// 계산한 C만큼  기준점 기준으로 C개 char를 String으로 변형. 
					}
					set.add(s);
				}
				// 시계방향으로 하나 shift 
				char tmp = nums[N-1];
				for (int i = N-1; i > 0; i--) {
					nums[i] = nums[i-1];
				}
				nums[0] = tmp;
			}
			int k = 0, ans = 0;
			for (String s : set) {
				if(++k==K) {
					ans = Integer.parseInt(s, 16); // 16진수를 10진수로 바꾸기
					break;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
