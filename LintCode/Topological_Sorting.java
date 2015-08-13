/**
 * O(n)
 * O(n)
 * 
 * Note:
 *      Be clear with the idea.
 */
/**
 * Definition for Directed graph.
 * 
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 * 
 *     DirectedGraphNode(int x) { 
 *          label = x; 
 *          neighbors = new ArrayList<DirectedGraphNode>();
 *      }
 * }
 * 
 */
public class Solution {
    public ArrayList<DirectedGraphNode> 
                                topSort(ArrayList<DirectedGraphNode> graph) {
        //2015-06-14 22:43:03 - 2015-06-14 22:57:41 (14 min)
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if(graph == null || graph.size() == 0)
            return res;
        
        //compute the in-degree.
        HashMap<DirectedGraphNode, Integer> inDegree = 
                                    new HashMap<DirectedGraphNode, Integer>();
    
        for(DirectedGraphNode node : graph){
            
            for(DirectedGraphNode neighbor : node.neighbors){
                
                if(inDegree.containsKey(neighbor))
                    inDegree.put(neighbor, inDegree.get(neighbor) + 1);
                else
                    inDegree.put(neighbor, 1);
            }
        }
        
        //Declare a queue, add nodes which has 0 in-degree to this queue.
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for(DirectedGraphNode node : graph){
            if( ! inDegree.containsKey(node) )
                q.offer(node);
        }
        
        //sort
        while(q.size() != 0){
            DirectedGraphNode pollNode = q.poll();
            res.add(pollNode);
            
            for(DirectedGraphNode node : pollNode.neighbors){
                inDegree.put(node, inDegree.get(node) - 1);
                if(inDegree.get(node) == 0)
                    q.offer(node);
            }
        }
        return res;
    }
}
