package com.payu;

public class Singleton {
	private static Singleton instance=null;
	private Singleton()
	{
		
	}
	public static Singleton getInstance()
	{
		if(instance==null){
			System.out.println("Singleton called");
			instance=new Singleton();
		}		
		return instance;
	}
	/*public static void main(String[] args) {
		Singleton singleton=Singleton.getInstance();
		Singleton singleton2=singleton.getInstance();
	}*/

}
