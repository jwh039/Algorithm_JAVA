package Programmers.q154540;

// 무인도 여행

import java.util.*;

class Solution_AI {
    int r, c;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int[] solution(String[] maps) {
        r = maps.length;
        c = maps[0].length();
        visited = new boolean[r][c];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 바다가 아니고, 아직 방문하지 않은 땅이라면 DFS 시작
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    list.add(dfs(i, j, maps));
                }
            }
        }

        if (list.isEmpty()) return new int[]{-1};

        // 오름차순 정렬 후 int[] 배열로 변환
        return list.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    private int dfs(int x, int y, String[] maps) {
        // 범위를 벗어나거나, 이미 방문했거나, 바다('X')인 경우 0 반환
        if (x < 0 || x >= r || y < 0 || y >= c || visited[x][y] || maps[x].charAt(y) == 'X') {
            return 0;
        }

        visited[x][y] = true;
        int sum = maps[x].charAt(y) - '0'; // 현재 칸의 식량 값

        // 상하좌우 탐색하며 합산
        for (int i = 0; i < 4; i++) {
            sum += dfs(x + dx[i], y + dy[i], maps);
        }

        return sum;
    }
}
