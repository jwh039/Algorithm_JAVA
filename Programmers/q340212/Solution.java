package Programmers.q340212;

// 퍼즐 게임 챌린지

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int[] times_wrong = new int[times.length];
        int[][] diffs_2d = new int[diffs.length][2];
        for(int i=0;i<diffs.length;i++) {
            diffs_2d[i][0] = i;
            diffs_2d[i][1] = diffs[i];
        }
        Arrays.sort(diffs_2d, (a,b) -> b[1]-a[1]);
        times_wrong[0] = 0;
        for(int i=1;i<times_wrong.length;i++) {
            times_wrong[i] = times[i] + times[i-1];
        }
        long times_sum = 0;
        for(int i=0;i<times.length;i++) {
            times_sum += times[i];
        }
        int wrong_index = -1;
        long wrong_time_sum = 0;
        int level = diffs_2d[0][1];
        long total_time = times_sum;
        for(; ;level--) {
            while(true) {
                if(wrong_index+1 == diffs_2d.length) break;
                if(diffs_2d[wrong_index+1][1] > level) {
                    wrong_index++;
                    wrong_time_sum += times_wrong[diffs_2d[wrong_index][0]];
                } else break;
            }
            total_time += wrong_time_sum;
            if(total_time > limit) break;
            if(level <= 0) break;
        }
        return level+1;
    }
}
