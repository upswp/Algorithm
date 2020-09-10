

import java.net.*;
import java.io.*;

public class DAEJEON04_PARKSANGWOO {

	// User and Launcher Information
	static final String NICKNAME = "DAEJEON04_PARKSANGWOO ";
	static final String HOST = "127.0.0.1";

	// Static Value(Do not modify)
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// Predefined Variables(Do not modify)
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
	//static final int[][] fHOLES = { { 20, 20 }, { 127, 20 }, { 234, 20 }, { 20, 107 }, { 127, 107 }, { 234, 107 } };

	static final double R = 5.72 / 2.0;

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		int[][] balls = new int[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");
			while (socket != null) {
				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Integer.parseInt(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// Beginning of Your Code
				// Put your code here to set angle and power values.
				// angle(float) must be between 0.0 and 360.0
				// power(float) must be between 0.0 and 100.0

				int whiteBall_x = balls[0][0];
				int whiteBall_y = balls[0][1];

				int targetBall_x = -1;
				int targetBall_y = -1;

				for (int b = 1; b < NUMBER_OF_BALLS; b++) {
					if (balls[b][0] == -1 || balls[b][1] == -1)
						continue;
					if (order == 1) {
						if (b % 2 == 1) {
							targetBall_x = balls[b][0];
							targetBall_y = balls[b][1];
							break;
						}
					}
					//후공
					else {
						if (b % 2 == 0) {
							targetBall_x = balls[b][0];
							targetBall_y = balls[b][1];
							break;
						}
					}
					if(b==5) {
						targetBall_x = balls[b][0];
						targetBall_y = balls[b][1];
					}
				}

				// You can clear Stage 1 with the pre-written code above.
				// Those will help you to figure out how to clear other Stages.
				// Good luck!!
				// ENd of Your Code
				//////////////////////////////

				int width = Math.abs(targetBall_x - whiteBall_x);
				int height = Math.abs(targetBall_y - whiteBall_y);

				int n = -1;
				double minDist = Double.MAX_VALUE;
				for (int i = 0; i < 6; i++) {
					int[] p = calHitPoint(i, targetBall_x, targetBall_y, whiteBall_x, whiteBall_y);
					double d = findPocket(i, p[0], p[1], whiteBall_x, whiteBall_y);
					if (d != -1 && d <= minDist) {
						minDist = d;
						n = i;
						width = p[0]-whiteBall_x;
						height = p[1]-whiteBall_y;
					}
				}
				if(n == -1) {
					n=0;
				}
				System.out.println("넣을 포켓: " + n);
				double radian = Math.atan2(width, height);
				double A = getDistance(HOLES[n][0], HOLES[n][1],targetBall_x, targetBall_y);
				double B = getDistance(targetBall_x, targetBall_y, whiteBall_x, whiteBall_y);
				double distance = (A+B)/6.0;

				angle = (float) ((180.0 / Math.PI) * radian);
				power = (float) (distance);
				if(power < 20.0) power = (float)20.0;

				System.out.println(angle + " " + power);
				// Play(Send Data)
				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);

			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static int[] calHitPoint(int n, int Dx, int Dy, int Bx, int By) {
		int[] pocket = HOLES[n];
		int Px = pocket[0];
		int Py = pocket[1];

		double distance = getDistance(Dx, Dy, Px, Py);
		double dx = 5.72 * (Dx - Px) / distance;
		double dy = 5.72 * (Dy - Py) / distance;

		int hDx = Dx + (int)(dx+0.3);
		int hDy = Dy + (int)(dy+0.3);
		return new int[] {hDx, hDy };
	}

	static double findPocket(int n, int Dx, int Dy, int Bx, int By) {
		int[] pocket = HOLES[n];
		int Px = pocket[0];
		int Py = pocket[1];

		// 이번 포켓에 넣을 수 없는 경우 계산
		double a = getDistance(Px, Py, Dx, Dy);
		double b = getDistance(Dx, Dy, Bx, By);
		double c = getDistance(Px, Py, Bx, By);

		double angle = Math.acos((a * a + b * b - c * c) / (2 * a * b));

		// 해당 꼭짓점에 넣을 수 없는 경우 -1 반환
		if (angle <= Math.PI / 2.0) {
			return -1;
		}

		// 넣을 수 있다면 꼭짓점과의 거리 반환
		return getDistance(Px, Py, Dx, Dy);
	}

	static double getDistance(int x, int y, int x1, int y1) {
		return Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
	}

}
