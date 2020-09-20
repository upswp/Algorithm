package algorithm.permutation;
/**
 * nPr
 * @author multicampus
 *
 */
public class PermTest {

	static int [] array = {1,2,3,4,5};
	static int N = array.length;
	static int R ;
	static boolean [] isSelected;
	static int [] num;
	static int Total;

	public static void main(String[] args) {
	
		R = 3;
		isSelected = new boolean [N];
		num = new int [N];
		
		nPr(0);
	}

	private static void nPr(int cnt) {
		if(R == cnt) {
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i] =true;
			num[cnt] = array[i];
			
			nPr(cnt+1);
			isSelected[i] =false;
		}
	}

}
