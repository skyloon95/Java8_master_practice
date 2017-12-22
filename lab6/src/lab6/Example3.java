package lab6;

import java.util.Arrays;
import java.util.Comparator;

class Rectangle {
	private int width, height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getArea() {
		return width * height;
	}
	
	@Override
	public String toString() {
		return "Rectangle{"+this.width+", "+this.height+"}";
	}

}

class RectangleAreaComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if(o1==o2)
			return 0;
		if(o1==null)
			return -1;
		if(o2==null)
			return 1;
		if(((Rectangle) o1).getArea()==((Rectangle) o2).getArea())
			return 0;
		if(((Rectangle) o1).getArea()>=((Rectangle) o2).getArea())
			return 1;
		if(((Rectangle) o1).getArea()<=((Rectangle) o2).getArea())
			return -1;
		return 0;
	}
	
}

public class Example3 {

	public static void main(String[] args) {
		Rectangle a[] = new Rectangle[] {
				new Rectangle(5, 7), new Rectangle(3, 2), new Rectangle(7, 2),
				new Rectangle(4, 5), new Rectangle(8, 2), new Rectangle(6, 3)
		};

		Comparator<Rectangle> comparator = new RectangleAreaComparator();
		Arrays.sort(a, comparator);
		System.out.println(Arrays.toString(a));
	}
}

