public enum State{
	Unvisited, Visiting, Visited;
}

public boolean hasRoute(Graph g, Node start, Node end) {
	LinkedList<Node> q = new LinkedList<Node>();

	for (Node n : g.getNodes()){
		u.state = State.Unvisited;
	}

	start.state = State.Visiting;
	q.add(start);
	Node u;
	While(! q.isEmpty()){
		u = q.removeFirst();
		if(u != null){
			for(Node v : u.getAdjacent()){
				if(v.state == State.Unvisited){}
					if(v == end)
						return true;
					else{
						v.state = State.Visiting;
						q.add(v);
					}
				}
			}
		}
		u.state = State.Visited;
	}
	return false;
}