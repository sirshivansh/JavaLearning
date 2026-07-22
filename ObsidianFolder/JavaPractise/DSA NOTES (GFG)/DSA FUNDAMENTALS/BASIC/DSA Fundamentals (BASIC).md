> BASIC
## Even or Odd

> Naive Approach : By finding the remainder - O(1) time complexity, and O(1) space complexity

```
// Naive Approach

class isEven{

	public static boolean isEven(int n)
	{
		int rem = n%2;
		if(rem == 0){
			return true;
		}else{
			return false;
		}
	}

	public static void main(String[] args)
	{
		int n = 15;
		if(isEven(n)== true){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
}
```

> Efficient Approach : Using Bitwise AND Operator - O(1) time complexity, and O(1) space complexity

---
# Multiplication Table

> Iterative Approach: Begin with a number that we want table of then multiply with increasing numbers

```
public class MultiplicationTable
{
	public static void printTable(int n)
	{
		for(int i = 1; i<=10; ++i){
			System.out.println(n+" * "+i+" = "+ n*i);
		}
	}

	public static void main(String[] args)
	{
		int n = 5;
		printTable(n);
	}
}
```

> Recursive Approach: we pass i as an initial parameter with initial value as 1. We print n * i and then recursively call for i+1, we stop when i becomes 11, because we need only 10 multiples of given number

varargs => Integer...  (Variable Length Arguement)

```
class MultiplicationTableRecursive
{
	static void printTable(int n, Integer... val){
		int i = 1;
		if(val.length != 0)
			i = val[0];
		if(i == 11) //base case
			return;
		System.out.println(n+" * "+i+" = "+ n*i);
		i++;
		printTable(n, i);
	}

	public static void main(String[] args){
		int n = 5;
		printTable(n);
	}
}
```

---
# Finding sum of n Natural Numbers

> Naive Approach: using loop - O(n) time, O(1) space.

```
class sumOfnNaturals
{
	static int findSum(int n){
		int sum = 0;
		for(int i = 0; i <= n; i++){
			sum = sum + i;
		}
		return sum;
	}
	public static void main(String[] args){
		int n = 5;
		System.out.println(findSum(n));
	}
}
```

> Alternative Approach: Using recursion - O(n) time, O(n) space

```
class sumOfnNaturalsUsingRecursion
{
	static int findSum(int n){
		// base condition
		if(n == 1){
			return 1;
		}
		return n + findSum(n-1);
	}
	public static void main(String[] args){
		int n = 5;
		System.out.println(findSum(n));
	}
}
```

> Expected Approach: Formula Based Method - O(1) Time, O(1) Space

// Sum of first n natural numbers = (n*(n+1))/2

```
class sumOfnNaturalsUsingFormula
{
	static int findSum(int n){
		return n * (n+1) / 2;
	}
	public static void main(String[] args){
		int n =5;
		System.out.println(findSum(n));
	}
}
```

---
# Sum of Squares of First n Naturals 

> Naive Approach: Adding One-By-One - O(n) time, O(1) space

```
//Naive Approach

class sumOfSquaresFirstnNaturals
{
	public static int summation(int n)
	{
		int sum = 0;
		for(int i = 1; i <= n; i++){
			sum = sum + (i*i);
		}
		return sum;
	}
	public static void main(String[] args){
		int n = 5;
		System.out.println(summation(n));
	}
}
```

> Expected Approach: Using Mathematical Formulae - O(1) time, O(1) space

Formula: Sum of squares of first n naturals = n * (n+1) * (2 * n+1) / 6

```
class sumOfSquaresFirstNaturalsUsingFormula
{
	static int printSquares(int n){
		//return (n * (n+1) * (2*n+1)) / 6;
		return n * (n+1)/2 * (2*n+1)/3; 
		//to avoid overflow, when large values of n
	}
	public static void main(String[] args){
		int n = 5;
		System.out.println(printSquares(n));
	}
}
```

-> In the above code, the return value might overflow due to large value of n
-> to avoid this overflow, we split the formula:
-> n * (n+1)/2 * (2 * n+1)/3

---
# Swapping Two Numbers

> Idea: Using a Third Variable

```
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
```

Output:
```
Before Swap:
10 5
After Swap:
5 10
```

> Without using Third Variable - Using Arithmetic Operator

```
// Without using third Variable , using an arithmetic operator

class SwappingTwoNumbersArithmetic
{
	public static void SwapAr(int a, int b)
	{
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println(a+" "+b);
	}
	public static void main(String[] args){
		int a = 10;
		int b = 5;
		System.out.println("Before Swap: ");
		System.out.println(a+" "+b);
		System.out.println("After Swap: ");
		SwapAr(a,b);

	}
}
```

---
# Closest to m, divisible by n

> Naive Approach : Iterative Checking - O(m)  time, O(1) space

```
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
```

> Expected Approach: By Finding Quotient

```
class ClosestToNDivisibleByMQuotient
{
	static int closestNumber(int n, int m){
		int q = n/m;

		int n1 = m*q;

		int n2 = (n*m) > 0 ? (n*(q+1)) : (n*(q-1));

		if(Math.abs(n - n1) < Math.abs(n - n2))
			return n1;
		return n2;
	}

	public static void main(String[] args){
		int n = 13, m = 4;
		System.out.println(closestNumber(n,m));
	}
}
```

---
# The Dice Problem
Guess the opposite side number of the dice

Naive Approach comprises of if, else if statements.

```
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
```

---
