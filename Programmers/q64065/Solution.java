package Programmers.q64065;

import java.util.*;

// 튜플

class Solution {
    public int[] solution(String s) {
        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '{') {
                set = new HashSet<>();
            } else if(c >= '0' && c <= '9') {
                sb.append(c);
            } else if(c == ',') {
                if(s.charAt(i-1) == '}') continue;
                set.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
            } else {
                // if(c == '}')
                if(s.charAt(i-1) == '}') continue;
                set.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
                list.add(set);
            }
        }
        list.sort((a,b) -> (a.size()-b.size()));
        int[] answer = new int[list.size()];
        int count = 0;
        Set<Integer> prev = new HashSet<>();
        for(Set<Integer> curr : list) {
            for(int i : curr) {
                if(!prev.contains(i)) {
                    answer[count++] = i;
                    break;
                }
            }
            prev = curr;
        }
        return answer;
    }
}
