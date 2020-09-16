package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * BOJ 9536 여우는 어떻게 울지?
 * 
 * @author Park Sangwoo
 * @since 2020-09-15
 */
public class BOJ9536_여우는어떻게울지 {
	static class ainiGoes {
		String name;
		String goes;

		public ainiGoes(String name, String goes) {
			super();
			this.name = name;
			this.goes = goes;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGoes() {
			return goes;
		}

		public void setGoes(String goes) {
			this.goes = goes;
		}
	}

	static int T;
	static ainiGoes animal;
	static ArrayList<ainiGoes> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String goes[] = br.readLine().split(" ");

			while (true) {
				String tmp[] = br.readLine().split(" ");
				if (!tmp[1].equals("goes")) {
					break;
				} else {
					list.add(new ainiGoes(tmp[0], tmp[2]));
				}
			}
			for (int i = 0; i < goes.length; i++) {
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).goes.equals(goes[i])) {
						goes[i] = "";
					}
				}
			}
			for (int i = 0; i < goes.length; i++) {
				if (!goes[i].equals("")) {
					System.out.print(goes[i]+" ");
				}
			}
		}
	}
}
