package DP.q15988;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        final int div = 1000000009;
        int[] arr = new int[1000001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i=4;i<1000001;i++) {
            int temp = arr[i-1] + arr[i-2];
            temp %= div;
            arr[i] = temp + arr[i-3];
            arr[i] %= div;
        }
        for(int i=0;i<T;i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
