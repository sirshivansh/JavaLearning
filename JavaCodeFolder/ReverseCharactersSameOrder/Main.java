// package ReverseCharactersSameOrder;

// Input: "Java is Awesome"
// Output: "avaJ si emosewA"

import java.util.Scanner;

public class Main {
	public static void main(String[] args){

		String input = "Java is Awesome";
		
		char[] chars = input.toCharArray();
		int end = chars.length;
		int start = 0;

		for(int i=0; i<=end; i++){
			if(i==end || chars[i]==' '){
				reverseWord(chars, start, i-1);
				start = i+1;
			}
		}
		System.out.println(new String(chars));
	}
	private static void reverseWord(char[] a, int left, int right){
		while(left<right){
			char temp = a[left];
			a[left] = a[right];
			a[right] = temp;
			left++;
			right--;
		}
	}
}