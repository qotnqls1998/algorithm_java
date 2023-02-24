package week4;

import java.util.Scanner;

public class Main {
	static long start;
	static long end;
	static int cnt;
	static int n;
	static long idx;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		cnt=0;
		
		//7331 은 7331 733 73 7모두 소수
		start =( long) Math.pow(10,n-1); //1000
		end = (long) Math.pow(10,n); // 10000
		
		
		for(long i=start;i<end;i++) {
			cnt=0;
			idx=start;
			isSpecialPrime(i,idx);
				
		}
	}
	
	public static boolean isPrime(long n) {
		if(n==1) return false;
		else{
			for (long i = 2; i<=(long)Math.sqrt(n); i++) {
		      if (n % i == 0 ) {
		          return false;
		      }
			}
			return true;
		}
	}
	
	public static void isSpecialPrime(long i, long idx) {
		
		if ( isPrime(i/idx) ){
			if(idx>1) {
				isSpecialPrime(i, idx/10);
				}
			else if(idx==1) {
				if(isPrime(i)) {
					System.out.println(i);
				}
			}
			
		}

	}
}