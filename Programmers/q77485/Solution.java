package Programmers.q77485;

// 행렬 테두리 회전하기

class Solution {
    int[][] matrix;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        matrix = new int[rows][columns];
        int count = 1;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                matrix[i][j] = count++;
            }
        }
        for(int i=0;i<queries.length;i++) {
            int[] query = new int[]{queries[i][0]-1,queries[i][1]-1,queries[i][2]-1,queries[i][3]-1};
            answer[i] = rotation(query);
        }
        return answer;
    }
    
    // queries의 index는 0-base
    private int rotation(int[] queries) {
        int dir = 0;
        int cx = queries[0];
        int cy = queries[1];
        int temp = matrix[cx][cy];
        int res = temp;
        while(dir < 4) {
            int nx = cx+dx[dir];
            int ny = cy+dy[dir];
            if(nx<queries[0] || ny<queries[1] || nx>queries[2] || ny>queries[3]) {
                dir++;
                continue;
            }
            if(res > matrix[cx][cy]) res = matrix[cx][cy];
            if(nx == queries[0] && ny == queries[1]) {
                matrix[cx][cy] = temp;
                break;
            }
            matrix[cx][cy] = matrix[nx][ny];
            cx = nx;
            cy = ny;
        }
        return res;
    }
}