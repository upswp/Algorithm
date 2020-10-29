package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class NHN_02_시멘트양계산하기 {
	
	static int day, width, blocks[];
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader (System.in));
		day = Integer.parseInt(br.readLine());
		width = Integer.parseInt(br.readLine());
		blocks = new int [width];
		int cement_sum = 0;
		int cement = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int countday = 0; countday < day; countday++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < width; i++) {
				blocks[i] = Integer.parseInt(st.nextToken());
			}
			stack.push(blocks[0]);
			for (int i = 1; i < width; i++) {
				int height = blocks[i];
					if (stack.peek() > height) {
						cement_sum += stack.peek()-height;
						cement = stack.peek()-height;
						stack.push(height+cement);
					}else {
						stack.push(height);
					}
			}
		}
		System.out.println(cement_sum);
	}
}
