package ReverseWord.src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Sentence: ");
        String sentence = sc.nextLine();

        System.out.println(ReverseWordEfficient.reverse(sentence));

        sc.close();
    }
}
