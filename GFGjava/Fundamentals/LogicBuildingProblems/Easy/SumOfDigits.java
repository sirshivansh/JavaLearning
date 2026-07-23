// Given a number n, find the sum of it's digits.

class SumOfDigits
{
	static int sumOfDigits(int n)
	{
		int sum = 0;
		while(n!=0){
			int last = n%10;
			sum += last;
			n /= 10;
		}
		return sum;
	}
	public static void main(String[] args)
	{
		int n = 12345;
		System.out.println(sumOfDigits(n));
	}		
}
