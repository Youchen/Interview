/**
 * Need to have Sort method
 *      Collections.sort();
 */
class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        //2015-06-11 22:51:46 - 2015-06-11 23:04:21 ( 13 min )
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.size() == 0)
            return res;
        
        Collections.sort(S);
        subsets_helper(S, res, new ArrayList<Integer>(), 0);
        
        return res;
    }
    private void subsets_helper(ArrayList<Integer> S, 
    ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, int pos){
        
        res.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < S.size(); i++){
            list.add(S.get(i));
            subsets_helper(S, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
