package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b21736_헌내기는친구가필요해 {
	static char[][] map;
	static int nx,ny;
	static int answer;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer("");
		
		st = new StringTokenizer(br.readLine());	
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		
		map=new char[n][m];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]=s.charAt(j);
				
				if(map[i][j]=='I') {
					nx= i;
					ny= j;
				}
			}
			DFS(nx,ny);
			System.out.println(answer);
		}
		
	}
	private static void DFS(int x, int y) {
		int[] dx= {1, 0,-1, 0};
		int[] dy= {0, 1, 0,-1};
		
		
		for(int i=0;i<4;i++) {
			if(x+dx[i]<0 || x+dx[i]>=n || y+dy[i]<0 || y+dy[i]>=m) {
				return;
			}else {
				if(map[x+dx[i]][y+dy[i]]=='P') {
					answer+=1;
					DFS( x+dx[i], y+dy[i]);
				}else if(map[x+dx[i]][y+dy[i]]=='O') {
					DFS( x+dx[i], y+dy[i]);
				}else if(map[x+dx[i]][y+dy[i]]=='X') {
					return;
				}
			}
		}
		
	}
	
	
}
