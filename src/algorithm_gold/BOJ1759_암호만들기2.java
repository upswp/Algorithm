package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759_암호만들기2 {

	static int L, C;
	static String input[], ans[];
	static String consonant[] = { "a", "e", "i", "o", "u" };
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new String[C];
		ans = new String[L];
		visit = new boolean[C];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken();
		}
		
		Arrays.sort(input);
		solution(L,input,"",0);
	}

	private static void solution(int N, String[] input, String password, int index) {
		if (password.length() == N) {
			if (check(password)) {
				System.out.println(password);
			}
			return;
		}
		if (input.length<=index) {
			return;
		}
		solution(N, input, password+input[index], index+1);
		solution(N, input, password, index+1);
	}

	private static boolean check(String password) {
		int consonant = 0;
		int vowel = 0;
		for (char x : password.toCharArray()) {
			if (x=='a'||x=='o'||x=='u'||x=='i'||x=='e') {
				vowel++;
			}else consonant++;
		}
//		return vowel>=1 && consonant>=2;
		if (vowel>=1 && consonant>=2) {
			return true;
		}else return false;
	}
}
