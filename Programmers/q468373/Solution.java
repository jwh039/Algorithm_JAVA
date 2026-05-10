package Programmers.q468373;
// 바이러스 파이프

import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int n, int infection, int[][] edges, int k) {
        Set<Integer> infectionSet = new HashSet<>();
        infectionSet.add(infection);
        int one = recur(n, new HashSet<>(infectionSet), edges, k, 1, 1);
        int two = recur(n, new HashSet<>(infectionSet), edges, k, 1, 2);
        int three = recur(n, new HashSet<>(infectionSet), edges, k, 1, 3);
        int answer = (one > two)? one : two;
        if(answer < three) answer = three;
        return answer;
    }
    
    private int recur(final int n, Set<Integer> infection, int[][] edges, final int k, int now, int type) {
        if(k < now) {
            return infection.size();
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> infectionSet = new HashSet<>(infection);
        for(Integer i : infection) {
            if(visited.contains(i)) continue;
            DFS(n,infection,edges,k,now,type,i,visited,infectionSet);
        }
        int one = recur(n, new HashSet<>(infectionSet), edges, k, now+1, 1);
        int two = recur(n, new HashSet<>(infectionSet), edges, k, now+1, 2);
        int three = recur(n, new HashSet<>(infectionSet), edges, k, now+1, 3);
        int answer = (one > two)? one : two;
        if(answer < three) answer = three;
        return answer;
    }
    
    private void DFS(final int n, Set<Integer> infection, int[][] edges, final int k, int now, int type, int node, Set<Integer> visited, Set<Integer> infectionSet) {
        for(int e=0; e<edges.length; e++) {
            if(edges[e][2] == type) {
                if(edges[e][0] == node || edges[e][1] == node) {
                    int opposite = edges[e][0] + edges[e][1] - node;
                    if(!visited.contains(opposite)) {
                        infectionSet.add(opposite);
                        visited.add(opposite);
                        DFS(n,infection,edges,k,now,type,opposite,visited,infectionSet);
                    }
                }
            }
        }
    }
}