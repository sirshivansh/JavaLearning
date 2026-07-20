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