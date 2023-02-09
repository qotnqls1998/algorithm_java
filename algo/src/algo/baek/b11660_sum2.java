package algo.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11660_sum2 {
	static int[][] map;
	static int[][] sums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
	    int res;
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		sums = new int[n][n];
		
		//map생성
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());	
			}	
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0;j<n;j++) {
				if(i==0 &&j==0)
					sums[i][j]=map[i][j];
				else if(i==0)
					sums[i][j]=sums[i][j-1]+map[i][j];
				else if(j==0)
					sums[i][j]=sums[i-1][j]+map[i][j];
				else 
					sums[i][j] = sums[i-1][j]+sums[i][j-1]+map[i][j]-sums[i-1][j-1];
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken())-1;	
			int y1 = Integer.parseInt(st.nextToken())-1;	
			int x2 = Integer.parseInt(st.nextToken())-1;	
			int y2 = Integer.parseInt(st.nextToken())-1;	
			
			res =0;
			
			if(x1==0&&y1==0)
				res = sums[x2][y2];
			else if(x1==0)
				res = sums[x2][y2] -sums[x2][y1-1] ;
			else if(y1==0)
				res = sums[x2][y2] - sums[x1-1][y2] ;
			else 
				res = sums[x2][y2] - sums[x1-1][y2]-sums[x2][y1-1]+sums[x1-1][y1-1];
					
			sb.append(res);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
