package algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class swea1247_최적경로 {
	static int answer;
	static int home_x,home_y,now_x,now_y;
	static int[] cus_x,cus_y;
	static int N,max_sum;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		int TC = Integer.parseInt(br.readLine());//고객의 수

		
		for(int i=0;i<10;i++) {
			N = Integer.parseInt(br.readLine());//고객의 수

			st = new StringTokenizer(br.readLine());
			
			cus_x = new int[N];
			cus_y = new int[N];
			
			answer=Integer.MAX_VALUE;
			visited = new boolean[N];
			
			now_x=Integer.parseInt(st.nextToken());
			now_y=Integer.parseInt(st.nextToken());
			
			home_x=Integer.parseInt(st.nextToken());
			home_y=Integer.parseInt(st.nextToken());
			
			for(int j=0;j<N;j++) {
				cus_x[j]=Integer.parseInt(st.nextToken());
				cus_y[j]=Integer.parseInt(st.nextToken());
			}
			
			dfs(now_x,now_y, 0,0);
			
			System.out.println("#"+(i+1)+" "+answer);
		}
	}
	
	// |x1-x2| + |y1-y2|
	private static void dfs(int nx, int ny, int ds, int depth) {
		
		if(depth==N) {
			int now_dist = ds + Dist(nx, ny, home_x,home_y);
			answer = Math.min(now_dist, answer);
			return;
		}
		
		for(int j=0;j<N;j++) {
			if(!visited[j]) {
				visited[j]=true;
				dfs(cus_x[j] , cus_y[j],  ds +Dist(nx,ny,cus_x[j],cus_y[j]), depth+1 );
				visited[j]=false;
			}
		}
	}
	private static int Dist(int nx, int ny, int x, int y ) {
		return Math.abs(nx-x)+ Math.abs(ny-y);
	}
}
