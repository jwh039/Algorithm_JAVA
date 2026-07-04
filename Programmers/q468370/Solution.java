package Programmers.q468370;
// 중요한 단어를 스포 방지

import java.io.*;
import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        Set<String> wordList = new HashSet<>();
        Set<String> important_wordList = new HashSet<>();
        boolean[] transformed_spoiler_ranges = transform_spoiler_ranges(spoiler_ranges, message.length());
        StringBuilder sb = new StringBuilder();
        boolean is_important = false;
        for(int i=0;i<message.length();i++) {
            char c = message.charAt(i);
            if(c==' ') {
                if(is_important) {
                    important_wordList.add(sb.toString());
                } else {
                    wordList.add(sb.toString());
                }
                is_important = false;
                sb = new StringBuilder();
            } else {
                if(transformed_spoiler_ranges[i]) is_important = true;
                sb.append(c);
            }
        }
        if(is_important) {
            important_wordList.add(sb.toString());
        } else {
            wordList.add(sb.toString());
        }
        important_wordList.removeAll(wordList);
        return important_wordList.size();
    }
    
    private boolean[] transform_spoiler_ranges(int[][] spoiler_ranges, int length) {
        boolean[] transform_ranges = new boolean[length];
        for(int i=0;i<transform_ranges.length;i++) {
            transform_ranges[i] = false;
        }
        for(int i=0;i<spoiler_ranges.length;i++) {
            for(int j=spoiler_ranges[i][0];j<=spoiler_ranges[i][1];j++) {
                transform_ranges[j] = true;
            }
        }
        return transform_ranges;
    }
}
