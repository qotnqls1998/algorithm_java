package algo.baek;

import java.util.Scanner;

public class b2961_food {
	static int[] sin;
	static int[] ssun;
	static int[] sin_sum;
	static int[] ssun_sum;
    static boolean[] isSelected;  //각 원소가 부분집합의 구성에 포함되는지 여부
    static int n;
    static int min=100000000;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//신맛은 곱. 쓴맛은 합
		n=sc.nextInt(); //재료의 개수
		
		//초기화
		sin = new int[n];
		ssun = new int[n];
		
		sin_sum = new int[n];
		ssun_sum = new int[n];
		
		isSelected = new boolean[n];
		
		for(int i=0;i<n;i++) {
			sin[i] = sc.nextInt();	
			ssun[i] = sc.nextInt();
		}
		generateSubSet(0);
		System.out.println(min);
	}
	
	private static void generateSubSet(int cnt) { //cnt : 직전까지 고려된 원소 수
        if(cnt == n) {
        	int tmp1 = 1;
			int tmp2 = 0;
			
			//for문으로 현재 true 인값 다 곱하거나 더하기 
            for (int i = 0; i < n; i++) {	
            	/*
            	if(isSelected[i]) {
            		sin_sum[i]=tmp1*sin[i]; //tmp는 직전의 값 !! 바뀌기 전의 값 ... 
        			ssun_sum[i]=tmp2+ssun[i];
        				
        			tmp1 = sin_sum[i];
        			tmp2 = ssun_sum[i];
        		
            		int tmp = Math.abs(sin_sum[i]-ssun_sum[i]);
      
            		if(tmp  < min)
            			min = tmp;	
            	}*/
             	if(isSelected[i]) {
            		sin_sum[i]=tmp1*sin[i]; //tmp는 직전의 값 !! 바뀌기 전의 값 ... 
        			ssun_sum[i]=tmp2+ssun[i];
        				
        			tmp1 = sin_sum[i];
        			tmp2 = ssun_sum[i];
        		
            		int tmp = Math.abs(sin_sum[i]-ssun_sum[i]);
      
            		if(tmp  < min)
            			min = tmp;	
            	}
            }
          
            return;
        }
        
        // 현재 원소를 부분집합에 포함
        isSelected[cnt] = true;
        generateSubSet(cnt+1);
        
        // 미포함
        isSelected[cnt] = false;
        generateSubSet(cnt+1);
        
        
    }
}
