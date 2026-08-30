package Programmers.q172927;

// 광물 캐기

class Solution {
    final int[][] info = {{1,1,1}, {5,1,1}, {25,5,1}};
    int len;
    public int solution(int[] picks, String[] minerals) {
        len = picks[0]+picks[1]+picks[2];
        return recur(picks, minerals, new String[len], 0);
    }
    
    private int recur(int[] picks, String[] minerals, String[] selectedList, int selectIndex) {
        if(selectIndex >= len) {
            return work(selectedList, minerals);
        }
        int result = 99999999;
        for(int i=0;i<3;i++) {
            if(picks[i] <= 0) continue;
            picks[i]--;
            if(i==0) selectedList[selectIndex] = new String("diamond");
            else if(i==1) selectedList[selectIndex] = new String("iron");
            else if(i==2) selectedList[selectIndex] = new String("stone");
            int temp = recur(picks, minerals, selectedList, selectIndex+1);
            if(result > temp) result = temp;
            picks[i]++;
        }
        return result;
    }
    
    private int work(String[] selected, String[] minerals) {
        int result = 0;
        int idx = 0;
        for(int i=0;i<selected.length;i++) {
            int a =  -1; // 곡괭이
            if(selected[i].equals("diamond")) a = 0;
            else if(selected[i].equals("iron")) a = 1;
            else if(selected[i].equals("stone")) a = 2;
            for(int j=0;j<5;j++) {
                int b =  -1; // 광물
                if(idx >= minerals.length) return result;
                if(minerals[idx].equals("diamond")) b = 0;
                else if(minerals[idx].equals("iron")) b = 1;
                else if(minerals[idx].equals("stone")) b = 2;
                result += info[a][b];
                idx++;
            }
        }
        return result;
    }
}