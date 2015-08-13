/**
 * O(n) - scan twice
 * O(n)
 * 
 * DO THIS AGAIN
 * 
 * Note:
 *      idea is BFS:
 *          form the corresponding relationship of original node and copy node by using HashMap.
 *          store all the node into a queue, iterate one by one to
 *              Clone nodes
 *              Clone edges
 * 
 *      Be careful in the details, don't be hurry.
 *      for the second time practice, I forget to put " ! " before marked line 1.
 */
 
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //2015-06-13 22:47:52
        if(node == null)
            return null;
        
        ArrayList<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        hm.put(node, nodeCopy);
        list.add(node);
        
        //clone nodes
        int start = 0;
        while(start < list.size()){
            UndirectedGraphNode NodeIter = list.get(start++);
            
            for(UndirectedGraphNode neighbor : NodeIter.neighbors){
                if(! hm.containsKey(neighbor)){ // <======================== 1 ==================
                    nodeCopy = new UndirectedGraphNode(neighbor.label);
                    hm.put(neighbor, nodeCopy);
                    list.add(neighbor);
                }
            }
        }
        
        //clone edges
        for(UndirectedGraphNode nodeIter: list){
            UndirectedGraphNode corresNode = hm.get(nodeIter);
            
            for(UndirectedGraphNode neighbor: nodeIter.neighbors){
                corresNode.neighbors.add(hm.get(neighbor));
            }  
        }
        return hm.get(node);
    }
}