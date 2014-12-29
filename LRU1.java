import java.io.*;
class LRU1
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
		lru();
	}
	static  void lru()
	{
		int i,j=0,fault=0,k=0,pos;
		for(i=0;i<m;i++)
			x[i]=-1;
		for(i=0;i<n;i++)
		{
			if(check(pg[i]))
			{
				if(k==2)
				{
				   pos= position(i-1);
				   x[pos]=pg[i];
				   fault++;
				}
				else
				{
					x[j]=pg[i];
					fault++;
					j=(j+1)%m;
				}
					if(j==0)
						k=2;
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
	static int position(int max)
	{
		int pos[]=new int[m];
		int j=0,i;
		for(int k=0;k<m;k++)
			pos[k]=0;
		do
		{
			for(i=max;i>=0;i--)
			{
				if(x[j]==pg[i]&&pos[j]<=i)
					break;
			}
			pos[j]=i;
			j=j+1;
		}
		while(j<m);

		int min=pos[0];
		int p=0;
		for(j=1;j<m;j++)
		{
			if(pos[j]<min)
			{
				min=pos[j];
				p=j;
			}
		}
		return p;
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
0
3
Page Frame 7
2
0
3
Page Frame 8
4
0
3
Page Frame 9
4
0
2
Page Frame 10
4
3
2
Page Frame 11
0
3
2
Page Frame 12
0
3
2
Page Frame 13
0
3
2
Page Frame 14
1
3
2
Page Frame 15
1
3
2
Page Frame 16
1
0
2
Page Frame 17
1
0
2
Page Frame 18
1
0
7
Page Frame 19
1
0
7
Page Frame 20
1
0
7
Total No. of faults are 9

Process completed.
*/