class SumOfDigitsString
{
	static int sumOfDigits(int n)
	{
		String s = Integer.toString(n);
		int sum = 0;

		for(char ch: s.toCharArray()){
			sum += ch - '0';
		}
		return sum;
	}
	public static void main(String[] args)
	{
		int n = 12345;
		System.out.println(sumOfDigits(n));
	}
}