class DiceProblemExpectedSol
{
	public static int oppositeFaceOfDice(int n)
	{
		int ans = 7 - n;
		return ans;
	}
	public static void main(String[] args)
	{
		int n = 3;
		System.out.println(oppositeFaceOfDice(n));
	}
}