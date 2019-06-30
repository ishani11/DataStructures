package pcprac;

import java.util.HashMap;
import java.util.Map;

public class PairSumDivisibility {
	
	public static boolean pairSumDivisibility(int[] arr, int k) {
		
		HashMap<Integer, Integer> map= new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			int rem=0;
			if(arr[i]<0) {
				if(arr[i]%k==0) {
					rem=0;
				}else {
					rem=arr[i]%k+k;
					
				}
			}else {
				rem=arr[i]%k;
			}
			
			if(map.containsKey(rem)) {
				map.put(rem, map.get(rem)+1);
			}else {
				map.put(rem, 1);
			}
			System.out.println(rem+" "+map.get(rem));
		}
		
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			
			
			if(entry.getValue()==0) {
				continue;
			}
			if(entry.getKey()==0) {
				if(entry.getValue()%2!=0) {
					//System.out.println("running1");
					return false;
				}
			}else if(k%2==0 && entry.getKey()*2==k) {
				if(entry.getValue()%2!=0) {
					return false;
				}else {
					map.put(entry.getKey(), map.get(entry.getKey())-2);
					System.out.println("running2");
				}
			
			}else {
				int complement=k-entry.getKey();
				System.out.println(complement);
				if(map.containsKey(complement)) {
					if(map.get(complement)==0) {
						System.out.println("running3");
						return false;
					}else {
						map.put(complement, map.get(complement)-1);
						map.put(entry.getKey(), map.get(entry.getKey())-1);
					}
				}else {
					System.out.println("running4");
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {9, 7, 5, 3};
		System.out.println(pairSumDivisibility(arr, 6));
		

	}

}
