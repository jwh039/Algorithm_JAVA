package Programmers.q68936;

// 쿼드압축 후 개수 세기

class Solution {
    public int[] solution(int[][] arr) {
        return go(arr, 0, 0, arr.length-1, arr[0].length-1);
    }
    
    // (x1,y1)부터 (x2,y2)까지
    private int[] go(int[][] arr, int x1, int y1, int x2, int y2) {
        // 재귀 탈출 조건
        if(x1==x2 && y1==y2) {
            int value = arr[x1][y1];
            int[] result = new int[2];
            result[value]++;
            return result;
        }
        
        // 재귀 로직
        int xmid = (x1+x2)/2;
        int ymid = (y1+y2)/2;
        int[] res1 = go(arr, x1, y1, xmid, ymid);
        int[] res2 = go(arr, xmid+1, y1, x2, ymid);
        int[] res3 = go(arr, x1, ymid+1, xmid, y2);
        int[] res4 = go(arr, xmid+1, ymid+1, x2, y2);
        if(res1[0]+res2[0]+res3[0]+res4[0] == 0) {
            return new int[]{0, 1};
        } else if(res1[1]+res2[1]+res3[1]+res4[1] == 0) {
            return new int[]{1, 0};
        } else {
            int zeros = res1[0]+res2[0]+res3[0]+res4[0];
            int ones = res1[1]+res2[1]+res3[1]+res4[1];
            return new int[]{zeros, ones};
        }
    }
}
