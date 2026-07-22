package Programmers.q172928;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x=-1;
        int y=-1;
        final int xMax = park.length-1;
        final int yMax = park[0].length()-1;
        int[] dx = {-1,0,0,1}; // N, W, E, S
        int[] dy = {0,-1,1,0};
        boolean brk = false;
        for(int i=0;i<park.length;i++) {
            if(brk) break;
            for(int j=0;j<park[0].length();j++) {
                if(park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    brk = true;
                    break;
                }
            }
        }
        for(int i=0;i<routes.length;i++) {
            char dir = routes[i].charAt(0);
            int n = routes[i].charAt(2) - '0';
            int moveX = 0;
            int moveY = 0;
            if(dir == 'N') {
                moveX = dx[0];
                moveY = dy[0];
            } else if(dir == 'W') {
                moveX = dx[1];
                moveY = dy[1];
            } else if(dir == 'E') {
                moveX = dx[2];
                moveY = dy[2];
            } else if(dir == 'S') {
                moveX = dx[3];
                moveY = dy[3];
            }
            boolean canMove = true;
            int tempX = x;
            int tempY = y;
            for(int m=0;m<n;m++) {
                tempX += moveX;
                tempY += moveY;
                if(tempX < 0 || tempX > xMax || tempY < 0 || tempY > yMax) {
                    canMove = false;
                    break;
                }
                if(park[tempX].charAt(tempY) == 'X') {
                    canMove = false;
                    break;
                }
            }
            if(canMove) {
                x = tempX;
                y = tempY;
            }
        }
        int[] answer = new int[2];
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}
