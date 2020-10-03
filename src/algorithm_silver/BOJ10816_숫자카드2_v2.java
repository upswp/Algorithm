package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class BOJ10816_숫자카드2_v2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        
        for(int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(cards);
        
        int m = Integer.parseInt(br.readLine());
        
        StringBuffer sb = new StringBuffer();
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            int cnt = getCnt(cards, x, n);
            sb.append(cnt + " ");
        }
        
        System.out.println(sb);
    }
 
    private static int getCnt(int[] cards, int x, int n) {
        int left = 0;
        int right = n - 1;
        int cnt = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(x < cards[mid]) {
                right = mid - 1;
            } else if(x > cards[mid]) {
                left = mid + 1;
            } else {
                cnt = 1;
                int tmp = mid;
                
                while(--tmp >= 0 && cards[tmp] == x) {
                    cnt++;
                }
                
                while(++mid < n && cards[mid] == x) {
                    cnt++;
                }
                
                break;
            }
        }
        
        return cnt;
    }
}
