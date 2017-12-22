package lab7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Example1 {
	public static void main(String[] args) {
		Collection<Integer> list = new ArrayList<Integer>();

		for(int i = 0 ; i<30 ; ++i) list.add(i);

		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			int i = iterator.next();
			if(10<=i && i<=20)
				iterator.remove();
		}

		System.out.println(list);
	}
}
