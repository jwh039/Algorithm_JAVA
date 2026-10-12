package Programmers.q258705;

// 산 모양 타일링

class Solution {
    public int solution(int n, int[] tops) {
        int[][] memo = new int[n][4];
        memo[0][0] = 1;
        memo[0][1] = 1;
        memo[0][3] = 1;
        memo[0][2] = tops[0];
        
        for(int i=1;i<n;i++) {
            final int sum = memo[i-1][0]+memo[i-1][1]+memo[i-1][2]+memo[i-1][3];
            memo[i][0] = sum;
            memo[i][1] = sum - memo[i-1][3];
            memo[i][2] = sum * tops[i];
            memo[i][3] = sum;
            memo[i][0] %= 10007;
            memo[i][1] %= 10007;
            memo[i][2] %= 10007;
            memo[i][3] %= 10007;
        }
        int answer = memo[n-1][0]+memo[n-1][1]+memo[n-1][2]+memo[n-1][3];
        return answer%10007;
    }
}