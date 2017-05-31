package question.question300_399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Question347 {
	 public List<Integer> topKFrequent(int[] nums, int k) {
	        HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
	        for(int num:nums){
	            if(map.containsKey(num)){
	                map.put(num,map.get(num)+1);
	            }else{
	                map.put(num,1);
	            }
	        }
	        int n = map.size();
	        int[][] data = new int[n][2];
	        Set<Integer> set = map.keySet();
	        int i = 0;
	        for(int key:set){
	            data[i][0] = key;
	            data[i][1] = map.get(key);
	            i++;
	        }
	        Comparator c = new Comparator() {
				public int compare(Object o1, Object o2) {
					return ((Comparable) ((int[]) o2)[1])
							.compareTo(((int[]) o1)[1]);
				}
			};
			Arrays.sort(data, c);
			List<Integer> result = new ArrayList<Integer>();
			for(int j=0;j<k;j++){
			    result.add(data[j][0]);
			}
			return result;
	    }
}
