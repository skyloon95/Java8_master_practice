package lab3;

public class Example03 {
    
    static String toString(String[] a) {
    	StringBuilder b = new StringBuilder();
    	
    	b.append("{");
    	for(int i = 0 ; i<a.length-1 ; i++) {
    		b.append("\""+a[i]+"\""+", ");
    	}
    	b.append("\""+a[a.length-1]+"\""+"}");
    	
    	return b.toString();
    }
    
    public static void main(String[] args) {
        String[] a = { "one", "two", "three", "four" };
        String s = toString(a);
        System.out.println(s);
    }

}

