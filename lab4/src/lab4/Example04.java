package lab4;

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class Example04 {

	public static void main(String[] args) {
		Object[] a = new Object[3];
		Object[] b;
		Person p = new Person("¿”≤©¡§",22);
		
		a[0] = new double[] {1.1, 2.2, 3.3};
		a[1] = new String[] {"a","b","c"};
		a[2] = new Person[] {p, p};
		
		b = a;
	}

}
