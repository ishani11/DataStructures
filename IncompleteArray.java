package pcprac;

import java.util.HashMap;

public class IncompleteArray {
	
	public static int incompleteArray(int[] arr) {
		HashMap<Integer, Integer> map= new HashMap<>();
		int max= Max(arr);
		int min=Min(arr);
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
		}
		
		return max-min+1-map.size();
	}

	public static int Max(int[] arr) {
		int largest=arr[0];
		for(int i=1; i<arr.length; i++) {
			if(largest<arr[i]) {
				largest=arr[i];
			}
		}
		
		return largest;
	}
	
	public static int Min(int[] arr) {
		int smallest=arr[0];
		for(int i=1; i<arr.length; i++) {
			if(smallest>arr[i]) {
				smallest=arr[i];
			}
		}
		
		return smallest;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,3,4,4,7,8,8,10,12};
		
		System.out.println(incompleteArray(arr));

	}

}
