package algorithm.subset.basic;

import java.util.ArrayList;

// 0부터 9까지의 숫자를 2개의 그룹으로 나누되, 이 중 두 그룹의 원소의 갯수가 모두 3보다 크거나 같은 경우 출력하세요
public class subset3 {

static int[] srcArray = new int[10];
static boolean[] select = new boolean[srcArray.length];

static ArrayList<Integer> groupA;
static ArrayList<Integer> groupB;

public static void main(String[] args) {

    for (int i = 0; i < 10; i++) {
        srcArray[i] = i;
    }
    subset(0);
}

static void subset(int srcIndex) {
    
    if( srcIndex == srcArray.length ) {
        // complete code here
        check();
        return;
    }

    select[srcIndex] = true;
    subset(srcIndex + 1);
    select[srcIndex] = false;
    subset(srcIndex + 1);
}

static void check() {
    
    groupA = new ArrayList<Integer>();
    groupB = new ArrayList<Integer>();
    
    for (int i = 0; i < select.length; i++) {
        if(select[i]) {
            groupA.add(srcArray[i]);
        }else {
            groupB.add(srcArray[i]);
        }
    }
    
    if( groupA.size() >= 3 && groupB.size() >= 3 ) {
        System.out.println("=========================================");
        
        for( int n : groupA ) {
            System.out.print(n + " ");
        }
        System.out.println();
        
        for( int n : groupB ) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
}

