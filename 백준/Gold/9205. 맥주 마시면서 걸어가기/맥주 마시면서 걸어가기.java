import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static boolean[] visit;
	static List<Point> list;
	static int n;
	static boolean isTrue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int t=0 ; t<TC ; t++) {
			n = sc.nextInt(); //편의점 개수
			list = new ArrayList<>();
			visit = new boolean[n+2];
			
			for(int i=0;i<n+2;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				list.add(new Point(x,y));
			}
			
			isTrue = true;		
			int dis=0;
		
			BFS(0);
			
			
			
		}
	}

	private static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		visit[start] = true; //초기 시작점 방문 확인
		
		q.add( start ); //q에 넣음
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=0;i<n+2;i++) {
				//방문한적 없고
				if (visit[i] != true) {
					
					//거리가 1000이하면 q에 넣는다
					int dis = Math.abs( list.get(i).x - list.get( tmp ).x )  + Math.abs( list.get(i).y - list.get( tmp ).y  )   ;
					
					if(dis <= 1000) {
						q.add(i);
						visit[i]=true;
					}			
				}
			}
			
		}
		
		if(visit[n+1]==true) {
			System.out.println("happy");
		}else {
			System.out.println("sad");
		}
	}
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}