package Baekjoon.BackTracking.q15649;

import java.util.Scanner;

public class Main {
    static int[] nums;
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        for(int i=0;i<N;i++) nums[i] = i+1;
        run(0,new StringBuilder(),sb);
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
    }

    public static void run(int currentLength, StringBuilder current, StringBuilder sb) {
        if(currentLength == M) {
            sb.append(current).append("\n");
            return;
        }
        for(int i=0;i<N;i++) {
            if(nums[i] == -1) continue;
            int temp = nums[i];
            StringBuilder copy = new StringBuilder(current);
            copy.append(nums[i]).append(" ");
            nums[i] = -1;
            run(currentLength+1,copy,sb);
            nums[i] = temp;
        }
    }
}
