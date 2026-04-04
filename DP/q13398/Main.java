package DP.q13398;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[][] memo = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //memo[i][0]: arr[i]에서 끝나는 최고 연속합 (수 제거 X)
        //memo[i][1]: arr[i]에서 끝나는 최고 연속합 (가능한 모든 경우)
        memo[0][0] = arr[0];
        memo[0][1] = arr[0];
        int answer = (memo[0][0] > memo[0][1])? memo[0][0] : memo[0][1];
        for(int i=1;i<n;i++) {
            memo[i][0] = arr[i];
            memo[i][1] = arr[i];
            //점화식
            if(memo[i-1][0] > 0) memo[i][0] = memo[i-1][0] + arr[i];
            if(memo[i-1][1] > 0) memo[i][1] = memo[i-1][1] + arr[i];
            if(i>=2 && memo[i][1] < memo[i-2][0] + arr[i]) memo[i][1] = memo[i-2][0] + arr[i];
            if(answer < memo[i][0]) answer = memo[i][0];
            if(answer < memo[i][1]) answer = memo[i][1];
        }
        System.out.println(answer);
    }
}
