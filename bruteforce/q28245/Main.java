package bruteforce.q28245;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int t=0;t<n;t++) {
            long m = sc.nextLong();
            ArrayList<Integer> exp_list = new ArrayList<>();
            int exp = 0;
            int answer_x = -1, answer_y = -1;
            if(m==1) {
                //m==1일때만 예외 처리
                System.out.println("0 0");
                continue;
            }
            while(m>0) {
                if(m%2 == 1) {
                    exp_list.add(exp);
                }
                exp++;
                m = m>>1;
            }
            if(exp_list.size() == 1) {
                // m이 2의 거듭제곱(2^x)일 때, 답을 2^(x-1) + 2^(x-1)로 취급
                int ans = exp_list.get(0);
                answer_x = ans-1;
                answer_y = ans-1;
            } 
            else if(exp_list.size() == 3 || exp_list.size()==2) {
                final int size = exp_list.size();
                answer_x = exp_list.get(size-2);
                answer_y = exp_list.get(size-1);
            }
            else if(exp_list.size() > 3) {
                final int size = exp_list.size();
                answer_x = exp_list.get(size-2);
                answer_y = exp_list.get(size-1);
                if(exp_list.get(size-3) == answer_x-1) answer_x++;
            }
            System.out.println(answer_x + " " + answer_y);
        }
    }
}
