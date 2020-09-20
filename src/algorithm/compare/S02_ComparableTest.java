package algorithm.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author taeheekim
 *
 */
public class S02_ComparableTest {

	static class Student implements Comparable<Student> 
	{
		int no, score;

		public Student(int no, int score) {
			super();
			this.no = no;
			this.score = score;
		}

		//@Override
		public int compareTo(Student o) {
			//return this.no - o.no; // 음수가 들어올 경우 오류가 발생할 수 있음.
			return Integer.compare(this.no, o.no); //overflow가 발생하지 않음
		}

		@Override
		public String toString() {
			return "Student [no=" + no + ", score=" + score + "]";
		}

	}
//그때그때 상황때마다 바꿔가면서 진행 이 부분을
	static class StudentComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return -(o1.no - o2.no);
		}

	}

	public static void main(String[] args) {

		Student[] arr = new Student[] { new Student(1, 10), new Student(3, 50), new Student(2, 80),
				new Student(4, 10) };
		System.out.println("=========정렬 전=============");
		print(arr);
		Arrays.sort(arr);
		System.out.println("=========번호 오름차순=============");
		print(arr);

		Student[] arr2 = new Student[] { new Student(1, 10), new Student(3, 50), new Student(2, 80),
				new Student(4, 10) };
		System.out.println("=========정렬 전=============");
		print(arr2);
		Arrays.sort(arr2, new StudentComparator());
		System.out.println("=========번호 내림차순=============");
		print(arr2);
	}
	private static void print(Student[] arr) {
		for (Student student : arr) {
			System.out.println(student);
		}
	}

}