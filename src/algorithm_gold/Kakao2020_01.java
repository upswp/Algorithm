package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Kakao 2020 코딩테스트 
 * 1번 문제
 * @author Park Sangwoo
 * @since 2020-09-12
 */
//...!@BaT#*..y.abcdefghijklm
public class Kakao2020_01 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String new_id = br.readLine();
		solution(new_id);
	}

	public static String solution(String new_id) {
		String step01 = "";
		String input = new_id;
		
		for (int i = 0; i < input.length(); i++) {
			char tmp = input.charAt(i);
			if ((65 <= tmp) && (tmp <= 90)) {
				step01 += input.valueOf(tmp).toLowerCase();
			} else {
				step01 += (char) tmp;
			}
		}
//		System.out.println("01" + step01);
		String step02 = "";
		for (int i = 0; i < step01.length(); i++) {
			char tmp = step01.charAt(i);
			if (tmp == '-' || tmp == '_' || tmp == '.' || (97 <= tmp) && (tmp <= 122) || (48 <= tmp) && (tmp <= 57)) {
				step02 += (char) tmp;
			}
		}
//		System.out.println("02" + step02);
		String step03 = "";
		for (int i = 0; i < step02.length(); i++) {
			if (!(step02.charAt(i) == '.' && step02.charAt(i + 1) == '.')) {
				step03 += step02.charAt(i);
			}
		}
//		System.out.println("03" + step03);
		String step04 = "";
		for (int i = 0; i < step03.length(); i++) {
			if (step02.charAt(0) == '.' && step02.charAt(step03.length()-1) == '.') {
				step04 += step03.substring(1, step03.length() - 1);
				break;
			} else if (step02.charAt(0) == '.') {
				step04 += step03.substring(1, step03.length()-1);
				break;
			} else if (step02.charAt(step03.length()-1) == '.') {
				step04 += step03.substring(0, step03.length() - 1);
				break;
			} else {
				step04 += step03.charAt(i);
				break;
			}
		}
//		System.out.println("04" + step04);
		String step05 = "";
		if (step04 == null || step04.equals("")) {
			for (int j = 0; j < 15; j++) {
				step05 += "a";
			}
		} else {
			for (int i = 0; i < step04.length(); i++) {
				step05 += step04.charAt(i);
			}	
		}
//		System.out.println("05" + step05);

		String step06 = "";
		if (step05.length() >= 16) {
			for (int j = 0; j < 15; j++) {
				step06 += step05.charAt(j);
			}
			if (step06.charAt(step06.length()-1) == '.') {
				step06 += step06.substring(0, step06.length() - 1);
			}
		}
//		System.out.println("06" + step06);

		String step07 = "";
		for (int i = 0; i < step06.length(); i++) {
			if (step06.length() <= 2) {
				step07 += step06.charAt(i);
				step07 += step06.charAt(step06.length());
			} else {
				step07 += step06.charAt(i);
			}
		}
//		System.out.println("07" + step07);

		String answer = step07;
		return answer;
	}

}
