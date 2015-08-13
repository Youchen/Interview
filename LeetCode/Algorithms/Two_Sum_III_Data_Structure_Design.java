/**
 * add:     O(1)
 * find:    O(n) where n is total number of elements that added.
 * 
 * O(n)
 */
public class TwoSum {
    //2015-06-29 12:36:36 - 2015-06-29 12:47:16 (11 min)
    HashMap<Integer, Integer> dataTimes = new HashMap<Integer, Integer>();
    
	public void add(int number) {
	    dataTimes.put(number, 
	                    dataTimes.containsKey(number) ? dataTimes.get(number) + 1 : 1);
	}

	public boolean find(int value) {
	    for(Map.Entry<Integer, Integer> pair : dataTimes.entrySet()){
	        int i = pair.getKey();
	        int j = value - i;
	        
	        if( (dataTimes.containsKey(j) && i != j) ||
	            (i == j && dataTimes.get(i) >= 2)
	            )
	            return true;
	    }
	    return false;
	}
}