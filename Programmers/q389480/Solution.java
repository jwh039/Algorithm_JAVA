package Programmers.q389480;

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        // memo[i][j] = 0~i번까지 물건 훔쳤을때, B의 누적 흔적이 j, A의 흔적 최소
        int[][] memo = new int[info.length][m];
        for(int i=0;i<info.length;i++) {
            for(int j=0;j<m;j++) {
                memo[i][j] = 121;
            }
        }
        memo[0][0] = info[0][0]; // A가 0번 물건을 훔침
        if(info[0][1] < m) {
            memo[0][info[0][1]] = 0; // B가 0번 물건을 훔침
        }
        for(int i=1;i<info.length;i++) {
            for(int j=0;j<m;j++) {
                // A가 i번 물건을 훔침
                memo[i][j] = Math.min(memo[i][j], memo[i-1][j] + info[i][0]);
                // B가 i번 물건을 훔침
                if(j+info[i][1] < m) {
                    memo[i][j+info[i][1]] = Math.min(memo[i][j+info[i][1]],memo[i-1][j]);
                }
            }
        }
        final int lastObject = info.length-1;
        int min = 121;
        for(int j=0;j<m;j++) {
            if(min > memo[lastObject][j]) min = memo[lastObject][j];
        }
        return (min<n)? min : -1;
    }
}