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
        int r = sorts*(p1.name.compareTo(p2.name));  // ���� �̸�(name)�� ���Ѵ�.
        if (r != 0) return r;                // �̸��� ���� �ʴٸ�, �̸� �� ����� �����Ѵ�.
        return p1.age - p2.age;              // �̸��� ���ٸ�, ����(age) �� ����� �����Ѵ�.
    }
}

class PersonAgeComparator implements Comparator<Person> {
	int sorts;

	public PersonAgeComparator(int sorts) {
		this.sorts = sorts;
	}
	
	@Override
    public int compare(Person p1, Person p2) {
        int r = sorts*(p1.age - p2.age);             // ���� ����(age)�� ���Ѵ�.
        if (r != 0) return r;                // ���̰� ���� �ʴٸ�, ���� �� ����� �����Ѵ�.
        return p1.name.compareTo(p2.name);   // ���̰� ���ٸ�, �̸�(name) �� ����� �����Ѵ�.
    }

}

