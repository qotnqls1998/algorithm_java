package algo.baek;

import java.util.Scanner;

public class b15686_치킨배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		int ch_cnt =0;
		int home_cnt =0;
		int sum=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==1)home_cnt++;
				if(map[i][j]==2)ch_cnt++;
			}
		}
		
		
		//m개를 골랐을때 가장 작은 도시의 치킨거리 구하기
		// 1. 1 인것들 중에서 m개를 고른다.
		
		
		// 2. 그 m개와의 도시의 치킨거리를 구하고 , for문을 돌면서 min 값을 저장해놓는다

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					
				}
				
			}
		}
		
		// 3. min값이 들어간 도시의 치킨 거리의 최솟값 
		
	}
}
