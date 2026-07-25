package Programmers.q132265;

// 롤케이크 자르기

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int[] left = new int[topping.length];
        int[] right = new int[topping.length];
        boolean[] hasTopping = new boolean[10001];
        int toppingCount = 0;
        for(int i=0;i<topping.length;i++) {
            if(!hasTopping[topping[i]]) {
                hasTopping[topping[i]] = true;
                left[i] = ++toppingCount;
            } else {
                left[i] = left[i-1];
            }
        }
        Arrays.fill(hasTopping, false);
        toppingCount = 0;
        for(int i=topping.length-1;i>=0;i--) {
            if(!hasTopping[topping[i]]) {
                hasTopping[topping[i]] = true;
                right[i] = ++toppingCount;
            } else {
                right[i] = right[i+1];
            }
        }
        int answer = 0;
        for(int i=0;i<topping.length-1;i++) {
            if(left[i] == right[i+1]) answer++;
        }
        return answer;
    }
}
