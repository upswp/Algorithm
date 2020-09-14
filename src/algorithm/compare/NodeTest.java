package algorithm.compare;

import java.util.Arrays;
import java.util.Comparator;

public class NodeTest {

	public static class PointsComp implements Comparator<Points> {

		@Override
		public int compare(Points p1, Points p2) {

			double r1 = Math.sqrt(p1.x * p1.x + p1.y * p1.y);
			double r2 = Math.sqrt(p2.x * p2.x + p2.y * p2.y);

			if (r1 - r2 > 0) {
				return 1;
			} else if (r1 - r2 < 0)
				return -1;
			else
				return 0;
		}

	}

	public static class Points {
		int x, y;

		public Points(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Points [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) {
		Points[] ps = new Points[5];
		ps[0] = new Points(1, 2);
		ps[1] = new Points(2, 30);
		ps[2] = new Points(5, 7);
		ps[3] = new Points(12, 20);
		ps[4] = new Points(-20, -5);

		for (int i = 0; i < ps.length; i++) {
			System.out.println(ps[i]);
		}
		System.out.println("------------------------");
		for (Points p : ps) {
			System.out.println(p);
		}
		System.out.println("------------------------");
		System.out.println("------------------------");
		Arrays.sort(ps, new PointsComp());

		System.out.println("------------------------");
		for (Points pp : ps) {
			System.out.println(pp);
		}
	}
}
