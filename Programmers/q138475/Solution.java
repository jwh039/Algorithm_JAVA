package Programmers.q138475;

// 억억단을 외우자

// AI 아이디어 기반 성공 코드

class Solution {
    public int[] solution(int e, int[] starts) {
        final int MAX_LENGTH = 5_000_000;
        int[] answer = new int[starts.length];
        // factorCount[i]: i의 약수의 개수
        int[] factorCount = new int[MAX_LENGTH+1];
        for(int i=1;i<=MAX_LENGTH;i++) {
            for(int j=i;j<=MAX_LENGTH;j+=i) {
                factorCount[j]++;
            }
        }
        // memo[i]: 구간 [i, e]에서 가장 많은 약수를 갖는 정수
        int[] memo = new int[MAX_LENGTH+1];
        memo[e] = e;
        for(int i=e-1;i>0;i--) {
            if(factorCount[i] >= factorCount[memo[i+1]]) {
                memo[i] = i;
            } else {
                memo[i] = memo[i+1];
            }
        }
        for(int i=0;i<answer.length;i++) {
            answer[i] = memo[starts[i]];
        }
        return answer;
    }
}
