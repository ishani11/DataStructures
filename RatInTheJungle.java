package pcprac;

import java.util.HashMap;
import java.util.Map;

public class RatInTheJungle {
	
	public static int ratInJungle(int[] arr) {
		HashMap<Integer, Integer> map= new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
		}
		int sum=0;
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
			int grp=0;
			if(entry.getKey()==0) {
				grp=entry.getValue();
			}
			else if(entry.getKey()>entry.getValue()) {
				grp=1;
			}else if(entry.getValue()%(entry.getKey()+1)==0){
				grp=entry.getValue()/(entry.getKey()+1);
			}else {
				grp=(entry.getValue()/(entry.getKey()+1))+1;
			}
			
			sum+=(entry.getKey()+1)*(grp);
		}
		
		return sum;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {18, 7, 1, 1, 18, 3, 0, 17};
		System.out.println(ratInJungle(arr));
	}

}
