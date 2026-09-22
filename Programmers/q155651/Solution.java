package Programmers.q155651;

// 호텔 대실

import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int rooms = 0;
        int[][] bt = new int[book_time.length][2];
        for(int i=0;i<bt.length;i++) {
            bt[i][0] = parseTime(book_time[i][0]);
            bt[i][1] = parseTime(book_time[i][1])+10;
        }
        Integer[] in_order = new Integer[bt.length]; // bt배열 상 index만 저장
        for(int i=0;i<in_order.length;i++) in_order[i] = i;
        Integer[] out_order = in_order.clone();
        Arrays.sort(in_order, (a,b) -> compare(a,b,true,bt));
        Arrays.sort(out_order, (a,b) -> compare(a,b,false,bt));
        int ptr1 = 0; // 현재 입실 대상
        int ptr2 = 0; // 퇴실(+청소 완료) 확인 대상
        for(ptr1=0;ptr1<in_order.length;ptr1++) {
            int basetime = bt[in_order[ptr1]][0];
            if(ptr1>0) {
                while(ptr2 < out_order.length) {
                    if(bt[out_order[ptr2]][1] <= basetime) {
                        rooms--;
                        ptr2++;
                    } else break;
                }
            }
            rooms++;
            if(answer < rooms) answer = rooms;
        }
        return answer;
    }
    
    private int parseTime(String time) {
        int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3,5));
        return h*60+m;
    }
    
    private int compare(int a, int b, boolean in_first, int[][] bt) {
        int first = in_first? 0 : 1;
        int second = 1-first;
        if(bt[a][first] == bt[b][first]) return bt[a][second]-bt[b][second];
        return bt[a][first]-bt[b][first];
    }
}
