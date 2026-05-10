package Baekjoon.Stack.q17413;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));  // 제출 시 지우고 낼 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        boolean isTag = false;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if(c == '<') {
                while(!stack.empty()) sb.append(stack.pop());
                sb.append(c);
                isTag = true;
            } else if(c == '>') {
                sb.append(c);
                isTag = false;
            } else if (c == ' ') {
                while(!stack.empty()) sb.append(stack.pop());
                sb.append(c);
            } else {
                if(!isTag) stack.push(c);
                else sb.append(c);
            }
        }
        while(!stack.empty()) sb.append(stack.pop());
        System.out.println(sb.toString());
    }
}

