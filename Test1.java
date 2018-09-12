package com.payu;

public class Test1 {
	private static Singleton singleton=null;
	public static void main(String[] args) {
		singleton=Singleton.getInstance();
	}

}
