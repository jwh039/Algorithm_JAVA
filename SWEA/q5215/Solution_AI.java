package SWEA.q5215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_AI {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[] score = new int[N];
            int[] calorie = new int[N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                calorie[i] = Integer.parseInt(st.nextToken());
            }
            // dp[i] = 칼로리 제한이 i일 때, 얻을 수 있는 최대 점수
            int[] dp = new int[L+1];
            for(int i=0;i<N;i++) {
                int sc = score[i];
                int cal = calorie[i];
                for(int j=L;j>=cal;j--) {
                    dp[j] = (dp[j] >= dp[j-cal]+sc)? dp[j] : dp[j-cal]+sc;
                }
            }
            System.out.println("#" + tc + " " + dp[L]);
        }
    }
}
