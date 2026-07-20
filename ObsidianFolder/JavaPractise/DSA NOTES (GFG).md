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
