package Programmers.q84512;

// 모음사전

class Solution {
    public int solution(String word) {
        int answer = 1;
        String current = "A";
        while(!current.equals(word)) {
            current = next(current);
            answer++;
        }
        return answer;
    }
    
    private String next(String word) {
        if(word.equals("UUUUU")) return null;
        if(word.length() < 5) return word + "A";
        for(int i=4;i>=0;i--) {
            if(word.charAt(i) == 'U') continue;
            String base = (i>0)? word.substring(0,i) : "";
            switch(word.charAt(i)) {
                case 'A':
                    return base + "E";
                case 'E':
                    return base + "I";
                case 'I':
                    return base + "O";
                case 'O':
                    return base + "U";
                default:
                    return null;
            }
        }
        return null;
    }
}