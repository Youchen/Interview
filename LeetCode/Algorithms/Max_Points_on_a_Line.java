/**
 * O(n^2)
 * O(n)
 * 
 * Very nice problem.
 * 
 * Idea is to iterate every points and form the line with other points,
 *      update the max.
 * Need to be careful with the overlapped points and vertical slope.
 * 
 * Note:
 *      Review the iteration of Hashmap.
 * 
 * Reference:
 *      http://www.programcreek.com/2014/04/leetcode-max-points-on-a-line-java/
 */
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        //2015-06-29 22:57:13 pause 2015-06-29 23:04:59
        //2015-07-21 21:05:41 - 2015-07-21 21:28:41 (30 min)
        if(points == null || points.length == 0)
            return 0;
        
        int len = points.length;
        int max = 0;
        //duplicate is how many points overlapped with the current point
        //      default is 1 - itself.
        //vertical is the number of points formed vertical slope with current points.
        int duplicate, vertical;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        
        for(int i = 0; i < len; i++){
            duplicate = 1;
            vertical = 0;
            
            for(int j = i + 1; j < len; j++){
                if(points[i].x == points[j].x){
                    if(points[i].y == points[j].y)
                        duplicate++;
                    else
                        vertical++;
                }else{
                    double slope = points[i].y == points[j].y ? 0.0 : 
                                    1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
                                
                    if( !map.containsKey(slope) )
                        map.put(slope, 1);
                    else
                        map.put(slope, map.get(slope) + 1);
                }
            }
            
            for(Map.Entry<Double, Integer> iter : map.entrySet()){
                int temp = iter.getValue() + duplicate;
                max = Math.max(max, temp);
            }
            
            max = Math.max(vertical + duplicate, max);
            map.clear();
        }
        return max;
    }
}