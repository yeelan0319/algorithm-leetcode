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
        if(node == null) {
            return null;
        }
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        queue.add(node);
        while(queue.size() > 0) {
            UndirectedGraphNode origin = queue.removeFirst();
            if(!map.containsKey(origin)) {
                map.put(origin, new UndirectedGraphNode(origin.label));
            }
            UndirectedGraphNode clone = map.get(origin);
            for(UndirectedGraphNode neighbor : origin.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                clone.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}