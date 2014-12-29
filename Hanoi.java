import java.io.*;
class Hanoi
{
	public static void main(String args[])throws IOException
	{
		DataInputStream in = new DataInputStream(System.in);
		int n;
		System.out.println("Enter the no of disks");
		n=Integer.parseInt(in.readLine());
		
		tower(n,'A','C','B');
	}
	
 static void tower(int n,char a,char b,char c)
 {
 	
 	if(n==1)
 	{
 		System.out.println("move disk "+n+" from peg "+a+" to peg "+c);
 		return;
 	}
 	else
 	{
 		tower(n-1,a,b,c);
 		
 		System.out.println("move disk "+n+" from peg "+a+" to peg "+c);
 		
 		tower(n-1,b,c,a);
 	}
 }
}