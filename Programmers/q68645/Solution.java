package Programmers.q68645;

// 삼각 달팽이

class Solution {
    public int[] solution(int n) {
        final int MAX = n*(n+1)/2;
        int[][] memo = new int[n][n];
        int[] dx = {1,0,-1};
        int[] dy = {0,1,-1};
        int currentDir = 0;
        int currentX = 0;
        int currentY = 0;
        int count;
        for(count = 1;count<=MAX;count++) {
            memo[currentX][currentY] = count;
            int tempX = currentX + dx[currentDir];
            int tempY = currentY + dy[currentDir];
            if(tempX < 0 || tempY < 0 || tempX >= n || tempY >= n || memo[tempX][tempY] != 0) {
                currentDir = (currentDir+1) % 3;
                tempX = currentX + dx[currentDir];
                tempY = currentY + dy[currentDir];
            }
            currentX = tempX;
            currentY = tempY;
        }
        int[] answer = new int[MAX];
        count = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++) {
                answer[count++] = memo[i][j];
            }
        }
        return answer;
    }
}