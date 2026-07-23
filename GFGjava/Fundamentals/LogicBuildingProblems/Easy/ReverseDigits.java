class ReverseDigits
{
	static int ReverseDigits(int n)
	{
		int revNum = 0;
		while(n > 0){
			revNum = revNum * 10 + n%10;
			n = n/10;
		}
		return revNum;
	}

	public static void main(String[] args)
	{
		int n = 12345;
		System.out.println(ReverseDigits(n));
	}
}