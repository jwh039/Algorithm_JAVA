package Programmers.q154538;

// 숫자 변환하기

import java.util.*;

class Solution_AI {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        final int INF = 1_000_001; // 최대값보다 큰 값으로 초기화
        Arrays.fill(dp, INF);
        
        dp[x] = 0; // 시작점은 연산 0회
        
        for (int i = x; i <= y; i++) {
            if (dp[i] == INF) continue; // 만들 수 없는 숫자는 건너뜀
            
            if (i + n <= y) dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            if (i * 2 <= y) dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            if (i * 3 <= y) dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
        }
        
        return dp[y] == INF ? -1 : dp[y];
    }
}
