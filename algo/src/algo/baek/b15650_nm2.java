package algo.baek;

import java.util.Scanner;

public class b15650_nm2 {
		static int n;
		static int m;
		static int[] numbers;
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			n= sc.nextInt();
			m= sc.nextInt();		
			numbers = new int[m];
	
			comb(0,1);
		}
		
		private static void comb(int cnt, int start) {
			if(cnt==m) {//뽑은 수가 목표수가 되었다면 멈춤
				for(int i=0;i<m;i++)
					System.out.print(numbers[i]+" ");
				System.out.println();
				return;
			}
			for(int i=start;i<=n;i++) {
				numbers[cnt] = i;
				comb(cnt+1,i+1);	 
			}
		}
}

