package Programmers.q87390;

// n^2 배열 자르기

class Solution {
    // 2차원 배열에서, i행 j열의 값은 max(i,j)
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1L)];
        for(long i=left;i<=right;i++) {
            answer[(int)(i-left)] = (int)valueOfIndex(i, n);
        }
        return answer;
    }
    
    // 1차원 배열 index -> 2차원 배열 index -> 배열 값(max(i,j))
    private long valueOfIndex(long index, int n) {
        long row = (index)/(long)n + 1;
        long column = (index)%(long)n + 1;
        return (row>column)? row : column;
    }
}