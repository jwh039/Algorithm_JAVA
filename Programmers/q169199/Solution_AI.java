package Programmers.q169199;

// 리코쳇 로봇

import java.util.*;

class Solution_AI {
    // 상, 하, 좌, 우 방향 벡터
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        
        int startX = -1, startY = -1;
        int goalX = -1, goalY = -1;

        // 1. R(시작)과 G(목표) 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i].charAt(j);
                if (c == 'R') {
                    startX = i; startY = j;
                } else if (c == 'G') {
                    goalX = i; goalY = j;
                }
            }
        }

        // 2. BFS 준비
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        queue.add(new int[]{startX, startY, 0}); // {row, col, moves}
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];

            // 목표 지점에 도착한 경우 (BFS 특성상 최초 도달이 최단 거리)
            if (x == goalX && y == goalY) {
                return moves;
            }

            // 4방향으로 각각 벽이나 장애물을 만날 때까지 미끄러짐
            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                // 해당 방향으로 부딪힐 때까지 이동
                while (true) {
                    int nextX = nx + dx[i];
                    int nextY = ny + dy[i];

                    // 보드 범위를 벗어나거나 장애물('D')을 만나면 멈춤
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || board[nextX].charAt(nextY) == 'D') {
                        break;
                    }
                    nx = nextX;
                    ny = nextY;
                }

                // 이동을 마친 최종 위치(nx, ny)가 아직 방문 전이라면 큐에 추가
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, moves + 1});
                }
            }
        }

        // 목표 지점에 도달할 수 없는 경우
        return -1;
    }
}
