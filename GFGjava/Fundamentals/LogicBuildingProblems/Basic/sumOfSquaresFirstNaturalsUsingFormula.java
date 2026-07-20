class sumOfSquaresFirstNaturalsUsingFormula
{
	static int printSquares(int n){
		//return (n * (n+1) * (2*n+1)) / 6;
		return n * (n+1)/2 * (2*n+1)/3; //to avoid overflow, when large values of n
	}
	public static void main(String[] args){
		int n = 5;
		System.out.println(printSquares(n));
	}
}