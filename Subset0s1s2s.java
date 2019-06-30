package pcprac;

import java.util.HashMap;
import java.util.Map;

public class Subset0s1s2s {
	
	public static int countSubsets(String s) {
		HashMap<Integer, Integer> freq = new HashMap<>();
		HashMap<String, Integer> pos= new HashMap<>();
		
		freq.put(0, 0);
		freq.put(1, 0);
		freq.put(2, 0);
		pos.put("0,0", 1);
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='0') {
				freq.put(0, freq.get(0)+1);
				
			}else if(s.charAt(i)=='1') {
				freq.put(1, freq.get(1)+1);
			}else if(s.charAt(i)=='2') {
				freq.put(2, freq.get(2)+1);
			}
			System.out.println(freq.get(0)+" "+freq.get(1)+" "+ freq.get(2));
			
			//Integer posarr[]= new Integer[2];
			String s1=Integer.toString(freq.get(1)-freq.get(0));
			String s2=Integer.toString(freq.get(2)-freq.get(1));
			String posarr=s1+","+s2;
			
			
			if(pos.containsKey(posarr)) {
				pos.put(posarr, pos.get(posarr)+1);
			}else {
				pos.put(posarr, 1);
			}
			
			
		}
		
		int sum=0;
		
		for(Map.Entry<String, Integer> entry:pos.entrySet()) {
			int n=entry.getValue();
			System.out.println(entry.getKey()+" -> "+ entry.getValue());
			sum+=n*(n-1)/2;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSubsets("102100211"));
	}

}
