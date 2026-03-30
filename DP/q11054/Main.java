package DP.q11054;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int[][] memo = new int[N][2];
        memo[0][0] = 1;
        memo[0][1] = 1;
        int answer = 1;
        for(int i=1;i<N;i++) {
            //memo[i][0]: index i에서 끝나는 가장 긴 증가수열 길이
            //memo[i][1]: index i에서 끝나는 가장 긴 바이토닉(증가-감소 패턴) 수열 길이
            memo[i][0] = 1;
            memo[i][1] = 1;
            for(int j=0;j<i;j++) {
                if(arr[j] < arr[i]) {
                    if(memo[i][0] < memo[j][0]+1) memo[i][0] = memo[j][0]+1;
                } else if(arr[j] > arr[i]) {
                    if(memo[i][1] < memo[j][0]+1) memo[i][1] = memo[j][0]+1;
                    if(memo[i][1] < memo[j][1]+1) memo[i][1] = memo[j][1]+1;
                }
            }
            if(answer < memo[i][0]) answer = memo[i][0];
            if(answer < memo[i][1]) answer = memo[i][1];
        }
        System.out.println(answer);
    }
}
