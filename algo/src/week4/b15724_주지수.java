package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15724_주지수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		int sums[][]= new int[n][m];//누적합
		int res=0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0;j<m;j++) {
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
		st = new StringTokenizer(br.readLine());
		
		int k= Integer.parseInt(st.nextToken());
		
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			
			if(x1==0&&y1==0)
				res = sums[x2][y2];
			else if(x1==0)
				res = sums[x2][y2] -sums[x2][y1-1] ;
			else if(y1==0)
				res = sums[x2][y2] - sums[x1-1][y2] ;
			else 
				res = sums[x2][y2] - sums[x1-1][y2]-sums[x2][y1-1]+sums[x1-1][y1-1];
					
			
			sb.append(res+"\n");	
		}
		
		System.out.println(sb);
	}
}
