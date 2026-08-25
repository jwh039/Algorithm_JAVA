package Programmers.q176962;

// 과제 진행하기

import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int answerIndex = 0;
        Arrays.sort(plans, (a,b) -> timeCompare(a[1], b[1]));
        String currentTime = plans[0][1];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<plans.length;i++) {
            if(i != plans.length-1) {
                int timeLimit = timeCompare(plans[i+1][1], currentTime);
                int timeNeed = Integer.parseInt(plans[i][2]);
                if(timeLimit >= timeNeed) {
                    answer[answerIndex++] = plans[i][0];
                    timeLimit -= timeNeed;
                    while(timeLimit > 0 && !stack.isEmpty()) {
                        int[] task = stack.pop();
                        if(timeLimit >= task[1]) {
                            timeLimit -= task[1];
                            answer[answerIndex++] = plans[task[0]][0];
                        } else {
                            stack.add(new int[]{task[0], task[1]-timeLimit});
                            break;
                        }
                    }
                    currentTime = plans[i+1][1];
                } else {
                    currentTime = plans[i+1][1];
                    stack.add(new int[]{i, timeNeed-timeLimit});
                }
            } else {
                answer[answerIndex++] = plans[i][0];
                while(!stack.isEmpty()) {
                    int[] task = stack.pop();
                    answer[answerIndex++] = plans[task[0]][0];
                }
            }
        }
        return answer;
    }
    
    private int timeCompare(String t1, String t2) {
        int h1 = Integer.parseInt(t1.substring(0,2));
        int m1 = Integer.parseInt(t1.substring(3,5));
        int h2 = Integer.parseInt(t2.substring(0,2));
        int m2 = Integer.parseInt(t2.substring(3,5));
        return (h1*60+m1) - (h2*60+m2);
    }
}