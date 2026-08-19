package Programmers.q258711;

// 도넛과 막대 그래프

import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int nodeMax = 1;
        Set<Integer> nodeSet = new HashSet<>();
        for(int i=0;i<edges.length;i++) {
            int max = (edges[i][0]>edges[i][1])? edges[i][0]:edges[i][1];
            if(nodeMax < max) nodeMax = max;
        }
        int[][] outin = new int[nodeMax+1][2];
        for(int i=0;i<edges.length;i++) {
            int out = edges[i][0];
            int in = edges[i][1];
            outin[out][0]++;
            outin[in][1]++;
            nodeSet.add(out);
            nodeSet.add(in);
        }
        int newPoint = 0;
        for(int i=1;i<outin.length;i++) {
            if(outin[i][0]>=2 && outin[i][1]==0) {
                newPoint = i;
                break;
            }
        }
        int totalGraph = outin[newPoint][0];
        for(int i=0;i<edges.length;i++) {
            if(edges[i][0] == newPoint) {
                outin[edges[i][1]][1]--;
            }
        }
        int[] answer = new int[4];
        answer[0] = newPoint;
        for(int i=1;i<outin.length;i++) {
            if(i==newPoint) continue;
            if(!nodeSet.contains(i)) continue;
            if(outin[i][1] == 0) answer[2]++;
            else if(outin[i][1] == 2) answer[3]++;
        }
        answer[1] = totalGraph - answer[2] - answer[3];
        return answer;
    }
}
