/**
 * Follow up problem:
 *      Insert Interval
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
    public List<Interval> merge(List<Interval> intervals) {
        //2015-06-28 00:10:23 - 2015-06-28 00:24:33 (14 min)
        if(intervals.size() <= 1)
            return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        List<Interval> res = new ArrayList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(Interval iter : intervals){
            if(iter.start <= end)//overlapped interval, update the end.
                end = Math.max(end, iter.end);
            //we have a new start, so merger all the interval just passed
            //      and set the start and end by the new value.
            else{
                res.add(new Interval(start, end));
                start = iter.start;
                end = iter.end;
            }
        }
        //don't forget to add the last interval.
        res.add(new Interval(start, end));
        return res;
    }
}