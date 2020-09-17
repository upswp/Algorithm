package algorithm_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * BOJ 2605 줄세우기
 * @author Park Sangwoo
 * @since 2020-09-17
 */
public class BOJ2605_줄세우기 {
	static int N ;
	static int line[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//입력 start
		N = Integer.parseInt(br.readLine());
		line = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(st.nextToken().trim());
		}																			//입력 end
		
		LinkedList<Integer> list = new LinkedList<Integer>();						//리스트 생성
		
		for (int i = 0; i < N; i++) {												//N번만큼 list에 add실시
//			System.out.print(list.size()+" "+line[i]+"\n");
			list.add(list.size() - line[i], i+1);									//i+1 을 넣어야 할 위치에 list.size()-input[i]과 같다.
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(list.get(i)+" ");
		}
	}

}
