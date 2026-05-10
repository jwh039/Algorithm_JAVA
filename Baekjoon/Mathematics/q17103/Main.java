package Baekjoon.Mathematics.q17103;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime,true);
        for(int i=2;i<1000001;i++) {
            if(!isPrime[i]) continue;
            for(int j=2;i*j<1000001;j++) {
                isPrime[i*j] = false;
            }
        }
        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            for(int j=2;j<=N/2;j++) {
                if(isPrime[j] && isPrime[N-j]) count++;
            }
            sb.append(count);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}