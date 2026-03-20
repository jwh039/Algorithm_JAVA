package DP.q11057;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] memo = new int[N+1][10];
        for(int j=0;j<10;j++) memo[1][j] = 1;
        for(int i=2;i<=N;i++) {
            for(int j=0;j<10;j++) {
                for(int k=0;k<=j;k++) memo[i][j] += memo[i-1][k];
                memo[i][j] %= 10007;
            }
        }
        int answer = 0;
        for(int j=0;j<10;j++) answer += memo[N][j];
        System.out.println(answer%10007);
    }
}