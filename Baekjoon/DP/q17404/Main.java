package Baekjoon.DP.q17404;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(N==1) {
            int answer = cost[0][0] > cost[0][1]? cost[0][1] : cost[0][0];
            if(answer > cost[0][2]) answer = cost[0][2];
            System.out.println(answer);
            return;
        }
        //memo[i][j][k]: i값, 시작(0번째)색 j, 끝(i번째)색 k
        int[][][] memo = new int[N][3][3];
        for(int j=0;j<3;j++) {
            for(int k=0;k<3;k++) {
                if(j==k) memo[0][j][k] = cost[0][j];
                else memo[0][j][k] = 1000000; //불가능
            }
        }
        for(int j=0;j<3;j++) {
            for(int k=0;k<3;k++) {
                if(j==k) memo[1][j][k] = 1000000;
                else memo[1][j][k] = cost[0][j] + cost[1][k];
            }
        }
        for(int i=2;i<N;i++) {
            for(int j=0;j<3;j++) {
                if(memo[i-1][j][1] < memo[i-1][j][2]) {
                    memo[i][j][0] = memo[i-1][j][1] + cost[i][0];
                } else {
                    memo[i][j][0] = memo[i-1][j][2] + cost[i][0];
                }
                if(memo[i-1][j][0] < memo[i-1][j][2]) {
                    memo[i][j][1] = memo[i-1][j][0] + cost[i][1];
                } else {
                    memo[i][j][1] = memo[i-1][j][2] + cost[i][1];
                }
                if(memo[i-1][j][0] < memo[i-1][j][1]) {
                    memo[i][j][2] = memo[i-1][j][0] + cost[i][2];
                } else {
                    memo[i][j][2] = memo[i-1][j][1] + cost[i][2];
                }
            }
        }
        int answer = 1000000;
        for(int j=0;j<3;j++) {
            for(int k=0;k<3;k++) {
                if(j==k) continue;
                if(answer > memo[N-1][j][k]) answer = memo[N-1][j][k];
            }
        }
        System.out.println(answer);
    }
}
