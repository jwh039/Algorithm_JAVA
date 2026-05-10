package DP.q2156;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        for(int i=0;i<n;i++) wine[i] = Integer.parseInt(br.readLine());
        int memo_0 = 0, memo_1 = wine[0], memo_2 = wine[0];
        for(int i=1;i<n;i++) {
            int next_memo_0 = (memo_0 > memo_1) ? memo_0 : memo_1;
            if(next_memo_0 < memo_2) next_memo_0 = memo_2;
            int next_memo_1 = memo_0 + wine[i];
            int next_memo_2 = memo_1 + wine[i];
            memo_0 = next_memo_0; memo_1 = next_memo_1; memo_2 = next_memo_2;
        }
        int answer = (memo_0 > memo_1) ? memo_0 : memo_1;
        if(answer < memo_2) answer = memo_2;
        System.out.println(answer);
    }
}
