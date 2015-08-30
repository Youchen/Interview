package Amazon.elevator;

public class Request {
	private int toFloor;
	
	public Request(int _toFloor) {
		toFloor = _toFloor;
	}
	
	public int getToFloor() {
		return toFloor;
	}
}