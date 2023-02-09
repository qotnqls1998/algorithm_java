package algo.baek;

import java.util.Scanner;

public class b6603_lotto {
	static int[] numbers; //출력할거
	static int tc = -1;
	static int[] cards;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			tc = sc.nextInt(); 
			if(tc==0) break;
			
			cards = new int[tc];
			numbers= new int[6];
			
			for(int i=0;i<tc;i++) {
				cards[i]=sc.nextInt();
			}
			//여기서 부터 조합!!
			comb(0,0);
			System.out.println();
		}	
	}
	private static void comb(int cnt, int start) {
		if(cnt==6) {
			for(int i=0;i<6;i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start ;i<cards.length;i++) {
			numbers[cnt] = cards[i];
			comb(cnt+1,i+1);
		}
	}
	
}
