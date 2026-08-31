package Programmers.q148652;

// 유사 칸토어 비트열

class Solution_AI {
    public int solution(int n, long l, long r) {
        // [1, r] 구간의 1의 개수 - [1, l-1] 구간의 1의 개수
        return (int) (countOne(n, r) - countOne(n, l - 1));
    }

    // n단계 비트열에서 1-indexed 위치 'pos'까지 존재하는 1의 개수를 구하는 재귀 함수
    private long countOne(int n, long pos) {
        if (n == 0) {
            return pos <= 0 ? 0 : 1;
        }

        // 이전 단계(n-1) 한 블록의 길이: 5^(n-1)
        long subLen = (long) Math.pow(5, n - 1);
        // 이전 단계(n-1) 한 블록 당 1의 개수: 4^(n-1)
        long subOnes = (long) Math.pow(4, n - 1);

        // 현재 pos가 5개 구역 중 몇 번째 구역에 속하는지 (0-based: 0, 1, 2, 3, 4)
        long section = pos / subLen;
        long remainder = pos % subLen;

        // 가운데 구역(2번째, 0-based)은 전부 0으로 채워지는 구간
        if (section == 2) {
            // 앞에 있는 0, 1번 구역의 1의 개수만 합산 (2 * 4^(n-1))
            return 2 * subOnes;
        } else if (section < 2) {
            // 2번째 구역보다 앞 (0, 1번 구역)
            return section * subOnes + countOne(n - 1, remainder);
        } else {
            // 2번째 구역보다 뒤 (3, 4번 구역) -> 2번 구역(00000)을 빼고 계산 (section - 1)
            return (section - 1) * subOnes + countOne(n - 1, remainder);
        }
    }
}
