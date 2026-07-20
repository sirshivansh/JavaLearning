// Using a Third Variable 

class SwappingTwoNumbers
{
	public static void Swap(int a, int b){
		int temp = 0;
		temp = a;
		a = b;
		b = temp;
		System.out.println(a + " " + b);
	}
	public static void main(String[] args){
		int a = 10;
		int b = 5;
		System.out.println("Before Swap: ");
		System.out.println(a + " " + b);
		System.out.println("After Swap: ");
		Swap(a,b);
	}
}