package DP.q1149;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N+1][3];
        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) cost[i][j] = Integer.parseInt(st.nextToken());
        }
        int[][] memo = new int[N+1][3];
        for(int j=0;j<3;j++) memo[1][j] = cost[1][j];
        for(int i=2;i<=N;i++) {
            int m0 = memo[i-1][0], m1 = memo[i-1][1], m2 = memo[i-1][2];
            int c0 = cost[i][0], c1 = cost[i][1], c2 = cost[i][2];
            memo[i][0] = (m1 > m2)? m2+c0 : m1+c0;
            memo[i][1] = (m0 > m2)? m2+c1 : m0+c1;
            memo[i][2] = (m0 > m1)? m1+c2 : m0+c2;
        }
        int answer = memo[N][0];
        if(answer > memo[N][1]) answer = memo[N][1];
        if(answer > memo[N][2]) answer = memo[N][2];
        System.out.println(answer);
    }
}