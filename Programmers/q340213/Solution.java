package Programmers.q340213;

// 동영상 재생기

import java.io.*;
import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int[] video_len_arr = parseString(video_len);
        int[] pos_arr = parseString(pos);
        int[] op_start_arr = parseString(op_start);
        int[] op_end_arr = parseString(op_end);
        for(int c=0;c<commands.length;c++) {
            pos_arr = skipOpening(pos_arr, op_start_arr, op_end_arr);
            if(commands[c].equals("prev")) {
                if(pos_arr[1] < 10) {
                    pos_arr[1] += 60;
                    pos_arr[0]--;
                }
                pos_arr[1] -= 10;
                if(pos_arr[0] < 0) {
                    pos_arr[0] = pos_arr[1] = 0;
                }
            } else if(commands[c].equals("next")) {
                if(pos_arr[1] >= 50) {
                    pos_arr[1] -= 60;
                    pos_arr[0]++;
                }
                pos_arr[1] += 10;
                if(compare_LE(video_len_arr, pos_arr)) {
                    pos_arr = video_len_arr.clone();
                }
            }
            pos_arr = skipOpening(pos_arr, op_start_arr, op_end_arr);
        }
        StringBuilder sb = new StringBuilder();
        if(pos_arr[0] < 10) sb.append("0");
        sb.append(pos_arr[0]);
        sb.append(":");
        if(pos_arr[1] < 10) sb.append("0");
        sb.append(pos_arr[1]);
        return sb.toString();
    }
    
    private int[] parseString(String s) {
        int[] arr = new int[2];
        arr[0] = Integer.parseInt(s.substring(0,2));
        arr[1] = Integer.parseInt(s.substring(3,5));
        return arr;
    }
    
    private boolean compare_LE(int[] arr1, int[] arr2) {
        if(arr1[0] < arr2[0]) return true;
        if(arr1[0] == arr2[0]) {
            if(arr1[1] <= arr2[1]) return true;
        }
        return false;
    }
    
    private int[] skipOpening(int[] pos, int[] op_start, int[] op_end) {
        int[] result = new int[2];
        if(compare_LE(op_start, pos) && compare_LE(pos, op_end)) {
            result = op_end.clone();
        } else {
            result = pos.clone();
        }
        return result;
    }
}
