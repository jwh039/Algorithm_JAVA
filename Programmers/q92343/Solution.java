package Programmers.q92343;

// 양과 늑대

import java.util.*;

class Solution {
    List<Integer>[] childof;
    
    public int solution(int[] info, int[][] edges) {
        childof = new ArrayList[info.length];
        for(int i=0;i<edges.length;i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            if(childof[parent] == null) childof[parent] = new ArrayList<>();
            childof[parent].add(child);
        }
        int[] result = go(info, 0, 1, 0, clone(childof[0]));
        return result[0];
    }
    
    private int[] go(int[] info, int current, int sheep, int wolf, List<Integer> candidates) {
        if(candidates == null || candidates.size() == 0) {
            return new int[]{sheep, wolf};
        }
        int[] result = new int[]{sheep, wolf};
        for(int c : candidates) {
            if(info[c] == 1 && sheep <= wolf+1) continue;
            List<Integer> candidates_param = clone(candidates);
            candidates_param.remove((Integer)c);
            if(childof[c] != null) append(candidates_param, childof[c]);
            int[] temp;
            if(info[c] == 0) {
                temp = go(info, c, sheep+1, wolf, candidates_param);
            } else {
                temp = go(info, c, sheep, wolf+1, candidates_param);
            }
            if(result == null || result[0] < temp[0]) result = temp;
        }
        return result;
    }
    
    private List<Integer> clone(List<Integer> origin) {
        List<Integer> result = new ArrayList<>();
        for(int i : origin) result.add(i);
        return result;
    }
    
    private void append(List<Integer> origin, List<Integer> addition) {
        for(int i : addition) origin.add(i);
    }
}