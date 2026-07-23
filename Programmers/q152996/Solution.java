package Programmers.q152996;

import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long[] t_memo = new long[4001];
        long[] w_memo = new long[1001];
        Arrays.fill(t_memo,0L);
        Arrays.fill(w_memo,0L);
        for(int i=0;i<weights.length;i++) {
            t_memo[weights[i]*2]++;
            t_memo[weights[i]*3]++;
            t_memo[weights[i]*4]++;
            w_memo[weights[i]]++;
        }
        long answer = 0;
        for(int i=0;i<t_memo.length;i++) {
            answer += (t_memo[i])*(t_memo[i]-1)/2;
        }
        for(int i=0;i<w_memo.length;i++) {
            answer -= (w_memo[i])*(w_memo[i]-1);
        }
        return answer;
    }
}