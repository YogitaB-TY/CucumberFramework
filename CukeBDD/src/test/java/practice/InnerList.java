package practice;

import java.util.ArrayList;
import java.util.List;

public class InnerList {
	
	public static void main(String[] args) {
		
		List<String> name=new ArrayList<String>();
		name.add("Yogita");
		name.add("Afshan");
		
		List<List<String>> list=new ArrayList<List<String>>();
		list.add(name);
		
		System.out.println(list.get(0).get(0));
	}

}
