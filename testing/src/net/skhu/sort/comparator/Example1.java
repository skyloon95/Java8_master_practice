package net.skhu.sort.comparator;

public class Example1 {

	static void print(int... a) {
        System.out.printf("\nlength=%d : ", a.length);
        for (int i : a)
            System.out.printf("%d ", i);
    }        
    
    public static void main(String[] args) {
        print(11, 2, 31, 44);
        print(51, 35);
        print(64);
        print();

        int[] a = new int[] { 11, 2, 31, 44 };
        print(a);
    }

}