package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759_암호만들기 {

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

		nCr(0, 0);
	}

	private static void nCr(int cnt, int start) {
		if (cnt == L) {
			Arrays.sort(ans);
			if (check(ans)) {
				System.out.println(Arrays.toString(ans));
			}
			return;
		}
		for (int i = start; i < C; i++) {
			ans[cnt] = input[i];
			nCr(cnt + 1, i + 1);
		}
	}

	public static boolean check(String[] ans) {
		int vowel=0; 						//모음
		int consonant=0;					//자음 
		for (int i = 0; i < ans.length; i++) {
			if ((ans[i].contains("a")) || (ans[i].contains("e")) 
			|| (ans[i].contains("o"))  || (ans[i].contains("i"))
			|| (ans[i].contains("e"))) 
			{
				vowel++;
			}else consonant ++;
		}
		if (vowel>=1 && consonant>=2) {
			return true;
		}else return false;
	}
}
