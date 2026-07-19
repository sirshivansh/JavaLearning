/*
input = JAVA IS AWESOME, output = AWESOME IS JAVA
*/

import java.util.Scanner;

public class ReverseWords{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a sentence: ");
		String input = sc.nextLine();

		String[] words = input.split(" ");

		for(int i = words.length-1; i>=0; i--){
			System.out.print(words[i]);

			if(i != 0){
				System.out.print(" ");
			}

		}
		sc.close();
	}
}