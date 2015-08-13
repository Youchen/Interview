package _03;

public class C03_01_StackArr {
	int stackSize;
	int[] stack;// = new int[stackSize * 3];
	int[] stackPointer = new int[3];// {-1, -1, -1};
	
	public C03_01_StackArr() {
		stackSize = 100;
		stack = new int[stackSize * 3];
		
		stackPointer[0] = -1;
		stackPointer[1] = stackSize/3 - 1;
		stackPointer[2] = (2 * stackSize)/3 - 1;
	}
	
	public C03_01_StackArr(int stack_size) {
		stackSize = stack_size;
		stack = new int[stackSize * 3];
		
		stackPointer[0] = (0 * stackSize)/3 - 1;
		stackPointer[1] = (1 * stackSize) - 1;
		stackPointer[2] = (2 * stackSize) - 1;
	}
	
	//suppose the input stackNum would be 1, 2, 3;
	public void push(int stackNum, int value) throws Exception {
		if(stackPointer[stackNum - 1] + 1 >= stackNum  * stackSize ) {
			throw new Exception("out of Space");
		}
		else {
			stackPointer[stackNum - 1]++;
			stack[ stackPointer[stackNum - 1] ]= value;
		}
	}
	
	public int pop(int stackNum) throws Exception{
		if(stackPointer[stackNum - 1] <= (stackNum - 1)/3 - 1) {
			throw new Exception("No items in this stack");
		}
		else {
			int val = stack[ stackPointer[stackNum - 1] ];
			stack[ stackPointer[stackNum - 1] ] = 0;
			stackPointer[stackNum - 1]--;
			return val;
		}
	}
	
	public int peek(int stackNum) throws Exception{
		if(stackPointer[stackNum - 1] <= (stackNum - 1)/3 - 1) {
			throw new Exception("No items in this stack");
		}
		int val = stack[ stackPointer[stackNum - 1] ];
//		stack[ stackPointer[stackNum - 1] ] = 0;
//		stackPointer[stackNum - 1]--;
		return val;
	}
	
	public boolean isEmpty(int stackNum) {
		return stackPointer[stackNum - 1] <= (stackNum - 1)/3 - 1;
	}
	
}
