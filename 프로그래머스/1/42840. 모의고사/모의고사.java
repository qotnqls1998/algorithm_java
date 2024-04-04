import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] s1 = {1,2,3,4,5};
        int[] s2 = {2,1,2,3,2,4,2,5};
        int[] s3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        int n =0;
        
        for(int i=0;i<answers.length;i++){
            if(s1[i%5] == answers[i]){
                score[0] ++;
            }
            if(s2[i%8] == answers[i]){
                score[1] ++;
            }
            if(s3[i%10] == answers[i]){
                score[2] ++;
            }
        }
        int max=0;
        for(int i=0;i<3;i++){
            if(score[i] > max){
                max = score[i];
            }
        }
        for(int i=0;i<3;i++){
            if(max == score[i]){
                   n++;
            }    
        }
        int[] answer = new int[n];
        
        int idx=0;
        for(int i=0;i<3;i++){
            if(max == score[i]){
                 System.out.println(i+1);
                 answer[idx++]=i+1;
            }    
        }
        
        return answer;
    }
}