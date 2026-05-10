package Mathematics.q2089;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Long N = sc.nextLong();
        if(N == 0) {
            System.out.println(0);
            return;
        }
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        Long two_k = 2L; //2^k
        int k = 1;
        
        while(N!=0) {
            // 절댓값 N을 구한다
            Long abs_N = (N>0)? N : -N;
            // 절댓값 N이 2^k로 나눠 떨어지면 0을, 아니면 1을 푸시
            if(abs_N % two_k == 0) {
                st.push(0);
            } else {
                st.push(1);
                // 푸시한 값이 1이면, 그 이전 자리값 ((-2)^(k-1))을 N에서 뺀다
                if(k%2==1) N -= (two_k/2);
                else N += (two_k/2);
            }
            // 2^k를 2^(k+1)로
            k++;
            two_k *= 2;
        }
        while(!st.empty()) sb.append(st.pop());
        System.out.println(sb.toString());
    }
}