package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*좌표값을 받는 class Point*/
class Point{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class BOJ9205_맥주마시면서걸어가기2 {
	static int T ,storeNum;
	static Queue<Point> que = new LinkedList<Point>();
	static Point[] point;
	static boolean emotionCheck;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		/*기본 입력*/
		T = Integer.parseInt(br.readLine());
		/*기본 입력 끝*/
		for (int t = 0; t < T; t++) {
			/*초기화끝*/
			storeNum = Integer.parseInt(br.readLine());
			emotionCheck= false;
			point  = new Point[storeNum +2]; //storeNum + home + festival
			/*초기화*/
			
			/*큐에 좌표값 입력*/
			for (int i = 0; i < point.length; i++) {
				st = new StringTokenizer(br.readLine());
				point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			/*큐에 좌표갑 입력종료*/
			System.out.println(emotionChcek());
		}
	}
	/*
	 * 성공 여부에 따른 감정 체크 
	 */
	private static String emotionChcek() {
		String emotion = "";
		boolean visit[] = new boolean[storeNum+2]; // 방문여부 확인.
		que.offer(point[0]);
		while(!que.isEmpty()) {
			Point crr = que.poll();
			/*festival 도착*/
			if (crr.equals(point[storeNum+1])) {
				emotionCheck = true;
				break;
			}
			/*festival 도착이 아닐경우 거리구하기*/
			for (int i = 0; i < storeNum+2; i++) {
				if (!visit[i] && distance(crr,point[i])<=1000) {
					visit[i] = true;
					que.offer(point[i]);
				}
			}
		}
		/*마지막 기분체크 */
		if (emotionCheck) {
			emotion = "happy";
		}else {
			emotion = "sad";
		}
		return emotion;
	}
	/*
	 * 거리체크
	 */
	private static int distance(Point crr, Point point) {
		int distanceXY = 0;
		distanceXY = Math.abs((crr.x-point.x))+Math.abs((crr.y-point.y));
		return distanceXY;
	}
	
}
