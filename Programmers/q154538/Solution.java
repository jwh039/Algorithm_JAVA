package Programmers.q154538;

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] memo = new int[y+1];
        for(int i=1;i<=y;i++) memo[i] = -1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,0));
        memo[x] = 0;
        while(!q.isEmpty()) {
            Node node = q.poll();
            int idx = node.index;
            int cnt = node.count;
            if(idx+n<=y && memo[idx+n] == -1) {
                memo[idx+n] = cnt+1;
                q.add(new Node(idx+n, cnt+1));
            }
            if(2*idx<=y && memo[2*idx] == -1) {
                memo[2*idx] = cnt+1;
                q.add(new Node(2*idx, cnt+1));
            }
            if(3*idx<=y && memo[3*idx] == -1) {
                memo[3*idx] = cnt+1;
                q.add(new Node(3*idx, cnt+1));
            }
        }
        return memo[y];
    }
    
    private static class Node {
        int index;
        int count;
        
        Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}