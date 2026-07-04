package Programmers.q468371;
// 노란불 신호등

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int[] periods = new int[signals.length];
        for(int i=0;i<signals.length;i++) {
            periods[i] = signals[i][0]+signals[i][1]+signals[i][2];
        }
        int lcm = LCM(periods);
        char[] status = new char[signals.length];
        int[] counter = new int[signals.length];
        for(int i=0;i<status.length;i++) {
            status[i] = 'R';
            counter[i] = 0;
        }
        int t=0;
        while(t<=lcm) {
            t++;
            for(int i=0;i<signals.length;i++) {
                if(counter[i] == 0) {
                    switch(status[i]) {
                        case 'G':
                            status[i] = 'Y';
                            counter[i] = signals[i][1];
                            break;
                        case 'Y':
                            status[i] = 'R';
                            counter[i] = signals[i][2];
                            break;
                        case 'R':
                            status[i] = 'G';
                            counter[i] = signals[i][0];
                            break;
                    }
                }
                counter[i]--;
            }
            boolean isAllYellow = true;
            for(int i=0;i<signals.length;i++) {
                if(status[i] != 'Y') {
                    isAllYellow = false;
                    break;
                }
            }
            if(isAllYellow) return t;
        }
        return -1;
    }
    
    private int GCD(int a, int b) {
        while(b>0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    private int LCM(int a, int b) {
        return a*b/(GCD(a,b));
    }
    
    private int LCM(int[] nums) {
        int result = 1;
        for(int i=0;i<nums.length;i++) {
            result = LCM(result, nums[i]);
        }
        return result;
    }
}