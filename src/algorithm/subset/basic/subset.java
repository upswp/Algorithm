package algorithm.subset.basic;

public class subset {

static int totalCount = 0;
static int[] srcArray = { 1, 4, 5 };
static boolean[] select = new boolean[srcArray.length];

public static void main(String[] args) {
    
    subset(0);
    System.out.println(totalCount);
}

public static void subset(int srcIndex) {
    
    if( srcIndex == srcArray.length ) {
        printSubset();
        totalCount++;
        return;
    }

    select[srcIndex] = true;	//첫번째 재귀에서 전체를 기준으로 재귀를 돌고
    subset(srcIndex + 1);		//계속해서 반복하여 다음 인덱스로 전달
    select[srcIndex] = false;	//그다음 전체가 선택된 값들을 기준이 지나고 하나씩 false를 시켜주어 하나씩 빼주면서 나옴.
    subset(srcIndex + 1);		//계속해서 다음계속 다음으로 넘어가는 인덱스 전달. 
}

public static void printSubset() {
    System.out.print("{ ");
    for( int i=0; i<select.length; i++ ) {
        if( select[i] ) System.out.print(srcArray[i] + " ");
    }
    System.out.print(" }");
    System.out.println();
}
}

