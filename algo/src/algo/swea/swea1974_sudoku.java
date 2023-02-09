package algo.swea;

import java.util.Scanner;

public class swea1974_sudoku {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=0;t<tc;t++) {
			int[][] map = new int[9][9];
			
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					map[i][j]=sc.nextInt();
				}
			}//end input
			
			boolean isOK = true; //체크
			
			
			//행체크!!
			for(int i=0;i<9;i++) {
				boolean[] check = new boolean[10]; //체크할 숫자가 곧 배열 인덱스 1~9
				for(int j=0;j<9;j++) {
					if(check[map[i][j]]) { // 숫자가 이미 true 엿으면 ??
						isOK = false;
						break; // 퉤[ㅅ
					}
					check[map[i][j]]=true;
				
				}
			}//행체크 종료
			

			//열 체크!!
			for(int i=0;i<9;i++) {
				boolean[] check = new boolean[10]; //체크할 숫자가 곧 배열 인덱스 1~9
				for(int j=0;j<9;j++) {
					if(check[map[j][i]]) { // 숫자가 이미 true 엿으면 ??
						isOK = false;
						break; // 퉤[ㅅ
					}
					check[map[j][i]]=true;
				}
			}//열 체크 종료
			
			//박스 체크
			for(int i=0;i<9;i+=3) {
				for(int j=0;j<9;j+=3) {
					if(boxCheck(i,j,map)==false) {
						isOK = false;
					}
				}
			}
			System.out.println("#"+t+" "+(isOK? 1 :0));
		}
		
	}//main
	
	//3*3 check
	static boolean boxCheck(int si, int sj, int[][] map) {
		boolean[] check = new boolean[10]; 
			
		for(int i=si; i<si+3; i++) {		
			for(int j=sj;j<sj+3;j++) {
				if(check[map[i][j]])
					return false;
				check[map[i][j]]=true;
				}
		
			}
		return true;
		}
	}
