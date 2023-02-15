package algo.baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b1158_요세푸스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int cnt=0;
		
		Queue<Integer> queue = new LinkedList<>();
		
		
		for(int i=1;i<=n;i++)
			queue.add(i);
		
		System.out.print("<");
		
		while(!queue.isEmpty()) {
			int now = queue.poll(); // 제거하고 출력
			cnt++;
			//3번꺼 =  k 
			if(cnt==k) {
				if(queue.size()==0)
					System.out.print(now+">");
				else
					System.out.print(now+", ");
				
				cnt=0;
			}else {//다시 넣어
				queue.add(now);
			}
			
		}
		
	}
}
