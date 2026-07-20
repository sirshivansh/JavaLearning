public class isEvenEfficient
{ 
	public static boolean isEvenEfficient(int n)
	{
		if((n&1) == 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args)
	{
		int n = 10;
		if(isEvenEfficient(n) == true)
			System.out.println("true");
		else
			System.out.println("false");

	}
}