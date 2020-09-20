package algorithm.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author taeheekim
 *
 */
public class S03_ComparatorTest {
	
   //Comparator<int[]> 배열원소의 타입이 들어가야함.
	
   static class MyComparator implements Comparator<int[]>{

		@Override
		public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
//            return o1[0] - o2[0];
		}
	   
   }
   
   public static void main(String[] args) {
      
      int[][] arr = new int[][]{{1,10},{3,50},{2,80},{4,10}};
      System.out.println("=========정렬 전=============");
      print(arr);
      Arrays.sort(arr, new MyComparator());
      System.out.println("=========정렬 후=============");
      print(arr);
   }
   
	private static void print(int[][] arr) {
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}