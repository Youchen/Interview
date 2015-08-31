/**
 * Reference
 *      http://www.careercup.com/question?id=14809764
 */
public void bfs() {
        // BFS uses Queue data structure
    Queue queue = new LinkedList();
    queue.add(this.rootNode);
    System.out.println(this.rootNode);

    visited.put(rootNode, true);

    while (!queue.isEmpty()) {
        Node node = (Node) queue.remove();
        Node child = null;
        while ((child = getUnvisitedChildNode(node)) != null) {
            visited.put(child, true);
            System.out.println(child);

            queue.add(child);
        }
    }
        // Clear visited property of nodes
    clearNodes();
}

public void bfsRecursive(Queue queue) {
        // BFS uses Queue data structure
    if (queue.isEmpty()) return;
    Node node = (Node) queue.remove();
    System.out.println(node);
    visited.put(node, true);
    for (Node child: node.child) {
        queue.add(child);
    }
    bfsRecursive(queue);
}











public void dfs() {
        // DFS uses Stack data structure
    Stack stack = new Stack();
    stack.push(this.rootNode);
    visited.put(rootNode, true);
    System.out.println(rootNode);
    while (!stack.isEmpty()) {
        Node node = (Node) stack.peek();
        Node child = getUnvisitedChildNode(node);
        if (child != null) {
            visited.put(child, true);
            System.out.println(child);
            stack.push(child);
        } else {
            stack.pop();
        }
    }
    clearNodes();
}

public void dfsRecursive(Stack stack) {
        // DFS uses Stack data structure
    if (stack.empty()) return;
    Node node = (Node) stack.peek();
    if (visited.get(node)==null) System.out.println(node);
    visited.put(node, true);
    Node child = getUnvisitedChildNode(node);
    if (child != null) {
        stack.push(child);
    } else {
        stack.pop();
    }
    dfsRecursive(stack);
}