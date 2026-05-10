package Baekjoon.DP.q1309;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] memo = new int[100001][3];
        memo[1][0] = 1; memo[1][1] = 1; memo[1][2] = 1;
        for(int i=2;i<=100000;i++) {
            memo[i][0] = (memo[i-1][0] + memo[i-1][1] + memo[i-1][2]) % 9901;
            memo[i][1] = (memo[i-1][0] + memo[i-1][2]) % 9901;
            memo[i][2] = (memo[i-1][0] + memo[i-1][1]) % 9901;
        }
        System.out.println((memo[N][0]+memo[N][1]+memo[N][2]) % 9901);
    }
}