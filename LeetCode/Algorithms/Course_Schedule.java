/**
 * O(numCourses)
 * O(numCourses)
 * 
 * Note:
 *      Pay attention to the details.
 *      For the marked line and below, I wrote "i" in the place where
 *          the "prereq[i][1]" appears.
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        //2015-06-14 23:02:49 - 2015-06-14 23:28:21 (26 min)
        if(numCourses == 0 || prereq == null || prereq.length == 0 )
            return true;
        
        //compute the in-degree
        HashMap<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
        for(int i = 0; i < prereq.length; i++){
            if(! inDegree.containsKey( prereq[i][0] ) )
                inDegree.put(prereq[i][0], 1);
            else
                inDegree.put(prereq[i][0], inDegree.get(prereq[i][0]) + 1 );
        }
        
        //add node which in-degree == 0
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if( ! inDegree.containsKey(i) )
                q.offer(i);
        }
        
        //sort
        int count = 0;
        while( q.size() != 0 ){
            int course = q.poll();
            count++;
            
            for(int i = 0; i < prereq.length; i++){
                
                if( prereq[i][1] == course ){ //<============= marked line =========
                    inDegree.put(prereq[i][0], inDegree.get(prereq[i][0]) - 1);
                    if(inDegree.get(prereq[i][0]) == 0){
                        q.offer(prereq[i][0]);
                        inDegree.remove(prereq[i][0]);
                    }
                }
            }
            
        }
        if(count == numCourses)
            return true;
        return false;
    }
}