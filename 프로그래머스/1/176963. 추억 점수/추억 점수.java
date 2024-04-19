import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int n = photo.length;
        int[] answer = new int[n];
        
        for(int i=0;i<n;i++){
            int m = photo[i].length;
            int sum = 0;
            int idx = 0;
            
            for(int j=0;j<m;j++){
                 for(int k=0;k<name.length;k++){
                     if( photo[i][j].equals(name[k]) ){
                         idx = k;
                         sum += yearning[idx];
                         break;
                     }
                 }
                
            }
            answer[i] = sum;
            
        }
        
        return answer;
    }
}