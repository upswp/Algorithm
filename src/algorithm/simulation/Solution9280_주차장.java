package algorithm.simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * SSAFY SWEA 9280
 * @author Park Sangwoo
 * @since 2020-09-13
 */
public class Solution9280_주차장 {

	static int T;
	
	public static void main(String[] args) {
		Scanner scc = new Scanner(System.in);
		T = scc.nextInt();
		for (int t = 0; t < T; t++) {
			
			int N = scc.nextInt(); //주차장 개수
			int M = scc.nextInt(); // 차량 개수
			int [] G = new int [N+1]; //주차장
			int [] rate = new int [N+1]; //주차공간 당 가격 Rate
			int [] weight = new int [M+1]; //무게 Weight
			int [] inOut = new int [2*M+1]; // in + , out -
			int [] TT = new int [N+1]; // 자리당 총 무게
			
			
			for (int i = 1; i < rate.length; i++) {
				rate[i] = scc.nextInt();  // 2 3 5
			}
			for (int i = 1; i < weight.length; i++) {
				weight[i] = scc.nextInt(); // 2 1 3 8
			}
			for (int i = 1; i < inOut.length; i++) {
				inOut[i] = scc.nextInt(); //3 2 3 1 4 4 2 1
			}
			
			Queue<Integer> queue = new LinkedList<Integer>();
			
			
			for (int i = 0; i < inOut.length; i++) {
				
			}
			
			
		}
	}

}
