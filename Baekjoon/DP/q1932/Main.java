package DP.q1932;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens()) triangle[i][j++] = Integer.parseInt(st.nextToken());
        }
        int[][] memo = new int[n][n];
        memo[0][0] = triangle[0][0];
        for(int i=1;i<n;i++) {
            for(int j=0;j<=i;j++) {
                int left = (j>0) ? memo[i-1][j-1] : -1;
                int right = (j<=i-1) ? memo[i-1][j] : -1;
                memo[i][j] = (left > right) ? left+triangle[i][j] : right+triangle[i][j];
            }
        }
        int max = memo[n-1][0];
        for(int j=1;j<n;j++) if(max < memo[n-1][j]) max = memo[n-1][j];
        System.out.println(max);
    }
}
