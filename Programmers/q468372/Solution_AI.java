package Programmers.q468372;

import java.util.HashMap;

class Solution_AI {
    private HashMap<Long, Integer> memo;
    private long maxDist;
    private long maxSplit;

    public int solution(int dist_limit, int split_limit) {
        memo = new HashMap<>();
        this.maxDist = dist_limit;
        this.maxSplit = split_limit;

        // 초기 상태: 현재까지의 분배도 1, 현재 레벨의 노드 수 1, 사용한 분배 노드 0
        return getLeaves(1, 1, 0);
    }

    private int getLeaves(long split, long currentNodes, long dist) {
        // 기저 조건: 분배도나 분배 노드 수가 제한을 넘으면 불가능한 경로
        if (split > maxSplit || dist > maxDist) return 0;

        // 이미 계산한 적이 있는 분배도 상태라면 반환
        if (memo.containsKey(split)) {
            return memo.get(split);
        }

        // [핵심] 현재 레벨에서 더 이상 전체 확장을 하지 않고, '남은 분배 노드 기회'를 영끌하는 경우
        // 남은 분배 노드 기회(maxDist - dist)와 현재 노드 수(currentNodes) 중 작은 값만큼만 자식을 2개 또는 3개로 쪼갤 수 있음
        long remainingDist = maxDist - dist;
        long choice = Math.min(currentNodes, remainingDist);
        
        // choice만큼 자식을 3개로 쪼개는 게 무조건 이득 (노드가 1개당 2개씩 늘어나므로)
        // 단, 3배로 쪼갰을 때의 분배도(split * 3)가 maxSplit 이하일 때만 가능
        int baseLeaves = (int) currentNodes;
        if (choice > 0 && split * 3 <= maxSplit) {
            baseLeaves += choice * 2; // 자식이 3개가 되면 기존 1개에서 2개가 추가됨
        } else if (choice > 0 && split * 2 <= maxSplit) {
            baseLeaves += choice * 1; // 자식이 2개가 되면 기존 1개에서 1개가 추가됨
        }
        
        int res = baseLeaves;

        // 다음 레벨 전체를 2배로 확장하는 경우
        if (dist + currentNodes <= maxDist && split * 2 <= maxSplit) {
            res = Math.max(res, getLeaves(split * 2, currentNodes * 2, dist + currentNodes));
        }

        // 다음 레벨 전체를 3배로 확장하는 경우
        if (dist + currentNodes <= maxDist && split * 3 <= maxSplit) {
            res = Math.max(res, getLeaves(split * 3, currentNodes * 3, dist + currentNodes));
        }

        memo.put(split, res);
        return res;
    }
}