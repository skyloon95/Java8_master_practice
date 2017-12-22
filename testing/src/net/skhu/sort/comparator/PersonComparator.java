package net.skhu.sort.comparator;

import java.util.Comparator;

class Comparators{
	public static final int ASC = 1;
	public static final int DESC = -1;
}

class PersonNameComparator implements Comparator<Person> {
	int sorts;
	
	public PersonNameComparator(int sorts) {
		this.sorts = sorts;
	}

	@Override
    public int compare(Person p1, Person p2) {
        int r = sorts*(p1.name.compareTo(p2.name));  // 먼저 이름(name)을 비교한다.
        if (r != 0) return r;                // 이름이 같지 않다면, 이름 비교 결과를 리턴한다.
        return p1.age - p2.age;              // 이름이 같다면, 나이(age) 비교 결과를 리턴한다.
    }
}

class PersonAgeComparator implements Comparator<Person> {
	int sorts;

	public PersonAgeComparator(int sorts) {
		this.sorts = sorts;
	}
	
	@Override
    public int compare(Person p1, Person p2) {
        int r = sorts*(p1.age - p2.age);             // 먼저 나이(age)를 비교한다.
        if (r != 0) return r;                // 나이가 같지 않다면, 나이 비교 결과를 리턴한다.
        return p1.name.compareTo(p2.name);   // 나이가 같다면, 이름(name) 비교 결과를 리턴한다.
    }

}

