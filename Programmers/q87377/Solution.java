package Programmers.q87377;

// 교점에 별 만들기

import java.util.*;

class Solution {
    boolean validIntersection = false;
    public String[] solution(int[][] line) {
        Long xMax = null; Long xMin = null; 
        Long yMax = null; Long yMin = null;
        List<long[]> points = new ArrayList<>();
        for(int i=0;i<line.length;i++) {
            for(int j=i+1;j<line.length;j++) {
                long[] is = intersection(line[i], line[j]);
                if(validIntersection) {
                    points.add(is);
                    if(xMax == null || xMax < is[0]) xMax = is[0];
                    if(xMin == null || xMin > is[0]) xMin = is[0];
                    if(yMax == null || yMax < is[1]) yMax = is[1];
                    if(yMin == null || yMin > is[1]) yMin = is[1];
                }
            }
        }
        char[][] answerArray = new char[(int)(yMax-yMin)+1][(int)(xMax-xMin)+1];
        for(int i=0;i<answerArray.length;i++) Arrays.fill(answerArray[i],'.');
        for(int i=0;i<points.size();i++) {
            int x = (int)(points.get(i)[0] - xMin);
            int y = (int)(points.get(i)[1] - yMin);
            answerArray[answerArray.length-1-y][x] = '*';
        }
        String[] answer = new String[answerArray.length];
        for(int i=0;i<answerArray.length;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<answerArray[0].length;j++) {
                sb.append(answerArray[i][j]);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    
    private long[] intersection(int[] l1, int[] l2) {
        if((long)l1[0]*l2[1]-l1[1]*l2[0] == 0L) {
            validIntersection = false;
            return new long[]{-1};
        }
        long x1 = (long)l1[1]*l2[2]-l1[2]*l2[1];
        long y1 = (long)l1[2]*l2[0]-l1[0]*l2[2];
        long div = (long)l1[0]*l2[1]-l1[1]*l2[0];
        if(x1%div != 0 || y1%div != 0) {
            validIntersection = false;
            return new long[]{-1L};
        }
        validIntersection = true;
        return new long[]{x1/div, y1/div};
    }
}