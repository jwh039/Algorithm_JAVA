package DP.q11055;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        int[] memo = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) sequence[i] = Integer.parseInt(st.nextToken());
        memo[0] = sequence[0];
        int answer = memo[0];
        for(int i=1;i<N;i++) {
            int max = 0;
            for(int j=0;j<i;j++) {
                if(sequence[j] >= sequence[i]) continue;
                if(max < memo[j]) max = memo[j];
            }
            memo[i] = max + sequence[i];
            if(answer < memo[i]) answer = memo[i];
        }
        System.out.println(answer);
    }
}
