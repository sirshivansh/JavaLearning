# DSA FUNDAMENTALS

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

Formula: Sum of squares of first n naturals = n * (n+1) * (2n+1) / 6

```
class sumOfSquaresFirstNaturalsUsingFormula
{
	static int printSquares(int n){
		return (n * (n+1) * (2*n+1)) / 6;
	}
	public static void main(String[] args){
		int n = 5;
		System.out.println(printSquares(n));
	}
}
```

---