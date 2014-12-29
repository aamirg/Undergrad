import java.io.*;
class FIFO
{
	static int pg[],x[],n,m;
	public static void main(String args[])throws IOException
	{
		DataInputStream in = new DataInputStream(System.in);
		System.out.println("Enter No. of Pages");
		n=Integer.parseInt(in.readLine());
		pg=new int[n];
		int i;
		System.out.println("Enter Page Sequence");
		for(i=0;i<n;i++)
		{
			pg[i]=Integer.parseInt(in.readLine());
		}
		System.out.println("Enter Page Frame Size");
		m=Integer.parseInt(in.readLine());
		x=new int[m];
		fifo();
	}
	static  void fifo()
	{
		int i,j=0,fault=0;
		for(i=0;i<m;i++)
			x[i]=-1;
		for(i=0;i<n;i++)
		{
			if(check(pg[i]))
			{
				x[j]=pg[i];
				fault++;
				j=(j+1)%m;
			}
			System.out.println("Page Frame "+(i+1));
			print();
		}
		System.out.println("Total No. of faults are "+(fault-m));
	}
	static boolean check(int d)
	{
		for(int i=0;i<m;i++)
		{
			if(x[i]==d)
				return false;
		}
		return true;
	}
	static void print()
	{
		for(int i=0;i<m;i++)
		{
			if(x[i]==-1)
			{
				System.out.println("-");
			}
			else
				System.out.println(x[i]);
		}
	}
}
/*
Output:-
--------------------Configuration: <Default>--------------------
Enter No. of Pages
20
Enter Page Sequence
7
0
1
2
0
3
0
4
2
3
0
3
2
1
2
0
1
7
0
1
Enter Page Frame Size
3
Page Frame 1
7
-
-
Page Frame 2
7
0
-
Page Frame 3
7
0
1
Page Frame 4
2
0
1
Page Frame 5
2
0
1
Page Frame 6
2
3
1
Page Frame 7
2
3
0
Page Frame 8
4
3
0
Page Frame 9
4
2
0
Page Frame 10
4
2
3
Page Frame 11
0
2
3
Page Frame 12
0
2
3
Page Frame 13
0
2
3
Page Frame 14
0
1
3
Page Frame 15
0
1
2
Page Frame 16
0
1
2
Page Frame 17
0
1
2
Page Frame 18
7
1
2
Page Frame 19
7
0
2
Page Frame 20
7
0
1
Total No. of faults are 12

Process completed.
*/