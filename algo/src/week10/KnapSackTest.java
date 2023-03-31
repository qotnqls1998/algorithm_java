package ssafyclass;

import java.util.Scanner;

public class KnapSackTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		
		int[][] D = new int[N+1][W+1];
		//초기값 세팅 : int[][] 배열의 자동초기화를 이용
		
		
		for(int i=1;i<=N;i++) { //물건 갯수만큼 반복
			
			for(int j=1 ; j<=W ; j++) {//1부터 최대무게인 W까지
				if(weights[i]>j) {//만약 현재값이 최대무게j보다 크다면 
					D[i][j]= D[i-1][j];
				}else {
					D[i][j]= Math.max( D[i-1][j], profits[i]+D[i-1][j-weights[i]]);
				}
			}
			
		}
		
		System.out.println(D[N][W]);
	}
}
