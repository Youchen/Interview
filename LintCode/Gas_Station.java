public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //2015-05-29 16:39:56 - 2015-05-29 16:54:46 (7 min)
        if(gas == null || cost == null)
            return 0;
        
        int haveGas = 0, gasSum = 0, costSum = 0, start = 0;
        for(int i = 0; i < gas.length; i++){
            gasSum += gas[i];
            costSum += cost[i];
            haveGas += gas[i] - cost[i];
            if(haveGas < 0){
                start = i + 1;
                haveGas = 0;
            }
        }
        if(costSum > gasSum) return -1;
        return start;
    }
}

