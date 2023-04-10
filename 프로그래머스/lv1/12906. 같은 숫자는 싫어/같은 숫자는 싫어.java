import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q1 = new LinkedList<>();
        
        for(int i=0;i<arr.length;i++){
            q.add(arr[i]);
        }
        //첫 비교대상
       int tmp = q.poll();
        
        while(!q.isEmpty()){
            int tmp1 = q.poll();
            
            if(tmp!=tmp1){
                q1.add(tmp);
            }
            if(q.size()==0){
                q1.add(tmp1);
            }
            tmp = tmp1;
        }
        //System.out.println(q1.size());
        answer=new int[q1.size()];
        
        int i=0;
        while(!q1.isEmpty()){
            answer[i]=q1.poll();
            i++;
        }
        return answer;
    }
    
}