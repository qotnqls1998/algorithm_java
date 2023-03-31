package ssafyclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj연구소 {
	static int n,m;
	static int[][] map;
	
	static class Point{
		int i,j;
		
		public Point(int i, int j) {
			this.i=i;
			this.j=j;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		map = new int[n][m];
		int safeZone = 0;
		int min_safeZone = 0;
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		List<Point> blankList = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				if(map[i][j]==0) {
					blankList.add(new Point(i,j));
				}
			}
		}
		
		//int n = blankList.size();
		int n = 5;
		
		int r = 1;
		
		int tc = comb(n, r);
		System.out.println(tc);
//		for() {
//			//조합으로 벽세울 위치 고르기
//			
//			//조합 돌린 거로 바이러스 퍼트린뒤 
//			dfs();
//			
//			// 안전구역 갯수 세고 min값 출력하기
//			for(int i=0 ; i<n ; i++) {
//				for(int j=0 ; j<m ; j++) {
//					if(map[i][j]==0) {
//						safeZone++;
//					}
//				}
//			}
//			min_safeZone = Math.min(safeZone, min_safeZone);
//		}
//		
//		System.out.println(min_safeZone);
	}
	
	private static int comb(int n, int r) {
		
		
		
	}

	//바이러스 퍼트리기
	private static void dfs() {
		
	}



	

	
}
