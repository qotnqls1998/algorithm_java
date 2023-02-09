package algo.baek;

import java.util.Scanner;

//남학생은 배수의 스위치 상태를 바꿈
//여학생은 
public class b1244_switch {
	static int light_num;
	static int[] light;
	static int tc;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		light_num = sc.nextInt();
		
		light= new int[light_num+1];
		for(int i=1;i<=light_num;i++)
			light[i]=sc.nextInt();
		
		tc=sc.nextInt();
		
		for(int i=0;i<tc;i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			if(gender ==1) boy(num);
			else if(gender ==2) girl(num);
		}	
		
		//출력
		for(int i=1;i<=light_num;i++) {
			System.out.print(light[i]+" ");
			if(i%20==0)
				System.out.println();
		}
	}

	//배수 스위치
	private static void boy(int n) {
		for(int i=1;i<=light_num;i++) {
			if(i%n==0) {
					switch_light(i);
			}
		}
	}
	//12927
	//대칭 스위치
	private static void girl(int n) {
		//먼저 자기 자신
		switch_light(n);
		//그리고 대칭확인하면서 스위치
		int x = n-1;
		int y = n+1;
		while(true) {
			if (x<1 || y >light_num) break;
			if (light[x]==light[y]) {
				switch_light(x);
				switch_light(y);
				x--;
				y++;
			}
			else break;
		}
		
		
	}
	private static void switch_light(int i) {
		if(light[i]==0)
			light[i]=1;
		else light[i]=0;
	}
	
	
}
