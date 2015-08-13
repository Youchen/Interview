Inheritance
	the process where one object acquires the properties of another. 
	extends and implements.
		These words would determine whether one object IS-A type of another.
	IS-A relationship
		public class Animal{
		}

		public class Mammal extends Animal{
		}

		public class Reptile extends Animal{
		}

		public class Dog extends Mammal{
		}
	HAS-A relationship
		public class Vehicle{}
		public class Speed{}
		public class Van extends Vehicle{
			private Speed sp;
		}





Overriding
	If a class inherits a method from its super class, then 
		there is a chance to override the method provided that it is not marked final.
	Benefit:
		ability to define a behavior that's specific to the subclass type 
			which means a subclass can implement a parent class method based on its requirement.

		class Animal{

		   public void move(){
		      System.out.println("Animals can move");
		   }
		}

		class Dog extends Animal{

		   public void move(){
		      System.out.println("Dogs can walk and run");
		   }
		}

		public class TestDog{

		   public static void main(String args[]){
		      Animal a = new Animal(); // Animal reference and object
		      Animal b = new Dog(); // Animal reference but Dog object

		      a.move();// runs the method in Animal class

		      b.move();//Runs the method in Dog class
		   }
		}


	Rules
		The argument list should be exactly the same as that of the overridden method.

		The return type should be the same or a subtype of the return type declared in the 
			original overridden method in the superclass.

		The access level cannot be more restrictive than the overridden method's access level. 
				For example: if the superclass method is declared public then the 
				overridding method in the sub class cannot be either private or protected.

		Instance methods can be overridden only if they are inherited by the subclass.

		A method declared final cannot be overridden.

		A method declared static cannot be overridden but can be re-declared.

		If a method cannot be inherited, then it cannot be overridden.

		A subclass within the same package as the instance's superclass can override 
			any superclass method that is not declared private or final.

		A subclass in a different package can only override the non-final methods 
			declared public or protected.

		An overriding method can throw any uncheck exceptions, regardless of whether the 
			overridden method throws exceptions or not. However the overriding method should not 
			throw checked exceptions that are new or broader than the ones declared by the overridden method. 
			The overriding method can throw narrower or fewer exceptions than the overridden method.

		Constructors cannot be overridden.







Polymorphism
	Polymorphism is the ability of an object to take on many forms. 
		The most common use of polymorphism in OOP occurs when a parent class reference 
			is used to refer to a child class object.

	Any Java object that can pass more than one IS-A test is considered to be polymorphic. 
		In Java, all Java objects are polymorphic since any object will pass the IS-A test 
		for their own type and for the class Object.


		public interface Vegetarian{}
		public class Animal{}
		public class Deer extends Animal implements Vegetarian{}

		Now, the Deer class is considered to be polymorphic 
			since this has multiple inheritance. 

		A Deer IS-A Animal

		A Deer IS-A Vegetarian

		A Deer IS-A Deer

		A Deer IS-A Object

	virtual methods
		In Java, all non-static methods are by default "virtual functions." 
			Only methods marked with the keyword final, which cannot be overridden, 
			along with private methods, which are not inherited, are non-virtual.










Abstraction
	Abstract class
		is one that cannot be instantiated. 
		All other functionality of the class still exists, 
		and its fields, methods, and constructors are all accessed in the same manner.

	Abstract method
		If you want a class to contain a particular method but you want the 
		actual implementation of that method to be determined by child classes, 
		you can declare the method in the parent class as abstract.

		The abstract keyword is also used to declare a method as abstract. 
		An abstract method consists of a method signature, but no method body.







Encapsulation
	is the technique of making the fields in a class private and 
		providing access to the fields via public methods










interface
	An interface is a collection of abstract methods.

	An interface is not a class.

	Class vs interface
		A class describes the attributes and behaviors of an object. 
		An interface contains behaviors that a class implements.

		相同

			An interface can contain any number of methods.

			An interface is written in a file with a .java extension, 
				with the name of the interface matching the name of the file.

			The bytecode of an interface appears in a .class file.

			Interfaces appear in packages, and their corresponding bytecode file 
				must be in a directory structure that matches the package name.

		不同

			You cannot instantiate an interface.

			An interface does not contain any constructors.

			All of the methods in an interface are abstract.

			An interface cannot contain instance fields. The only fields that can appear in an interface must be declared both static and final.

			An interface is not extended by a class; it is implemented by a class.

			An interface can extend multiple interfaces.



















