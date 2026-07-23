class ReverseDigitsUsingString
{
	static int reverseDigits(int n)
	{
		StringBuffer s = new StringBuffer(String.valueOf(n));
		s.reverse();
		n = Integer.parseInt(String.valueOf(s));
		return n;
	}
	public static void main(String[] args)
	{
		int n = 54321;
		System.out.println(reverseDigits(n));
	}
}