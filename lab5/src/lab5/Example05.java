package lab5;

public class Example05 {
    
    static String removeNonAlphabet(String s) {
    	StringBuilder b = new StringBuilder();
    	
    	for(int i = 0 ; i<s.length() ; i++) {
    		if(s.charAt(i)>='a'&&s.charAt(i)<='z') {
    			b.append(s.charAt(i));
    		}
    	}
    	
    	return b.toString();
    }
    
    public static void main(String[] args) {
        String s = " a#b.c__d$$$e++++f;;;g...h///i%";
        s = removeNonAlphabet(s);
        System.out.println(s);
    }

}

