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
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer("");
		
		st = new StringTokenizer(br.readLine());	
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		
		map=new char[n][m];
		visit=new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]=s.charAt(j);
				
				if(map[i][j]=='I') {
					nx= i;
					ny= j;
				}
			}
		}
		
		answer=0;
		DFS(nx,ny);
		if(answer!=0)
			System.out.print(answer);
		else System.out.print("TT");
	}
	private static void DFS(int x, int y) {
		int[] dx= {1, 0,-1, 0};
		int[] dy= {0, 1, 0,-1};
		
		visit[x][y]=true;
	
		for(int i=0;i<4;i++) {
			int nx1=x+dx[i];
			int ny1=y+dy[i];
			if(nx1>=0 && nx1<n && ny1>=0 && ny1<m) {
				if(!visit[nx1][ny1]) {
					if(map[nx1][ny1]=='P') {
						answer+=1;
						DFS( nx1, ny1);
					}else if(map[nx1][ny1]=='O') {
						DFS( nx1, ny1);
					}
//					else if(map[nx1][ny1]=='X') {
//						return;
//					}
					
				}
			}
		}
		
	}
	
	
}
