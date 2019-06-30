package pcprac;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DoublePair {
	
	public static boolean doublePair(int[] arr) {
		TreeMap<Integer, Integer> map= new TreeMap<>();
		
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
			
		}
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey()+" "+ entry.getValue());
		}
		
		boolean flag=true;
		sort(arr, 0, arr.length-1);
		
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
			int k=arr[i];
			System.out.println(map.get(k));
			if(map.get(k)==0) {
				continue;
			}
			
//			if(i!=arr.length-1 && map.get(arr[i])>map.get(arr[i+1])) {
//				return false;
//			}
			if(k==0) {
				if(map.get(k)%2!=0) {
					return false;
				}else {
					flag=true;
				}
			}
			else if(k<0) {
				if(k%2!=0) {
					return false;
				}
				if(map.containsKey(k/2)) {
					if(map.get(k)>map.get(k/2)) {
						//System.out.println("shizz");
						return false;
					}
					map.put(k, map.get(k)-1);
					map.put(k/2, map.get(k/2)-1);
					flag=true;
					
					
					
					
				}
				else {
					//System.out.println("shizz2");
					return false;
				}
				
				
			}else {
				if(map.containsKey(k*2)) {
					map.put(k, map.get(k)-1);
					map.put(k*2, map.get(k*2)-1);
					flag=true;
					if(map.get(k)>map.get(k*2)) {
						return false;
					}
					
					
				}else {
					return false;
				}
				
			}
			
			
		}	
		
		return true;
		
	}
	
	public static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
   
    public static void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
  
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {-12, 78, 84, 156, 42, -6, -100, -200, 78, 39};
		System.out.println(doublePair(arr));
	}

}
