package Baekjoon.Bruteforce.q28239;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int t=0;t<n;t++) {
            long m = sc.nextLong();
            int answer_x = -1, answer_y = -1;
            int exp = 0;
            while(m>0) {
                if(m%2 == 1) {
                    if(answer_x == -1) answer_x = exp;
                    else answer_y = exp;
                }
                exp++;
                m = m>>1;
            }
            if(answer_y == -1) {
                // m이 2의 거듭제곱(2^x)일 때, 답을 2^(x-1) + 2^(x-1)로 취급
                answer_x--;
                answer_y = answer_x;
            }
            System.out.println(answer_x + " " + answer_y);
        }
    }
}
