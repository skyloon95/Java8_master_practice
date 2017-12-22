package lab2;

public class Example02 {
    
    static String getFileName(String path) {
    	String[] tmp;
    	String fileName = null;
    	
    	tmp = path.split("/");
    	
    	fileName = tmp[tmp.length-1];
    	
    	return fileName;
    }
    
    public static void main(String[] args) {
        String[] a = { "c:/data/student/lecture.docx", 
                       "c:/www/mainpage.html",
                       "c:/program files/java/javac.exe" };
        for (String s : a) {
            String fileName = getFileName(s);
            System.out.println(fileName);
        }
            
    }

}
