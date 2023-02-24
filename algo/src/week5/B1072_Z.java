package week5;

import java.util.Scanner;

public class B1072_Z {
	static int N, r, c, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		
		
	}
	
	static int cnt;
	static void func(int si, int sj, int ei, int ej) {
		if(ei-si==1) {
			if(si==r && sj==c) {
				ans=cnt;
			}
			cnt++;
			return;
		}
		
		int mi =(si+ei)/2;
		int mj =(sj+ej)/2;
		
		func(si,sj,mi,mj); // 현재 나의 1번영역
		func(si,mj,mi,ej); // 현재 나의 2번영역
		func(mi,sj,ei,mj); // 현재 나의 3번영역
		func(mi,mj,ei,ej); // 현재 나의 4번영역
		
		
	}
}
