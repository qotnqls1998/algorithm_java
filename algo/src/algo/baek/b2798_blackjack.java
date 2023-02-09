package algo.baek;

import java.util.Arrays;
import java.util.Scanner;

public class b2798_blackjack {
	static int n;
	static int m;
	static int[] card;
	static int max;
	static int sum = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n  = sc.nextInt();
		m = sc.nextInt();
		int[] card = new int[n];
		
		for(int i=0;i<n;i++) {
			card[i]=sc.nextInt();
		}
		
		//반복문 버전
		max=0;
		/*
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(i!=j && j!=k && i!=k) {
						sum = card[i]+card[j]+card[k];
						if(max<sum && sum<=m)
							max=sum;
					}
				}
			}
		}*/
		com(0,1); 
		System.out.println(max);
	}
	
	//조합을써서 합을 ㄷ구하공 합중에 젤 큰거를 출력
	//조합 버전
	
	private static void com(int cnt, int start) {
		if(cnt==3) {
			System.out.println(Arrays.toString(card));
			return;
		}
		
		for(int i=start ;i<=6;i++) {
			card[cnt] =i;
			com(cnt+1,i+1);
		}
	}	
}

