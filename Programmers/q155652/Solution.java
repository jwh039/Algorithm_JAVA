package Programmers.q155652;

import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        char[] letter = new char[26-skip.length()];
        int count = 0;
        for(char c='a';c<='z';c++) {
            if(skip.indexOf(c) < 0) {
                letter[count++] = c;
            }
        }
        char[] transform = new char[26-skip.length()];
        for(int i=0;i<transform.length;i++) {
            int newidx = i+index;
            if(newidx >= transform.length) newidx %= transform.length;
            transform[i] = letter[newidx];
        }
        StringBuilder sb = new StringBuilder();
        for(int idx=0;idx<s.length();idx++) {
            int i;
            for(i=0;i<letter.length;i++) {
                if(letter[i] == s.charAt(idx)) break;
            }
            sb.append(transform[i]);
        }
        return sb.toString();
    }
}
