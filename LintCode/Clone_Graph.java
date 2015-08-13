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
 */
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 * 
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //2015-06-13 22:30:38 - 2015-06-13 22:44:54 (14 min)
        if(node == null)
            return null;
        
        //copy nodes
        ArrayList<UndirectedGraphNode> q = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label);
        q.add(node);
        hm.put(node, nodeCopy);
        
        int start = 0;
        while(start < q.size()){
            UndirectedGraphNode NodeIter = q.get(start++);
            for(UndirectedGraphNode iter: NodeIter.neighbors){
                if( ! hm.containsKey(iter) ){
                    nodeCopy = new UndirectedGraphNode(iter.label);
                    hm.put(iter, nodeCopy);
                    q.add(iter);
                }
            }
        }
        
        //connect edges
        for(UndirectedGraphNode NodeIter: q){
            UndirectedGraphNode corresNode = hm.get(NodeIter);
            
            for(UndirectedGraphNode neighbor : NodeIter.neighbors){
                corresNode.neighbors.add(hm.get(neighbor));
            }
            
        }
        return hm.get(node);
    }
}
