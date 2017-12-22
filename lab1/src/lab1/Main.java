package lab1;

import java.util.Random;

public class Main {
    
    static Random random = new Random();
    
    static int[] makeIntArray(int count) {
        int[] a = new int[count];
        for (int i = 0; i < count; ++i)
            a[i] = random.nextInt(10000);
        return a;
    }

    static double[] makeDoubleArray(int count) {
        double[] a = new double[count];
        for (int i = 0; i < count; ++i)
            a[i] = random.nextDouble() + random.nextInt(100);
        return a;
    }
    
    static String makeRandomString() {
        StringBuilder builder = new StringBuilder();
        int size = random.nextInt(3) + 3;
        for (int i=0; i < size; ++i) {
            int n = random.nextInt(26) + 'a';
            builder.append((char)n);
        }
        return builder.toString();
    }
    
    static String[] makeStringArray(int count) {
        String[] a = new String[count];
        for (int i = 0; i < count; ++i)
            a[i] = makeRandomString();
        return a;
    }
    
    public static void main(String[] args) {
        int length = random.nextInt(5) + 5;
        int[] a1 = makeIntArray(length);
        double[] a2 = makeDoubleArray(length);
        String[] a3 = makeStringArray(length);
        
        System.out.println("       int     double     String");
        System.out.println("---------- ---------- ----------");       
        for (int i = 0; i < length; ++i) {
        	System.out.printf("%10d %10.3f %10s", a1[i], a2[i], a3[i]);
        	System.out.println("");
        }        
    }
}

