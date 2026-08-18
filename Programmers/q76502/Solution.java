package Programmers.q76502;

// 괄호 회전하기

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++) {
            Stack<Character> st = new Stack<>();
            boolean correct = true;
            for(int j=i;j<i+s.length();j++) {
                char ch = s.charAt(j%s.length());
                if(ch=='(' || ch=='{' || ch=='[') {
                    st.add(ch);
                } else if(ch==')') {
                    if(st.isEmpty() || st.peek() != '(') {
                        correct = false;
                        continue;
                    }
                    else st.pop();
                } else if(ch=='}') {
                    if(st.isEmpty() || st.peek() != '{') {
                        correct = false;
                        continue;
                    }
                    else st.pop();
                } else if(ch==']') {
                    if(st.isEmpty() || st.peek() != '[') {
                        correct = false;
                        continue;
                    }
                    else st.pop();
                }
            }
            if(!st.isEmpty()) correct = false;
            if(correct) answer++;
        }
        return answer;
    }
}
