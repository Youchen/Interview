/**
 * This is the follow up question of
 *      Merge Interval
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //2015-06-28 00:30:21 - 2015-06-28 00:53:08 (23 min)
        if(intervals.size() == 0){
            List<Interval> res = new ArrayList<Interval>();
            res.add(newInterval);
            return res;
        }
        //insert the newInterval
        intervals.add(newInterval);
        
        Collections.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2){
               return i1.start - i2.start;
           } 
        });
        
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        List<Interval> res = new ArrayList<Interval>();
        
        for(Interval iter : intervals){
            if(iter.start <= end)
                end = Math.max(end, iter.end);
            else{
                res.add(new Interval(start, end) );
                start = iter.start;
                end = iter.end;
            }
        }
        
        res.add(new Interval(start, end));
        return res; 
    }
}