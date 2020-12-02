package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution5658_보물상자비밀번호_sol2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int C = N/4; // 한변의 길이 --> 회전횟수 결정
			int K = Integer.parseInt(st.nextToken());
			String nums = br.readLine();
			nums = nums.concat(nums); //자기자신을 연달아 붙이기 ,, Shift처리하지 않기 위해
			
			TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o2.compareTo(o1); // TreeSet을 내림차순으로 나올 수 있게 조정. 정수일때 o2-o1
				}
			});
			
			int c = 0, begin = 0;
			while(c++<C) { // 회전관련 처리 C번
				for (int i = begin , j = 0; j < 4; i+=C,++j) {
					set.add(nums.substring(i,i+C));
				}
				++begin;
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
