package algo.baek;

import java.util.Scanner;

public class b15649_nm {
	static int n;
	static int m;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		m= sc.nextInt();
		
		numbers = new int[m];
		isSelected = new boolean[n+1];
		perm(0);
	}
	
	private static void perm(int cnt) {
		if(cnt==m) {//뽑은 수가 목표수가 되었다면 멈춤
			for(int i=0;i<m;i++)
				System.out.print(numbers[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=1;i<=n;i++) {
			//중복체크
			if(isSelected[i])continue;
			numbers[cnt] = i;
			isSelected[i]=true;
			perm(cnt+1);	 
			isSelected[i]=false;
		}
	}
}
