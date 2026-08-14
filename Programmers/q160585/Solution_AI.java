package Programmers.q160585;

// 혼자서 하는 틱택토

import java.util.*;

class Solution_AI {
    public int solution(String[] board) {
        Set<Integer> Os = new HashSet<>();
        Set<Integer> Xs = new HashSet<>();
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(board[i].charAt(j) == 'O') {
                    Os.add(3*i+j);
                } else if(board[i].charAt(j) == 'X') {
                    Xs.add(3*i+j);
                }
            }
        }
        return possible(Os,Xs);
    }
    
    private int possible(Set<Integer> Os, Set<Integer> Xs) {
        if(Os.size() != Xs.size() && Os.size() != Xs.size()+1) return 0;
        return recur(Os,Xs,new HashSet<Integer>(), new HashSet<Integer>())? 1 : 0;
    }
    
    private boolean recur(Set<Integer> Os, Set<Integer> Xs, Set<Integer> boardO, Set<Integer> boardX) {
        if(Os.isEmpty() && Xs.isEmpty()) return true;
        
        boolean found = false;
        Set<Integer> copyO = new HashSet<>(Os);
        Set<Integer> copyX = new HashSet<>(Xs);
        
        if(boardO.size() == boardX.size()) {
            // 선공 (O)
            for(Integer i : Os) {
                // 게임이 끝났는데 아직 배치해야 할 남은 돌이 있다면 잘못된 경로이므로 넘어감
                if(gameEnds(boardO, i)) {
                    if(Os.size() != 1 || Xs.size() != 0) continue;
                }
                copyO.remove(i);
                boardO.add(i);
                
                if (recur(copyO, Xs, boardO, boardX)) return true; // 가능한 경로를 하나라도 찾으면 즉시 true 반환
                
                copyO.add(i);
                boardO.remove(i);
            }
        } else {
            // 후공 (X)
            for(Integer i : Xs) {
                // 게임이 끝났는데 아직 배치해야 할 남은 돌이 있다면 잘못된 경로이므로 넘어감
                if(gameEnds(boardX, i)) {
                    if(Os.size() != 0 || Xs.size() != 1) continue;
                }
                copyX.remove(i);
                boardX.add(i);
                
                if (recur(Os, copyX, boardO, boardX)) return true; // 가능한 경로를 하나라도 찾으면 즉시 true 반환
                
                copyX.add(i);
                boardX.remove(i);
            }
        }
        return false;
    }
    
    private boolean gameEnds(Set<Integer> set, int next) {
        Set<Integer> copy = new HashSet<>(set);
        int row = next/3;
        int col = next%3;
        copy.add(next);
        
        if(copy.contains(3*row) && copy.contains(3*row+1) && copy.contains(3*row+2)) { 
            return true;
        }
        if(copy.contains(col) && copy.contains(3+col) && copy.contains(6+col)) { 
            return true;
        }
        if(row == col) {
            if(copy.contains(0) && copy.contains(4) && copy.contains(8)) { 
                return true;
            }
        }
        if(row+col == 2) {
            if(copy.contains(2) && copy.contains(4) && copy.contains(6)) { 
                return true;
            }
        }
        return false;
    }
}
