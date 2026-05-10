package Baekjoon.Mathematics.q1212;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        if(str.equals("0")) {
            System.out.println(0);
            return;
        }
        for(int i=0;i<str.length();i++) {
            switch(str.charAt(i)) {
                case '0':
                    sb.append((i==0)? "" : "000");
                    break;
                case '1':
                    sb.append((i==0)? "1" : "001");
                    break;
                case '2':
                    sb.append((i==0)? "10" : "010");
                    break;
                case '3':
                    sb.append((i==0)? "11" : "011");
                    break;
                case '4':
                    sb.append("100");
                    break;
                case '5':
                    sb.append("101");
                    break;
                case '6':
                    sb.append("110");
                    break;
                case '7':
                    sb.append("111");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}