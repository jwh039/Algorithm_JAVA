package Programmers.q388354;

// 홀짝트리

import java.util.*;

class Solution {
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];
        
        List<Integer>[] adj = new ArrayList[1000001];
        for(int i=0;i<nodes.length;i++) {
            adj[nodes[i]] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj[a].add(b);
            adj[b].add(a);
        }
        boolean[] visited = new boolean[1000001];
        
        List<List<Boolean>> forest = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<1000001;i++) {
            if(visited[i] || adj[i]==null) continue;
            List<Boolean> current_tree = new ArrayList<>();
            forest.add(current_tree);
            
            queue.add(i);
            visited[i] = true;
            while(!queue.isEmpty()) {
                int current = queue.poll();
                int size = adj[current].size();
                // true이면 홀/짝 노드, false면 역홀/역짝 노드
                current_tree.add((current+size)%2 == 0);
                for(int node : adj[current]) {
                    if(visited[node]) continue;
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }
        
        for(List<Boolean> tree : forest) {
            int true_count = 0;
            int false_count = 0;
            for(boolean b : tree) {
                if(b) true_count++;
                else false_count++;
            }
            if(true_count == 1) answer[0]++;
            if(false_count == 1) answer[1]++;
        }
        
        return answer;
    }
}