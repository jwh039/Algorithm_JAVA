package Programmers.q154539;

// 뒤에 있는 큰 수 찾기

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<numbers.length;i++) {
            while(!stack.isEmpty()) {
                int[] element = stack.peek();
                if(element[0] < numbers[i]) {
                    stack.pop();
                    answer[element[1]] = numbers[i];
                } else break;
            }
            stack.add(new int[]{numbers[i], i});
        }
        return answer;
    }
}
