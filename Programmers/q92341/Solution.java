package Programmers.q92341;

// 주차 요금 계산

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int in_count = 0;
        Set<Integer> carnums = new HashSet<>();
        for(int i=0;i<records.length;i++) {
            if(records[i].charAt(11) == 'I') {
                carnums.add(Integer.parseInt(records[i].substring(6,10)));
                in_count++;
            }
        }
        int[][] in = new int[in_count][2];
        int[][] out = new int[records.length-in_count][2];
        int in_idx = 0;
        int out_idx = 0;
        
        for(int i=0;i<records.length;i++) {
            if(records[i].charAt(11) == 'I') {
                in[in_idx][0] = Integer.parseInt(records[i].substring(6,10));
                in[in_idx][1] = parseTime(records[i].substring(0,5));
                in_idx++;
            } else {
                out[out_idx][0] = Integer.parseInt(records[i].substring(6,10));
                out[out_idx][1] = parseTime(records[i].substring(0,5));
                out_idx++;
            }
        }
        int[][] answer = new int[2][carnums.size()];
        int car_count = 0;
        for(int carnum : carnums) {
            answer[0][car_count++] = carnum;
        }
        Arrays.sort(answer[0]);
        for(int i=0;i<in.length;i++) {
            int in_time = in[i][1];
            int out_time = 23*60+59;
            for(int j=0;j<out.length;j++) {
                if(out[j][0] == in[i][0] && out[j][1] > in[i][1]) {
                    out_time = out[j][1];
                    break;
                }
            }
            int time = out_time - in_time;
            for(int j=0;j<answer[0].length;j++) {
                if(in[i][0] == answer[0][j]) {
                    answer[1][j] += time;
                }
            }
        }
        for(int i=0;i<answer[0].length;i++) {
            answer[1][i] = calFee(answer[1][i], fees);
        }
        return answer[1];
    }
    
    private int parseTime(String time) {
        int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3,5));
        return 60*h + m;
    }
    
    private int calFee(int time, int[] fees) {
        int fee = fees[1];
        if(time > fees[0]) {
            double unit = Math.ceil((double)(time - fees[0])/fees[2]);
            fee += ((int)unit*fees[3]);
        }
        return fee;
    }
}