// Without using third Variable , using an arithmetic operator

class SwappingTwoNumbersArithmetic
{
	public static void SwapAr(int a, int b)
	{
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println(a+" "+b);
	}
	public static void main(String[] args){
		int a = 10;
		int b = 5;
		System.out.println("Before Swap: ");
		System.out.println(a+" "+b);
		System.out.println("After Swap: ");
		SwapAr(a,b);

	}
}