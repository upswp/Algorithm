package algorithm.compare;
/**
 * 점검
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Test1 {

	public static class Point{
	    int r;
	    int c;
	    public Point(int r, int c) {
	        super();
	        this.r = r;
	        this.c = c;
	    }
	    @Override
	    public String toString() {
	        return "Point [r=" + r + ", c=" + c + "]";
	    }
	}
	public static class Pcp implements Comparator<Point>{

	    @Override
	    public int compare(Point p1, Point p2) {
	        double r1=Math.abs(p1.r);
	        double r2=Math.abs(p2.r);
	        if(r1-r2>0){
	            return 1;
	        }else if(r1-r2<0) {
	            return -1;
	        }else {  //0
	            if(p1.r-p2.r>0){
	                return 1;
	            }else if(p1.r-p2.r<0) {
	                return -1;
	            }else {
	                return 0;
	            }
	        }
	        //return 0;
	    }
	    // Lexico 'B'-'A'=66-65=1 asc
	}
    public static void main(String[] args) {
        //JCF : java collection Framework
        //java.util
        // Collection 자료를 구조적으로 정리
        // Set     List    Map
        // 중복X    중복O        key가 중복X, value는 중복O
        // 순서X    idxO    순서X

        // ArrayList    LinkedList
        // 편함            빠름
        // List.add(값);
        // List.add(idx, 값); //이미 있던건 한칸씩 뒤로 보냄
        //       .size()
        //     .get(index)
        // <T> : generic, 관행적으로 안에 T 또는 E를 써서 표시, T타입만 받겠다는 의미 

        ArrayList<Point> list=new ArrayList<>();
        list.add(new Point(1,2));
        list.add(new Point(-1,2));
        list.add(new Point(1,-2));    // 중복가능
        list.add(new Point(1,-2));
        list.add(new Point(1,2));
        list.add(0, new Point(-1,-3));
        list.remove(2);    //.clear()
        System.out.println(list.get(2));
        System.out.println("-------------");

        for(int i=0; i<list.size(); i++){
            Point p =list.get(i);
            System.out.println(p);
        }
        
        ArrayList<Integer> ilist=new ArrayList<>();
        ilist.add(3);
        int a= ilist.get(0);
        
        Collections.sort(list,new Pcp());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}