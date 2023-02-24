package week5;

import java.util.Scanner;

public class B6987_월드컵 {
	static int[][] win,make;
	
	static int[] teamA= {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int[] teamB= {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		for(int i=0;i<4;i++) {
			win = new int[6][3];//매 월드컵 마다 초기화
			make=new int[6][3];
			// 0-승 1-무 2 -패
			for(int j=0;j<6;j++) {
				for(int k=0;k<3;k++) {
					win[j][k]=sc.nextInt();
				}
			}

			game(0);
			System.out.print(ans+" ");
		}
		System.out.println();
	}
	private static void game(int Idx) {
		//모든 승패가 기록된다면, input과 일치하는 지 확인!
		//일치하지 않으면... 승패 다시 바꿔서 확인. ....
		if(Idx==15) {
			if(check()) ans = 1;
			return;
		}
		int team1=teamA[Idx];
		int team2=teamB[Idx];
		
		//team1 승
		make[team1][0]++;
		make[team2][2]++;
		game(Idx+1); 
		make[team1][0]--;
		make[team2][2]--;
		
		//team2 승
		make[team1][2]++;
		make[team2][0]++;
		game(Idx+1); 
		make[team1][2]--;
		make[team2][0]--;
		
		// 무승
		make[team1][1]++;
		make[team2][1]++;
		game(Idx+1); 
		make[team1][1]--;
		make[team2][1]--;
		
		
	}
	private static boolean check() {
		for(int i=0;i<6;i++) {
			for(int j=0;j<3;j++) {
				if(win[i][j]==make[i][j])
					return true;
			}
		}
		return false;
	}
	
	
}
