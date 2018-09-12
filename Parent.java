package com.payu;

public class Parent extends Child {
	void m1()
	{
		System.out.println("from parent m1");
	}
	void m3()
	{
		System.out.println("from parent m3");
	}
	
	public static void main(String[] args) {
		Parent p=new Parent();
	//	Parent p1=new Child(); //can not convert to child.
		Child c=new Child();
		Child c1=new Parent();
		p.m1();
		c1.m1();
		c.m2();
		p.m3();
		c1.m2();
		
		
		
	}

}
class Child
{
	void m1()
	{
		System.out.println("from child m1");
	}
	void m2()
	{
		System.out.println("from child m2");
	}
}

