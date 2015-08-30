/**
 * Reference:
 *		http://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
 */
public class SingleObject{
	
	private static SingleObject instance = new SingleObject();

	private SingleObject(){}

	public static SingleObject getInstance(){
		return instance;
	}

	public void showMessage(){
		Syso...
	}

}


public class demo{
	SingleObject so = SingleObject.getInstance();

	so.showMessage();
}