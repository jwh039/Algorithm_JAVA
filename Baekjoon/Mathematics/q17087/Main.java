package Baekjoon.Mathematics.q17087;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));  // 제출 시 지우고 낼 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] dist = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int input = Integer.parseInt(st.nextToken());
            dist[i] = (S > input)? S-input : input-S;
        }
        int answer = dist[0];
        for(int i=1;i<N;i++) {
            answer = GCD(answer,dist[i]);
        }
        System.out.println(answer);
    }

    public static int GCD(int a, int b) {
        while(b>0) {
            int temp=a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}