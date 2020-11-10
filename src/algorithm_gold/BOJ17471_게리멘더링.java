package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17471_게리멘더링 {
	static int N, map[][], people[], tmp[];
	static boolean isSelected[],visited[];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine()); // 총 구역에 대한 갯수 N
		/* 초기화 */
		map = new int[N + 1][N + 1];
		people = new int[N + 1];
		isSelected = new boolean[N + 1];
		visited = new boolean[N + 1];
		/* 초기화 */

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i < N + 1; i++) {
			people[i] = Integer.parseInt(st.nextToken()); // 각 구역에 대한 인구수 people
		}
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " "); // 구역에 따른 구역과 연결된 도시 갯수, 도시들
			int index = Integer.parseInt(st.nextToken());
			int tmp[] = new int[index];

			for (int j = 0; j < index; j++) {
				tmp[j] = Integer.parseInt(st.nextToken()); // tmp에 도시 이름 넣기.
			}
			for (int j = 0; j < index; j++) {
				checkMap(tmp[j], i);
			}
		}
//		print();
		subset(1);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	/**
	 * N개의 도시에서 추산 가능한 모든 부분수열 city들을 골라내고 
	 * 그 도시들 모임에서 영역을 둘로 나눌 수 있는 조건 찾아내기.
	 * 
	 * @param cnt
	 */
	private static void subset(int cnt) {
		if (cnt == N + 1) {
			
			int red = 0, blue =0;
			for (int i = 1; i < N + 1; i++) {
				if (isSelected[i]) {
					red += people[i];
				}else {
					blue += people[i];
				}
			}
			/*visited배열 false로 초기화*/
			Arrays.fill(visited, false);
			
			/*subset으로 지는 red와 blue count*/
			int count = 0;
			for (int i = 1; i < N+1; i++) {
				if (!visited[i]) {
					solve(i,isSelected[i]);
					count++;
				}
			}
			/*두 영역에 해당하는 합을 구할 수 있는 조건이 되어 2가 된다면*/
			if (count == 2) {
				if (min > Math.abs(red - blue)) {
					min = Math.abs(red - blue);
				}
			}
			return;
		}
		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);
	}
	/**
	 * map을 돌면서 행별로 1이 있는지 확인하고 1이고 방문안한 cityNum이고 Subset에서 true로 골라져서 온 부분수열 의 City 골라내기.
	 * @param cityNum	현재 map에서 해당 열의 1이 있는지 확인 하기 위해 들어온 city
	 * @param flag		SubSet에서 골라진 city판단여부
	 */
	private static void solve(int cityNum, boolean flag) {
		visited[cityNum] = true;
		for (int j = 1; j < N+1; j++) {
			if (map[cityNum][j] == 1 && !visited[j] && isSelected[j] == flag) {
				solve(j, flag);
			}
		}
	}

	/**
	 * map에 연결됐으면 1찍어놓기.
	 * 
	 * @param index   현재 돌고있는 1~N사이의 index
	 * @param zoneNum tmp로 들어온 연결되어있는 영역 넘버
	 */
	static void checkMap(int zoneNum, int index) {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i == index && j == zoneNum) {
					map[i][j] = 1;
				}
			}
		}
	}
	
	private static void print() {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
