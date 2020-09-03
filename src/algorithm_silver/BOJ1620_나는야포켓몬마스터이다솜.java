package algorithm_silver;

import java.util.HashMap;
import java.util.Scanner;
/**
 * SSAFY BOJ 1620
 * @author Park Sangwoo
 * @since 2020-09-03
 * @use Hashmap
 */
public class BOJ1620_나는야포켓몬마스터이다솜 {
	static int N, M;
	static HashMap<String, Integer> number = new HashMap<String, Integer>();
	static HashMap<Integer, String> pockemon = new HashMap<Integer, String>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String monster = sc.next();
			pockemon.put(i+1, monster);
			number.put(monster, i+1);
		}
		for (int i = 0; i < M; i++) {
			if (sc.hasNextInt()) {
				System.out.println(pockemon.get(sc.nextInt()));
			}else {
				System.out.println(number.get(sc.next()));
			}
		}
	}
}
