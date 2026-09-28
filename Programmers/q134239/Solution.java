package Programmers.q134239;

import java.util.*;

// 우박수열 정적분

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Long> seq = new ArrayList<>();
        long kl = (long)k;
        while(kl != 1L) {
            seq.add(kl);
            if(kl%2 == 0) kl /= 2;
            else kl = kl*3+1;
        }
        seq.add(1L);
        long[] sequence = seq.stream().mapToLong(Long::longValue).toArray();
        final int n = sequence.length-1;
        // 누적 합
        long[] sum = new long[sequence.length];
        sum[0] = sequence[0];
        for(int i=1;i<sum.length;i++) sum[i] = sum[i-1]+sequence[i];
        // answer 구하기
        double[] answer = new double[ranges.length];
        for(int i=0;i<answer.length;i++) {
            int startIndex = ranges[i][0];
            int endIndex = n+ranges[i][1];
            if(startIndex < 0 || startIndex > n || endIndex < 0 || endIndex > n || startIndex > endIndex) {
                answer[i] = -1;
                continue;
            }
            answer[i] = findAnswer(sum, sequence, startIndex, endIndex);
        }
        return answer;
    }
    
    private double findAnswer(long[] sum, long[] sequence, int a, int b) {
        long fromAtoB = sum[b];
        if(a > 0) fromAtoB -= sum[a-1];
        fromAtoB *= 2;
        fromAtoB -= sequence[a];
        fromAtoB -= sequence[b];
        return ((double)fromAtoB)/2;
    }
}