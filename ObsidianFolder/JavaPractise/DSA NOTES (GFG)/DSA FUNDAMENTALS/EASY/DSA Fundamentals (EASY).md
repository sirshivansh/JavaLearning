# 1. Sum of Digits of a Number

> Using Digit Extraction: O(log10n) and O(1) space

```
// Given a number n, find the sum of it's digits.

class SumOfDigits
{
	static int sumOfDigits(int n)
	{
		int sum = 0;
		while(n!=0){
			int last = n%10;
			sum += last;
			n /= 10;
		}
		return sum;
	}
	public static void main(String[] args)
	{
		int n = 12345;
		System.out.println(sumOfDigits(n));
	}		
}
```

> Using Recursion: O(log10n) time, O(log10n) space

```
class SumOfDigitsRecursion
{
	static int sumOfDigits(int n)
	{
		if(n == 0)
			return 0;
		return (n%10)+sumOfDigits(n/10);
	}
	public static void main(String[] args)
	{
		int n = 12345;
		System.out.println(sumOfDigits(n));
	}
}
```

> Using String Conversion

```
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
```

---
# 2. Reverse Digits of a Number

> Digit-by-Digit Reverse: Time Complexity O(log10n), Space Complexity O(1)

```
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
```

> Using String

```
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
```
---
