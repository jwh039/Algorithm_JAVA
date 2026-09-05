package Programmers.q161988;

// 연속 펄스 부분 수열의 합

public class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        for(int i=0;i<sequence.length;i+=2) {
            sequence[i] *= -1;
        }
        long[][] memo = new long[sequence.length][2];
        // memo[i][0] = index i에서 끝나는, 합이 가장 큰 연속 부분 수열
        // memo[i][1] = index i에서 끝나는, 합이 가장 작은 연속 부분 수열
        memo[0][0] = sequence[0];
        memo[0][1] = sequence[0];
        for(int i=1;i<memo.length;i++) {
            memo[i][0] = sequence[i];
            if(memo[i-1][0]>0) memo[i][0] += memo[i-1][0];
            memo[i][1] = sequence[i];
            if(memo[i-1][1]<0) memo[i][1] += memo[i-1][1];
        }
        for(int i=0;i<memo.length;i++) {
            if(answer < memo[i][0]) answer = memo[i][0];
            if(answer < -memo[i][1]) answer = -memo[i][1];
        }
        return answer;
    }
} 
