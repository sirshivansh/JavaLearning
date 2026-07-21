class ClosestToNDivisibleByM
{
	public static int ClosestToNDivisibleByM(int n, int m){
		m = Math.abs(m); //handle negative m

		// n is itself divisible by m
		if(n%m == 0){
			return n;
		}

		// check outwards from n, distance i = 1,2,3,...
		for(int i=1; i<= m; i++){
			int upper = n + i;
			int lower = n - i;

			boolean upperDivisible = (upper % m == 0);
			boolean lowerDivisible = (lower % m == 0);

			if(upperDivisible && lowerDivisible){
				// if both are equidistant -> choose the one with max. absolute value
				return (Math.abs(upper) > Math.abs(lower)) ? upper : lower;
			} else if (upperDivisible){
				return upper;
			} else if (lowerDivisible){
				return lower;
			}
		}
		return n;
	}

	public static void main(String[] args){
		int n = 13, m = 4;
		System.out.println(ClosestToNDivisibleByM(n,m));
	}
}