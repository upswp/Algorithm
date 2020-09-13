package algorithm.permutation.basic;
import java.util.ArrayList;
/**
 * 복습필요
 * @author Park Sangwoo
 *
 */
public class PermTest {

static char[] c="ABCD".toCharArray();
static ArrayList<String> list=new ArrayList<>();
public static void main(String[] args) {
    
    nPr(4,4,0,new boolean[4]);

}
public static void nPr(int n, int r, int count, boolean[] b){
    if(r==count){
        System.out.println(list);
        return ;
    }
    //for (int j = 0; j < n; j++) {
        for (int i = 0; i <n; i++) {
            if(!b[i]){
                b[i]=true;
                list.add(c[i]+"");
                nPr(n,r,count+1,b);
                b[i]=false;
                list.remove(c[i]+"");
            }
        }
    //}
}
}