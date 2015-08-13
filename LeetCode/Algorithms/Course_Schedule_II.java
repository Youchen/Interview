public class Solution {
    public int[] findOrder(int numCourses, int[][] prereq) {
        //2015-06-14 23:33:47 - 2015-06-14 23:41:45 ( 8 min ) - modified via ** Course Schedule I **
        int[] res = new int[numCourses];
        if( numCourses == 0 )
            return res;
        if(prereq.length == 0){
            for(int i = 0; i < numCourses; i++)
                res[i] = i;
            return res;
        }    
    
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
        int index = 0;
        while( q.size() != 0 ){
            int course = q.poll();
            res[index++] = course;
            
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
        if(index == numCourses)
            return res;
        return new int[0];
    }
}