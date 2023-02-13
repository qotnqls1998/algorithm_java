package algo.baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b2164_카드2 {
	static Queue<Integer> queue = new LinkedList<>(); 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			queue.add(i+1);
		}
		
		while(queue.size()>1) {
			if(queue.size()==2) {
				queue.remove();
				break;
			}
			else {
				queue.remove();
				queue.add(queue.peek());
				queue.remove();
			}
			
		}
		
		System.out.println(queue.peek());
	
	}
}
