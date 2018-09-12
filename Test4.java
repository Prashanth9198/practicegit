package com.payu;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

import org.jpos.iso.ISODate;

public class Test4 implements CustomMarker {
public static void main(String[] args) {
	
	
	 NavigableMap<Integer, String> map = new TreeMap<Integer, String>();
	    map.put(2, "two");
	    map.put(1, "one");
	    map.put(3, "three");
	    System.out.println( map.subMap(1,true,3,true) + "\n");
	    System.out.println( map.descendingMap().subMap(3,true,1, true));
	
	/*Test4 t=new Test4();
	if(t instanceof CustomMarker)
	{
		System.out.println("granted permission");
	}
	else
	{
		System.out.println("No permission");
	}*/
	/*List<String> list=new ArrayList<>();
	list.add("one");
	list.add("two");
	String str[]=new String[list.size()];
	list.toArray(str);
	for(String temp: str)
	{
		System.out.println(temp);
	}*/
	String str1="reddy";
	String str2=new String("prashanth");
	String str3=str2;
	if(str3 ==str2)
	{
		System.out.println("success");
	}
	else
	{
		System.out.println("failed");
	}
	if(str3.equals(str2))
	{
		System.out.println("success equals");
	}
	else
	{
		System.out.println("failed");
	}

	
}
}
