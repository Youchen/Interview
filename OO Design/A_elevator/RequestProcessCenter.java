package Amazon.elevator;

import java.util.LinkedList;

public class RequestProcessCenter implements Runnable {
	private static RequestProcessCenter instance = new RequestProcessCenter();
	public LinkedList<Request> queue = new LinkedList<Request>();
	
	private RequestProcessCenter( ) {
//		queue = new LinkedList<Request>( );
	}
	public static RequestProcessCenter getInstance() {
		return instance;
	}
	
	
	public void run() {
		while ( true ) {
			processRequest( );
		}
	}
	
	public void addRequest(Request request) {
		queue.add(request);
	}
	
	public void removeRequest(Request request) {
		queue.remove(request);
	}
	
	public Request getNextRequest( ) {
		Request shortestReq = null;
		int shortest = Integer.MAX_VALUE;
		int curFloor = Elevator.getInstance( ).getCurrentFloor( );
		
		for (Request item : queue) {
			int distance = Math.abs(curFloor - item.getToFloor( ) );
			if (distance < shortest) {
				shortest = distance;
				shortestReq = item;
			}
		}
		return shortestReq;
	}
	
	public void processRequest( ) {
		Request req = getNextRequest( );
		if (req != null) {
			int toFloor = req.getToFloor( );
			Elevator.getInstance().moveToTargetFloor( toFloor);
			queue.remove(req);
		}
	}
}
