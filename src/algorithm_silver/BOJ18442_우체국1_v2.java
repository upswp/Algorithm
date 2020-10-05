package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * SSAFY 알고리즘 과목평가 2번
 * @author Park Sangwoo
 * @since 2020-10-05
 */
public class BOJ18442_우체국1_v2 {
	
	static int T,V,P,L,ans,min,tmp,sum;//ans: 답변, min:최소값, tmp:마을간의 거리를 담을 변수, sum : 거리의 합
	static int arrV[],arrP[];	//마을과 경찰을 담을 arr
	static boolean visitP[];	//arrV에서 경찰서에 해당하는 P를 제외시키기 위해
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());		//testcase
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());	//마을갯수
			P = Integer.parseInt(st.nextToken());	//경찰서갯수
			L = Integer.parseInt(st.nextToken());	//전체 거리
			
			arrV = new int [V];						//마을 arr
			arrP = new int [P];						//경찰 arr
			visitP = new boolean [V];				//경찰서 유무 확인
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				arrV[i] = Integer.parseInt(st.nextToken());
			}
			nCr(0,0);
			System.out.println("#"+t+" "+ans);
		}
	}
	public static void nCr(int start, int cnt) {
		if (cnt == P) {
			sum = 0;								//합 변수 초기화
			min = Integer.MAX_VALUE;				//최소값 초기화
			for (int j = 0; j < arrP.length; j++) {
				for (int i = 0; i < arrV.length; i++) {
					if (!visitP[i]) {				// 마을V개중 경찰서 P를 제외한 것을 V로 확인.
						tmp = Math.min(Math.abs(arrV[i]-arrP[j]),L-Math.abs(arrV[i]-arrP[j]));	// 거리구하기
						sum += tmp;					// 거리구한 값들을 합치기.
						min = Math.min(min, sum);	// 그 합들 중 최소값을 min에 대입.
					}
				}
			}
			ans = min;
			return;
		}
		
		for (int i = start; i < V; i++) {
			if (!visitP[i]) {				// 경찰서가 아니라면
				visitP[i] = true;			// 경찰서로 지정하고
				arrP[cnt] = arrV[i]; 		// arrP에 경찰서로 지정된 값들을 arrV에서 가져오기
				nCr(i+1, cnt+1);			// 반복
				visitP[i] = false;			// 경찰서로 지정한 곳을 다시 마을로 변경.
			}
		}
	}
}
