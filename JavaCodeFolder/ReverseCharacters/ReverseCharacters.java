/*
input = WORD, output = DROW
*/

import java.util.Scanner;

public class ReverseCharacters{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Characters: ");
		String str = sc.nextLine();

		char[] chars = str.toCharArray();

		for(int i = chars.length-1; i>=0; i--){
			System.out.print(chars[i]);
		}
		sc.close();
	}
}