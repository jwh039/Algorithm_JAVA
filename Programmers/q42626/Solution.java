package Programmers.q42626;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++) {
            pq.add((long)scoville[i]);
        }
        int answer = 0;
        while(pq.peek() < (long)K) {
            if(pq.size() < 2) return -1;
            long a = pq.poll();
            long b = pq.poll();
            pq.add(a+2*b);
            answer++;
        }
        return answer;
    }
}
