import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int max_time=100000;
	static int[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		visit=new int[max_time+1];
		
		bfs(n,k);
	}

	private static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(n);
	
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			if(tmp==k) {
				System.out.println(visit[tmp]);
				return;
			}
			else {
				int[] arr = {tmp-1,tmp+1,tmp*2};
				for(int a : arr) {
					if(0<=a && a<= max_time) {
						if(visit[a]==0) {
							visit[a]=visit[tmp]+1;
							q.add(a);	
						}
					
					}
				}
			}
		}
	}
}