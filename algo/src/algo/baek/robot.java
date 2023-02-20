package algo.baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class robot {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] dx = new int[]{-1,0,1,0};
		int[] dy = new int[]{0,1,0,-1};
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int flag =0;
		
		int[][] graph= new int[n][m];
		int[][] visited = new int[n][m];
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				graph[i][j]=sc.nextInt();
			}
		}
		//처음 청소 chk
		visited[r][c]=1;
		int cnt=1;
		int nx,ny;
		
		while(true) {
			flag=0;
			
			for(int i=0;i<4;i++) {
				 nx = r + dx[(d+3)%4];
			     ny = c + dy[(d+3)%4];
			
			     d = (d+3)%4;
			     if (0 <= nx && nx < n && 0 <= ny && ny < m && graph[nx][ny] == 0) {
			            if (visited[nx][ny] == 0) {
			                visited[nx][ny] = 1;
			                cnt += 1;
			                r = nx;
			                c = ny;
			                flag = 1;
			                break;
			            }
			     }
			     
			}
			if (flag == 0) {
			        if (graph[r-dx[d]][c-dy[d]] == 1) { 
			            System.out.println(cnt);
			            break;
			        }
			        else {
			            r= r-dx[d];
			            c= c-dy[d];
			        }
			}
		}
	}
}
