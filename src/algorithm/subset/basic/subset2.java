package algorithm.subset.basic;

// 0부터 9까지의 숫자를 2개의 그룹으로 나누는 경우의 수와 그룹의 원소를 모두 출력하세요.
public class subset2 {

	static int totalCount = 0;
	static int[] srcArray = new int[10];
	static boolean[] select = new boolean[srcArray.length];

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			srcArray[i] = i;
		}
		subset(0);
		System.out.println(totalCount);
	}

	static void subset(int srcIndex) {

		if (srcIndex == srcArray.length) {
			// complete code here
			totalCount++;
			check();
			return;
		}

		select[srcIndex] = true;
		subset(srcIndex + 1);
		select[srcIndex] = false;
		subset(srcIndex + 1);
	}

	static void check() {
		System.out.println("=========================================");
		for (int i = 0; i < select.length; i++) {
			if (select[i]) {
				System.out.print(srcArray[i] + " ");
			}
		}
		System.out.println();

		for (int i = 0; i < select.length; i++) {

			if (!select[i]) {
				System.out.print(srcArray[i] + " ");
			}
		}
		System.out.println();
	}
}
