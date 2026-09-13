package Programmers.q138476;

// 귤 고르기

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) -> (b-a) );
        int prev = tangerine[0];
        int count = 1;
        for(int i=1;i<tangerine.length;i++) {
            int current = tangerine[i];
            if(current == prev) {
                count++;
            } else {
                pq.add(count);
                prev = current;
                count = 1;
            }
        }
        pq.add(count);
        int answer = 0;
        while(k>0) {
            k -= pq.poll();
            answer++;
        }
        return answer;
    }
}