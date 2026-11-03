package Programmers.q131701;

// 연속 부분 수열 합의 개수

import java.util.*;

class Solution {
    //sum[i] = elements[0]~elements[i]까지의 합
    int[] sum;
    
    public int solution(int[] elements) {
        sum = new int[elements.length];
        sum[0] = elements[0];
        for(int i=1;i<sum.length;i++) {
            sum[i] = sum[i-1]+elements[i];
        }
        Set<Integer> set = new HashSet<>();
        
        // 수열 합 개수 세기
        for(int i=0;i<elements.length;i++) {
            for(int j=0;j<elements.length;j++) {
                set.add(sequence_sum(i,j));
            }
        }
        return set.size();
    }
    
    // 수열 합을 O(1) 복잡도로 구함
    private int sequence_sum(int start, int end) {
        if(start <= end) {
            if(start == 0) return sum[end];
            else return sum[end] - sum[start-1];
        } else {
            return sum[sum.length-1] - sum[start-1] + sum[end];
        }
    }
}
