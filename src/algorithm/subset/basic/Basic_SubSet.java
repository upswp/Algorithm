package algorithm.subset.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Character.Subset;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * Basic SubSet
 * 
 * @author Park Sangwoo
 * @since 2020-08-30
 */
public class Basic_SubSet {
	static int N , totalCnt;
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		
		input = new int[N];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		SubSet(0);
		System.out.println("총 경우의 수: "+ totalCnt);
		
	}
	public static void SubSet(int cnt) {
		if (cnt == N) {
			++totalCnt;
			for (int i = 0; i < N; i++) {
				System.out.print(isSelected[i]?input[i]:"X");
				System.out.print("\t");
			}
			System.out.println();
			return;
		}
		
		//부분집합 구성에 포함
		isSelected[cnt] = true;
		//다음원소로 넘어감
		SubSet(cnt+1);
		//부분집합 구성에 비포함
		isSelected[cnt] = false;
		//다음 원소로 넘어감
		SubSet(cnt+1);
		
	}

}
