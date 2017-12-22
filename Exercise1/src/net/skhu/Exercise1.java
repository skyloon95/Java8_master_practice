package net.skhu;

public class Exercise1 {
	private static Object[] variable;
	
	static void addData(int count) {
		variable = new Object[count*2];
		
		for(int i = 0 ; i<count*2 ; i++) {
			variable[i++] = new Integer(i);
			variable[i] = String.valueOf(i);
		}
	}
	
	static int findIndex(int value) {
		Integer index = null;
		
		for(int i = 0 ; i<variable.length ; i++) {
			if(variable[i] == value) {
				index = i;
			}
		}
		return index;
	}
	
	static int findIndex(String value) {
		Integer index = null;
		
		for(int i = 0 ; i<variable.length ; i++) {
			if(variable[i] == value) {
				index = i;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		addData(10);
		System.out.println(findIndex(3));
		System.out.println(findIndex("3"));
	}
}
