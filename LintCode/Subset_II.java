class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        //2015-05-09 00:09:24 - 2015-05-09 00:19:08 (9 min)
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.size() == 0)
            return res;
        
        Collections.sort(S);
        helper(res, new ArrayList<Integer>(), S, 0);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list,
                        ArrayList<Integer> S, int pos){
                            
            if(! res.contains(new ArrayList<Integer>(list))){
                res.add(new ArrayList<Integer>(list));
                // return;
            }
            for(int i = pos; i < S.size(); i++){
                list.add(S.get(i));
                helper(res, list, S, i + 1);
                list.remove(list.size() - 1);
            }
    }
}


