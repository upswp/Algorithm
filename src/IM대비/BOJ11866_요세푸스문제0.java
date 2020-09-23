package IM대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Samsung SW역량 테스트 IM대비 BOJ 11866 요세푸스문제0
 * 
 * @author Park Sangwoo
 * @since 2020-09-23
 */
public class BOJ11866_요세푸스문제0 {
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {						//queue에 값을 추가
			queue.offer(i);									//1~N까지
		}
		
		int cnt = 0, tmp =0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!queue.isEmpty()) {							//queue가 빌때까지 반복
			tmp = queue.poll();								//tmp에 que의 맨 앞에 있는 애들 저장
			if (++cnt%K == 0) {								//++cnt시키며 순서 카운트 실시. 그 순서가 K의 배수일때 삭제조건이므로 
				sb.append(tmp).append(", ");				//삭제한 값을 sb에 추가.
			}
			else {
				queue.offer(tmp);							//아닐경우 다시 queue에 추가.
			}
		}
		sb.setLength(sb.length()-2);						//queue의 마지막에 ", "가 포함 되있으므로 길이를 -2줄여 조정.
		sb.append(">");										//라스트 > 추가
		System.out.println(sb.toString());					//출력
	}
}
