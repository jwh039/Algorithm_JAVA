package DP.q2133;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N%2 == 1) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[N+1];
        arr[0] = 1;
        arr[2] = 3;
        for(int i=4;i<=N;i+=2) {
            arr[i] = 3*arr[i-2];
            for(int j=i-4;j>=0;j-=2) {
                arr[i] += 2*arr[j];
            }
        }
        System.out.println(arr[N]);
    }
}
