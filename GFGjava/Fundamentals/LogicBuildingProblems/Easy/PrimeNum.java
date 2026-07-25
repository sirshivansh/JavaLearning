class PrimeNum
{
	static boolean isPrime(int n)
	{
		if(n <= 1)
			return false;

		for(int i = 2; i<n; i++)
			if(n%i == 0)
				return false;
		return true;
	}
	public static void main(String[] args){
		int n = 7;
		if(isPrime(n)){
			System.out.println(n+" is a Prime Number");
		} else {
			System.out.println(n+" is not a Prime Number");
		}
	}
}