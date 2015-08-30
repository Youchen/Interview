package Amazon.elevator;
/**
 * 楼主前段时间Amazon onsite，遇到了Amazon经典的电梯设计题目，
 * 		下面是我对这个题目的总结，也是答案不是最好的，欢迎大家来补充。
 * 下面是我的onsite 面经：
 * 		http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=139134&page=1#pid1956961
 * 
 * 我感觉对于OOP设计问题，关键要和面试官进行讨论。
 * 		弄清情景situation ，who will use it,在这个situation都是有哪些对象，
 * 		他们在干什么，他们之间是什么关系，然后一个对象一个对象的去分析这个对象应有的属性，和行为。
 * 		多和面试官讨论，越细致越好！
 * 		如果可以使用什么单例，或者factory method 来设计的话，multi threading, 就尽量的添加上这些东西。
 * 
 * 
 * First ask the interviewer what kind of elevator?  
 * 		there is only one elevator serving that building or multiple elevators 
 * 			serving the building simultaneously?
 * 
 * this situation is that: 
 * 		there is one elevator serving the building.  
 * 		there are many floors in the buliding. 
 * 
 * Maybe there are some users in different floor pressing the button simultaneously. 
 * This results in some requests to RequestProcessCenter for processing. 
 * 
 * The  RequestProcessCenter figure out the first request that need to be 
 * 		processed in such an algorithm that the distance between target floor and 
 * 		current floor is shortest.
 * 
 * First describe the whole situation. and check it with your interviewer;
 * Second sketch out the main classes and methods on the whiteboard;
 * 
 * So we need the following classes:
 */
public class Elevator {
	public static Elevator instance = new Elevator(); //  instance = null;
	private int currentFloor;
	
	private Elevator() {
//		if (instance == null) {  // late loading and eager loading
//			// connection pool
//			synchronized (Elevator.class) {
//				instance = new Elevator();
//			}
//		}
//		return instance;
	}
	public static Elevator getInstance() {
//		if (instance == null) {
//			synchronized (SingletonDemo.class) {
//				instance = new Elevator();
//			}
//		}
		return instance;
	}
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void moveToTargetFloor(int toFloor) {
		currentFloor = toFloor;
	}
	public void moveUp() {};
	public void moveDown() {};
}

