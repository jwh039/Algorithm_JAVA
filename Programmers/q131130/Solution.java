package Programmers.q131130;

import java.util.*;

// 혼자 놀기의 달인

class Solution {
    public int solution(int[] cards) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<cards.length;i++) {
            if(cards[i] == 0) continue;
            int index = i;
            int count = 0;
            while(cards[index] != 0) {
                int temp = index;
                index = cards[index]-1;
                cards[temp] = 0;
                count++;
            }
            pq.add(count);
        }
        if(pq.size() < 2) return 0;
        else return pq.poll() * pq.poll();
    }
}