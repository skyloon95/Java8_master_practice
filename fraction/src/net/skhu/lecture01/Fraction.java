package net.skhu.lecture01;

public class Fraction {

    private int numerator; // 분자
    private int denominator; // 분모

    Fraction(int numerator, int denominator) {
        int gcd = greatestCommonDivisor(numerator, denominator); // 분자와 분모의 최대공약수
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    @Override
    public String toString() {
    	return String.format("Fraction{numerator=%d, denominator=%d}", numerator, denominator );
    }
    
    @Override
    public boolean equals(Object obj) {
    	if((obj instanceof Fraction) == false) return false;
    	Fraction f = (Fraction)obj;
    	return this.numerator == f.numerator && this.denominator == f.denominator;
    }

    public static Fraction add(Fraction f1, Fraction f2) { // 덧셈 (분모를 최대 공배수로 통일하여 덧셈)
    	int lcmDenominator = leastCommonMultiplyOfDenominator(f1, f2);
    	int numeratorOfF1 = (lcmDenominator/f1.denominator)*f1.numerator;
    	int numeratorOfF2 = (lcmDenominator/f2.denominator)*f2.numerator;
    	
    	int numerator = numeratorOfF1 + numeratorOfF2;
    	
    	return new Fraction(numerator, lcmDenominator);
    }

    public static Fraction subtract(Fraction f1, Fraction f2) { // 뺄셈 (분모를 최대 공배수로 통일하여 뺼셈)
    	int lcmDenominator = leastCommonMultiplyOfDenominator(f1, f2);
    	int numeratorOfF1 = (lcmDenominator/f1.denominator)*f1.numerator;
    	int numeratorOfF2 = (lcmDenominator/f2.denominator)*f2.numerator;
    	
    	int numerator = numeratorOfF1 - numeratorOfF2;
    	
    	return new Fraction(numerator, lcmDenominator);
    }

    public static Fraction multiply(Fraction f1, Fraction f2) { // 곱셈 (분모와 분자를 각각 곱셈)
    	return new Fraction(f1.numerator*f2.numerator, f1.denominator*f2.denominator);
    }

    public static Fraction divide(Fraction f1, Fraction f2) { // 나누기 (후항의 분모 분자를 뒤집어 전항과 곱셈)
    	return new Fraction(f1.numerator*f2.denominator, f1.denominator*f2.numerator);
    }

    public static int greatestCommonDivisor(int x, int y) { // 최대 공약수를 구해주는 함수 (for 약분)
        return y == 0 ? x : greatestCommonDivisor(y, x % y);
    }
    
    public static int leastCommonMultiplyOfDenominator(Fraction f1, Fraction f2) { // 분모의 최소공배수 구해주는 함수.
    	return f1.denominator*(f2.denominator/greatestCommonDivisor(f1.denominator, f2.denominator));
    }

    public static void main(String[] argv) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        
        System.out.printf("%s ＋ %s = %s\n", f1, f2, Fraction.add(f1, f2));
        System.out.printf("%s － %s = %s\n", f1, f2, Fraction.subtract(f1, f2));
        System.out.printf("%s × %s = %s\n", f1, f2, Fraction.multiply(f1, f2));
        System.out.printf("%s ÷ %s = %s\n", f1, f2, Fraction.divide(f1, f2));
        
        System.out.println(Fraction.add(f1,  f2).equals(new Fraction(5, 6)));
    }
}
