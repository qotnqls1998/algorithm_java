package algo.swea;

import java.util.Scanner;

public class swea_파리퇴치 {
	static int[][] map;
	static int[][] fly_hit;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=0;i<tc;i++) {
			int max =-1;
			
			int n= sc.nextInt();
			int m=sc.nextInt();
			map = new int[n][n];
			fly_hit = new int[n-m+1][n-m+1];
			//배열 저장
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					map[j][k]=sc.nextInt();
				}
			}
			int tmp=0;
			//젤 많이 죽일 수 있는 파리 수 계산
			for(int j=0;j<n-m+1;j++) {
				for(int k=0;k<n-m+1;k++) {
					tmp=0;
					for(int l=0;l<m;l++) {
						for(int o=0;o<m;o++) {
							tmp += map[j+l][k+o];
						}
					}
					if(tmp>max) max=tmp;
				}
			}
			System.out.println("#"+(i+1)+" "+max);
				
		}
		
	}
}
