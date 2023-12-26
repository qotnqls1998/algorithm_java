package boj;
import java.util.*;
import java.io.*;

public class 최소힙 {
	static int n,m;
	static long num;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer("");
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			num = Long.parseLong(br.readLine());
			if(num==0 ) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}
				else
					System.out.println(pq.poll());
			}
			else {
				pq.add(num);
			}
				
		}
		
//		for(int i=0;i<m;i++)
//			System.out.println(pq.peek());
	}
}
