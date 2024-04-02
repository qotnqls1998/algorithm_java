import java.lang.*;
import java.io.*;
import java.util.*;
    
class Solution {
    static int number;
    static int[] arr;
    static int dep;
    static int sum;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        //선언
        arr = new int[numbers.length];
        number = target; 
        arr = numbers;
        
        dfs(0, 0);
        
        return answer;
    }
    private void dfs(int dep, int sum){
        
        //5개 다봤으면 돌아가
        if(dep==arr.length){
           if(number == sum) answer++;
        }
        else{
            dfs(dep+1,sum+arr[dep]);
            dfs(dep+1, sum-arr[dep]);
        }
    }
}
