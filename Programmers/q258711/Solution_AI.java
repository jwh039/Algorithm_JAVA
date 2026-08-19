package Programmers.q258711;

// 도넛과 막대 그래프

class Solution_AI {
    public int[] solution(int[][] edges) {
        int maxNode = 0;
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }

        // [0]: out-degree, [1]: in-degree
        int[][] outin = new int[maxNode + 1][2];
        for (int[] edge : edges) {
            outin[edge[0]][0]++;
            outin[edge[1]][1]++;
        }

        int newPoint = 0;
        for (int i = 1; i <= maxNode; i++) {
            // 생성된 정점: out-degree >= 2, in-degree == 0
            if (outin[i][0] >= 2 && outin[i][1] == 0) {
                newPoint = i;
                break;
            }
        }

        int totalGraph = outin[newPoint][0];
        int stickGraph = 0;
        int figureEightGraph = 0;

        for (int i = 1; i <= maxNode; i++) {
            if (i == newPoint) continue;

            // 1. 막대 그래프: out-degree가 0인 정점 (막대 1개당 무조건 끝점 1개 존재)
            // (in-degree 조건이나 차감 로직 없이 out == 0 만으로 정점 존재 유무와 막대 끝점을 한 번에 판별)
            if (outin[i][0] == 0 && outin[i][1] > 0) {
                stickGraph++;
            } 
            // 2. 8자 그래프: out-degree가 2인 정점 (8자 모양의 중심점)
            else if (outin[i][0] == 2) {
                figureEightGraph++;
            }
        }

        int donutGraph = totalGraph - stickGraph - figureEightGraph;

        return new int[]{newPoint, donutGraph, stickGraph, figureEightGraph};
    }
}
