package week2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class fre {
	public static void main(String[] args) {
		//Map<Integer,Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		Map<Integer,Integer> map = new LinkedHashMap<Integer, Integer>();
		
		int n = sc.nextInt();
		int c = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			if (map.get(num)==null) 
				map.put(num, 1);
			else 
				map.put(num, map.get(num)+1);
		}
	
		List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
		    @Override
		    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
		    }
		});
		
		for(Map.Entry<Integer, Integer> e: entryList) {
			for(int j=0;j<e.getValue();j++)
				System.out.print(e.getKey()+" ");
		}

	
	}
}