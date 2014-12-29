import java.io.*;
import java.lang.*;
class Apair
{
	public static void main(String args[])throws IOException
	{
		DataInputStream in=new DataInputStream(System.in);
		System.out.println("enter no of vertices");
		int v=Integer.parseInt(in.readLine());
		int i,k,j;
		int cost[][]=new int[v+1][v+1];
		int a[][]=new int[v+1][v+1];
		
		for(i=1;i<v+1;i++)
		{
			for(j=1;j<v+1;j++)
			{
				 System.out.println("enter cost of "+i+" - "+j);
			 	cost[i][j]=Integer.parseInt(in.readLine());
			a[i][j]=cost[i][j];
			}
	}
	System.out.println();
	System.out.println("original matrix ");
		for(i=1;i<v+1;i++)
			{
				for(j=1;j<v+1;j++)
				{
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
		System.out.println();
		System.out.println();
		
		for(k=1;k<v+1;k++)
		{
		   System.out.println();
			System.out.println("k=" +k);
			for(i=1;i<v+1;i++)
			{
				for(j=1;j<v+1;j++)
				{   
					
					a[i][j]=Math.min(a[i][j],a[i][k]+a[k][j]);
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
		}
	}
	
	/* Output
	 enter no of vertices
3
enter cost of 1 - 1
0
enter cost of 1 - 2
4
enter cost of 1 - 3
11
enter cost of 2 - 1
6
enter cost of 2 - 2
0
enter cost of 2 - 3
2
enter cost of 3 - 1
3
enter cost of 3 - 2
1000
enter cost of 3 - 3
0

original matrix
0 4 11
6 0 2
3 1000 0

k=1
0 4 11
6 0 2
3 7 0

k=2
0 4 6
6 0 2
3 7 0

k=3
0 4 6
5 0 2
3 7 0


Press any key to continue...*/