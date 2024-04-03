import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    static int[] dx ={0,0,-1,1};
    static int[] dy ={1,-1,0,0};
    
    static int[][] visit;
    static int n,m;
    static int answer;
    
    public int solution(int[][] maps) {
       
        n = maps.length;
        m = maps[0].length;
        visit= new int[n][m];
        
        bfs(maps);//시작점 0,0
        
        if(maps[0][0]!=1 || maps[n-1][m-1]!=1) {
            return -1;
        }
        
        answer = visit[n-1][m-1];   
        if(answer == 0){
            answer = -1;
        }
        
        return answer;
    }
    
    public void bfs(int[][] maps){
        Queue<Point> q = new LinkedList<Point>();
        
        q.add(new Point(0,0));
        visit[0][0] = 1;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            int px = p.x;
            int py = p.y;
            
            for(int i=0;i<4;i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                
                if( nx< 0 || nx >=n || ny<0 || ny>=m )continue;
				
                if(visit[nx][ny]==0 && maps[nx][ny]==1){
                    visit[nx][ny] = visit[px][py]+1;
                    q.add(new Point(nx,ny));
                }
            
               
            }
            
        }
        
      
    }
    public class Point {
       private int x; // x좌표
       private int y; // y좌표
      
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}