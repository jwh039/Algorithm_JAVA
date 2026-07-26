package Programmers.q92342;

// 양궁대회

class Solution_AI {
    int[] answer = new int[]{-1};
    int maxDiff = -1;
    
    public int[] solution(int n, int[] info) {
        // Ryan의 화살 배치를 기록할 배열 (10점부터 0점까지 인덱스 0~10)
        int[] ryan = new int[11];
        
        dfs(0, n, info, ryan);
        
        return answer;
    }
    
    private void dfs(int idx, int arrows, int[] info, int[] ryan) {
        // Base Case: 11개 과녁(10점~0점)을 모두 고려했거나 화살을 다 쓴 경우
        if (idx == 11) {
            // 남은 화살이 있다면 모두 0점(인덱스 10)에 쏩니다.
            ryan[10] += arrows;
            
            // 점수 계산 및 최댓값 갱신 Check
            checkScore(info, ryan);
            
            // 백트래킹을 위해 0점에 쐈던 남은 화살을 다시 되돌려 놓습니다.
            ryan[10] -= arrows;
            return;
        }
        
        // Option 1: 해당 과녁(10 - idx 점)을 라이언이 가져오는 경우
        // 어피치보다 1발 더 많이 쏠 수 있는 화살이 남아있어야 함
        int need = info[idx] + 1;
        if (arrows >= need) {
            ryan[idx] = need;
            dfs(idx + 1, arrows - need, info, ryan);
            ryan[idx] = 0; // 원복
        }
        
        // Option 2: 해당 과녁을 포기하는 경우 (0발 쏘고 다음 과녁으로 진행)
        dfs(idx + 1, arrows, info, ryan);
    }
    
    private void checkScore(int[] info, int[] ryan) {
        int apeachScore = 0;
        int ryanScore = 0;
        
        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && ryan[i] == 0) continue;
            
            if (ryan[i] > info[i]) {
                ryanScore += (10 - i);
            } else {
                apeachScore += (10 - i);
            }
        }
        
        int diff = ryanScore - apeachScore;
        
        // 라이언이 이긴 경우에만
        if (diff > 0) {
            if (diff > maxDiff) {
                maxDiff = diff;
                answer = ryan.clone();
            } else if (diff == maxDiff) {
                // 점수 차이가 같을 때는 낮은 점수를 더 많이 맞힌 쪽을 선택
                if (isBetter(ryan, answer)) {
                    answer = ryan.clone();
                }
            }
        }
    }
    
    // 가장 낮은 점수를 더 많이 맞혔는지 비교하는 함수
    private boolean isBetter(int[] current, int[] best) {
        for (int i = 10; i >= 0; i--) {
            if (current[i] > best[i]) return true;
            if (current[i] < best[i]) return false;
        }
        return false;
    }
}