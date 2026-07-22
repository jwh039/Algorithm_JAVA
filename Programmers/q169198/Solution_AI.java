package Programmers.q169198;

class Solution_AI {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            int minDistanceSquared = Integer.MAX_VALUE;

            if (!(startY == targetY && startX > targetX)) {
                int dist = getDistanceSquared(startX, startY, -targetX, targetY);
                minDistanceSquared = Math.min(minDistanceSquared, dist);
            }

            if (!(startY == targetY && startX < targetX)) {
                int dist = getDistanceSquared(startX, startY, 2 * m - targetX, targetY);
                minDistanceSquared = Math.min(minDistanceSquared, dist);
            }

            if (!(startX == targetX && startY > targetY)) {
                int dist = getDistanceSquared(startX, startY, targetX, -targetY);
                minDistanceSquared = Math.min(minDistanceSquared, dist);
            }

            if (!(startX == targetX && startY < targetY)) {
                int dist = getDistanceSquared(startX, startY, targetX, 2 * n - targetY);
                minDistanceSquared = Math.min(minDistanceSquared, dist);
            }

            answer[i] = minDistanceSquared;
        }

        return answer;
    }

    private int getDistanceSquared(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}