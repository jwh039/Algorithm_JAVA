package Programmers.q131704;

// 택배상자

import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> st = new Stack<>();
        Queue<Integer> qu = new ArrayDeque<>();
        for(int i=1;i<=order.length;i++) {
            qu.add(i);
        }
        int answer = 0;
        while(true) {
            if(!qu.isEmpty() && qu.peek() == order[answer]) {
                qu.poll();
                answer++;
            } else if(!st.isEmpty() && st.peek() == order[answer]) {
                st.pop();
                answer++;
            } else if(!qu.isEmpty()) {
                st.push(qu.poll());
            } else break;
        }
        return answer;
    }
}
