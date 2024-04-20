import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            int num = numbers[i];
            //스택이 비지 않았을때 
            while(!st.isEmpty()){
                if(num < st.peek()){
                    answer[i] = st.peek();
                    break;
                }
                else{
                    st.pop();
                }
            }
            //스택이 비었을때 - 더이상 큰 수가 없는 경우
            if(st.isEmpty()){
                 answer[i] = -1;
            }
            st.add(num);
        }
        
        
        
        return answer;
    }
}