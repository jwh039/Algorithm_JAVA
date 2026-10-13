package Programmers.q138475;

// 억억단을 외우자

// [80/100], 사유: 시간 초과

import java.util.*;

class Solution_Timeover {
    boolean[] isPrime;
    
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        isPrime = new boolean[5000001];
        Arrays.fill(isPrime, true);
        for(int i=4;i<isPrime.length;i+=2) isPrime[i] = false;
        for(int i=3;i<isPrime.length;i+=2) {
            if(!isPrime[i]) continue;
            for(int j=i*2;j<isPrime.length;j+=i) isPrime[j] = false;
        }
        int[] copy = starts.clone();
        Arrays.sort(copy);
        int[] memo = new int[e-copy[0]+1];
        for(int i=0;i<memo.length;i++) memo[i] = factorCount(copy[0]+i);
        int[] memo2 = new int[memo.length];
        for(int i=0;i<memo2.length;i++) memo2[i] = i+copy[0];
        for(int i=memo2.length-2;i>=0;i--) {
            if(memo[i] < memo[i+1]) {
                memo[i] = memo[i+1];
                memo2[i] = memo2[i+1];
            }
        }
        for(int i=0;i<answer.length;i++) {
            answer[i] = memo2[starts[i]-copy[0]];
        }
        return answer;
    }
    
    private int factorCount(final int n) {
        int result = 1;
        int nn = n;
        int temp = 0;
        while(nn%2 == 0) {
            nn /= 2;
            temp++;
        }
        result *= (temp+1);
        if(nn == 1) return result;
        for(int i=3;i<=n;i+=2) {
            if(!isPrime[i]) continue;
            temp = 0;
            while(nn%i == 0) {
                nn /= i;
                temp++;
            }
            result *= (temp+1);
            if(nn == 1) break;
        }
        return result;
    }
}
