package Programmers.q142085;

// 디펜스 게임

import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer;
        int soldiers = n;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(answer=0;answer<enemy.length;answer++) {
            if(minHeap.size() < k) {
                minHeap.add(enemy[answer]);
            } else {
                if(minHeap.peek() >= enemy[answer]) {
                    soldiers -= enemy[answer];
                } else {
                    int en = minHeap.poll();
                    minHeap.add(enemy[answer]);
                    soldiers -= en;
                }
            }
            if(soldiers < 0) break;
        }
        return answer;
    }
}