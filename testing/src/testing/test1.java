package testing;

import java.util.Random;

class ThreadA extends Thread {

    String name;
    Random random;

    public ThreadA(String name) {
        this.name = name;
        this.random = new Random();
    }

    @Override
    public void run() {
        System.out.printf("%s: started\n", name);
        try {
            for (int i = 0; i < 100; ++i) {
                System.out.printf("%s: %d\n", name, i);
                int mili_second = random.nextInt(100);
                sleep(mili_second);
            }
        } catch (InterruptedException e) {
            System.out.printf("%s: interrupted\n", name);
        }
        System.out.printf("%s: stoped\n", name);
    }
}

public class test1 {
	
	public static void main(String args[]) {
        Thread threadOne = new ThreadA("one");
        Thread threadTwo = new ThreadA("two");
        Thread threadThree = new ThreadA("three");
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}


