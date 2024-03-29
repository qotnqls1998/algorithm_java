import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] currentStage = new double[N+1];
        double[] totalUser = new double[N+1];
        List<double[]> fail = new ArrayList<double[]>();
        
        for (int i=0; i<stages.length; i++) {
            currentStage[stages[i]-1]++; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
            for (int j=0; j<stages[i]; j++) {
                totalUser[j]++; // 스테이지에 도달한 플레이어 수
            }
        }
        
        // 스테이지별 실패율 추출
        for (int i=0; i<N; i++) {
            if(totalUser[i] == 0) {
                fail.add(new double[]{i,0});
            } else {
                fail.add(new double[]{i,currentStage[i] / totalUser[i]});
            }
        }
        fail.sort((a,b)->Double.compare(b[1],a[1]));
       
        
        for (int i=0; i<fail.size(); i++) {
            answer[i] = (int)fail.get(i)[0]+1;
        }
        
        return answer;
    }
}