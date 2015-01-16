package junk;

import java.util.Arrays;
import java.util.List;

public class StateTest {

	public static void main(String []args){
	
		String strs = "jose";
		
		List<String> sectionNames = Arrays.asList(strs.split(","));
		System.out.println(sectionNames);
		
		for(String str:sectionNames){
			System.out.println(str);
		}
		
		/*for(State str:State.values()){
			System.out.println(str.getDisplayName());
		}
		for(KaptestProfileServiceResponseCode str:KaptestProfileServiceResponseCode.values()){
			System.out.println(str.getDisplayName());
		}*/
		
	}
}
