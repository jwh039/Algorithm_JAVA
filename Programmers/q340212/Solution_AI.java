package Programmers.q340212;

public class Solution_AI {
    public int solution(int[] diffs, int[] times, long limit) {
        // 숙련도(level)의 최소와 최대 범위 설정
        int left = 1;
        int right = 100000; // diffs[i]의 최댓값
        
        // 문제 조건 중 diffs의 실제 최댓값으로 범위를 좁혀도 좋습니다.
        for (int diff : diffs) {
            if (diff > right) right = diff;
        }

        int answer = right;

        // 이분 탐색 시작
        while (left <= right) {
            int mid = left + (right - left) / 2; // 현재 테스트할 숙련도 (level)

            if (canSolve(diffs, times, limit, mid)) {
                // 현재 숙련도로 가능하므로, 더 작은 숙련도가 있는지 왼쪽 구간 탐색
                answer = mid;
                right = mid - 1;
            } else {
                // 현재 숙련도로 불가능하므로, 숙련도를 높여서 오른쪽 구간 탐색
                left = mid + 1;
            }
        }

        return answer;
    }

    // 주어진 숙련도(level)로 제한 시간(limit) 내에 퍼즐을 다 풀 수 있는지 확인하는 헬퍼 함수
    private boolean canSolve(int[] diffs, int[] times, long limit, int level) {
        long totalTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int timeCur = times[i];

            if (diff <= level) {
                // 틀리지 않고 바로 통과
                totalTime += timeCur;
            } else {
                // (diff - level)번 틀림
                int countWrong = diff - level;
                int timePrev = times[i - 1]; // i=0일 때는 diffs[0]=1이므로 무조건 diff <= level에 걸려 이쪽으로 오지 않음
                
                // 틀릴 때마다 사용하는 시간: (time_cur + time_prev) * 틀린 횟수 + 마지막 성공 시간(time_cur)
                totalTime += (long) countWrong * (timeCur + timePrev) + timeCur;
            }

            // 탐색 중간이라도 이미 제한 시간을 초과했다면 더 볼 필요 없이 false 리턴
            if (totalTime > limit) {
                return false;
            }
        }

        return true;
    }
}
