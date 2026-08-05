package Programmers.q388352;

// 비밀 코드 해독

class Solution_AI {
    int answer = 0;

    public int solution(int n, int[][] q, int[] ans) {
        int[] comb = new int[5];
        dfs(1, 0, n, q, ans, comb);
        return answer;
    }

    private void dfs(int start, int depth, int n, int[][] q, int[] ans, int[] comb) {
        if (depth == 5) {
            if (check(q, ans, comb)) {
                answer++;
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            comb[depth] = i;
            dfs(i + 1, depth + 1, n, q, ans, comb);
        }
    }

    private boolean check(int[][] q, int[] ans, int[] comb) {
        for (int i = 0; i < q.length; i++) {
            int matchCount = 0;
            // 두 배열이 오름차순 정렬되어 있으므로 투 포인터로 일치 개수 계산
            int p1 = 0, p2 = 0;
            while (p1 < 5 && p2 < 5) {
                if (q[i][p1] == comb[p2]) {
                    matchCount++;
                    p1++;
                    p2++;
                } else if (q[i][p1] < comb[p2]) {
                    p1++;
                } else {
                    p2++;
                }
            }
            if (matchCount != ans[i]) return false;
        }
        return true;
    }
}
