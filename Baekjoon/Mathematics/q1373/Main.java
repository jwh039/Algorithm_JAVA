package Mathematics.q1373;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));  // 제출 시 지우고 낼 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bin = br.readLine();
        if(bin.equals("0")) {
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int expCount = 0;
        int value = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=bin.length()-1;i>=0;i--) {
            if(bin.charAt(i) == '1') {
                if(expCount == 0) value++;
                else if(expCount == 1) value += 2;
                else value += 4;
            }
            if(expCount==2) { 
                st.push(value);
                value = 0;
                expCount = 0;
            }
            else expCount++;
        }
        if(value > 0) sb.append(value);
        while(!st.empty()) sb.append(st.pop());
        System.out.println(sb.toString());
    }
}
