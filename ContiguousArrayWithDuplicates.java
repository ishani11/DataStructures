package pcprac;

import java.util.HashSet;

public class ContiguousArrayWithDuplicates {
	
	public static boolean contiguousArray(int[] arr) {
		HashSet<Integer> set= new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			set.add(arr[i]);
		}
		
		int max=Max(arr);
		System.out.println(max);
		
		int min=Min(arr);
		System.out.println(min);
		System.out.println(set.size());
		return max-min+1==set.size();
		
	}
	
	public static int Max(int[] arr) {
		int largest= arr[0];
		for(int i=1; i<arr.length; i++) {
			if(largest<arr[i])
				largest=arr[i];
		}
		
		return largest;
	}

	public static int Min(int[] arr) {
		int smallest= arr[0];
		for(int i=1; i<arr.length; i++) {
			if(smallest>arr[i])
				smallest=arr[i];
		}
		
		return smallest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {5, 2, 3, 6, 4, 4, 6, 6};
		System.out.println(contiguousArray(arr));

	}

}
