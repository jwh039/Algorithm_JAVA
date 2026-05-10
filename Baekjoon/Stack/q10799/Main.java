package Stack.q10799;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));  // 제출 시 지우고 낼 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();
        int answer = 0;
        int unclosedLeft = 0;
        Stack<Integer> index = new Stack<>();
        for(int i=0;i<expr.length();i++) {
            char c = expr.charAt(i);
            if(c == '(') {
                index.push(i);
                unclosedLeft++;
            } else {
                int nearestLeft = index.pop();
                unclosedLeft--;
                if(nearestLeft == i-1) {
                    // End of laser
                    answer += unclosedLeft;
                } else {
                    // End of stick
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
