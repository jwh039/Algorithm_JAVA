package DP.q9465;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) sticker[0][j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) sticker[1][j] = Integer.parseInt(st.nextToken());
            int memo_0 = 0, memo_1 = sticker[0][0], memo_2 = sticker[1][0];
            int next_memo_0, next_memo_1, next_memo_2;
            for(int j=1;j<n;j++) {
                next_memo_0 = (memo_1 > memo_2) ? memo_1 : memo_2;
                next_memo_1 = (memo_0 > memo_2) ? memo_0 + sticker[0][j] : memo_2+sticker[0][j];
                next_memo_2 = (memo_0 > memo_1) ? memo_0 + sticker[1][j] : memo_1+sticker[1][j];
                memo_0 = next_memo_0;
                memo_1 = next_memo_1;
                memo_2 = next_memo_2;
            }
            int answer = (memo_0 > memo_1) ? memo_0 : memo_1;
            if(answer < memo_2) answer = memo_2;
            sb.append(answer);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
