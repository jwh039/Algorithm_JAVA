package Programmers.q181188;

// 요격 시스템

// 푸는 방법만 AI

import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets,(a,b)->a[1]-b[1]);
        int answer = 0;
        int removed = 0;
        for(int i=0;i<targets.length;i++) {
            if(removed <= targets[i][0]) {
                answer++;
                removed = targets[i][1];
            }
        }
        return answer;
    }
}
