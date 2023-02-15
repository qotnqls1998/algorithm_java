package algo.baek;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b16926_배열돌리기1 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int[] dx = new int[]{-1, 1, 0, 0};//상 하 좌 우
		int[] dy = new int[]{0, 0, -1 ,1};
		
	
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		
		boolean[][] selected = new boolean[n][m];
		
	
		
		int[][] map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();		
			}
		}
		
//		//바꾸기전 
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		for(int k=0;k<1;k++) {
			queue = new LinkedList<>(); //큐는 초기화
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {	

						if(i==0 && j==0) {
							queue.add(map[i][j]); 
							map[i][j]=map[i][j+1];
							selected[i][j] = true;
						}
						//가장자리는 무조건 돈다
						else if( (i==0 && j+1<m) ) {//맨위 - 성공
							map[i][j]=map[i][j+1];
							selected[i][j] = true;
							
						}
						
						else if(j==m-1 && i+1<n) { //맨오른쪽 
							map[i][j]=map[i+1][j];
							selected[i][j] = true;
							}
					
						else if(j==0 && i-1>=0) {//맨왼쪽 
								queue.add(map[i][j]); 
								map[i][j]=queue.poll();
								selected[i][j] = true;
							}
						else if(i==n-1 && j-1>=0){ //맨밑
							queue.add(map[i][j]); 
							map[i][j]=queue.poll();
							selected[i][j] = true;
							}
					
						//System.out.print(map[i][j]+" ");
				}
				//System.out.println();
			}
		}
		System.out.println();
		
		// 바꾼 후 
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}
