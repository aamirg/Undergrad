import java.io.*;
class B1
{
	static int n,m;
	static int a[];
	static int w[],safe[];
	static boolean f[];
	static int max[][],need[][],all[][];
	public static void main(String args[])throws IOException
	{
		DataInputStream in = new DataInputStream(System.in);
		System.out.println("Enter No. of Processes");
		n=Integer.parseInt(in.readLine());
		System.out.println("Enter No. of Resources");
		m=Integer.parseInt(in.readLine());
		a=new int[m];
		max=new int[n][m];
		need=new int[n][m];
		all=new int[n][m];
		w=new int[m];
		f=new boolean[n];
		safe=new int[n];
		int i,j;
		for(i=0;i<m;i++)
		{
			System.out.println("Enter No. of Available Resource of "+(i+1));
			a[i]=Integer.parseInt(in.readLine());
		}
		for(i=0;i<m;i++)
		{
			w[i]=a[i];
		}
		for(i=0;i<n;i++)
		{
			System.out.println("Enter Allocated Row for Process "+(i+1));
			for(j=0;j<m;j++)
			{
				all[i][j]=Integer.parseInt(in.readLine());
			}
		}

		for(i=0;i<n;i++)
		{
			System.out.println("Enter Max Row for Process "+(i+1));
			for(j=0;j<m;j++)
			{
				max[i][j]=Integer.parseInt(in.readLine());
			}
		}
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
				need[i][j]=max[i][j]-all[i][j];
			}
		}
		System.out.println();
		System.out.println("Allocated Matrix");
		for(i=0;i<n;i++)
		{
			System.out.println();
			for(j=0;j<m;j++)
			{
				System.out.print(all[i][j]+" ");
			}
		}

		System.out.println();
		System.out.println("Max Matrix");
		for(i=0;i<n;i++)
		{
			System.out.println();
			for(j=0;j<m;j++)
			{
				System.out.print(max[i][j]+" ");
			}
		}

		System.out.println();
		System.out.println("Need Matrix");
		for(i=0;i<n;i++)
		{
			System.out.println();
			for(j=0;j<m;j++)
			{
				System.out.print(need[i][j]+" ");
			}
		}
		System.out.println();
		System.out.println();
		safestate();
	}
	static void safestate()
	{
		int i,j;
		int pos=0;
		for(i=0;i<n;i++)
		{
			f[i]=false;
		}
		for(int l=0;l<n;l++)
		{
			for(i=0;i<n;i++)
			{
				if(f[i]==false)
				{
					for(j=0;j<m;j++)
					{
						if(need[i][j]<=w[j])
						{
						}
						else
							break;
					}
					if(j==m)
					{
						f[i]=true;
						safe[pos++]=i;
						for(j=0;j<m;j++)
						{
							w[j]=w[j]+all[i][j];
							System.out.print(w[j]+" ");
						}
						System.out.println();
					}
				}
			}
		}
		for(i=0;i<n;i++)
		{
			if(f[i]==true)
			{
			}
			else
				break;
		}
		if(i<n)
		{
			System.out.println("Not in Safe State");
		}
		else
		{
			System.out.println("Safe State is");
			for(int k=0;k<n;k++)
				System.out.println(++safe[k]);
		}
	}
}
/*
Output:-
--------------------Configuration: <Default>--------------------
Enter No. of Processes
5
Enter No. of Resources
3
Enter No. of Available Resource of 1
3
Enter No. of Available Resource of 2
3
Enter No. of Available Resource of 3
2
Enter Allocated Row for Process 1
0
1
0
Enter Allocated Row for Process 2
2
0
0
Enter Allocated Row for Process 3
3
0
2
Enter Allocated Row for Process 4
2
1
1
Enter Allocated Row for Process 5
0
0
2
Enter Max Row for Process 1
7
5
3
Enter Max Row for Process 2
3
2
2
Enter Max Row for Process 3
9
0
2
Enter Max Row for Process 4
2
2
2
Enter Max Row for Process 5
4
3
3

Allocated Matrix

0 1 0
2 0 0
3 0 2
2 1 1
0 0 2
Max Matrix

7 5 3
3 2 2
9 0 2
2 2 2
4 3 3
Need Matrix

7 4 3
1 2 2
6 0 0
0 1 1
4 3 1

5 3 2
7 4 3
7 4 5
7 5 5
10 5 7
Safe State is
2
4
5
1
3

Process completed.


Output:-
--------------------Configuration: <Default>--------------------
Enter No. of Processes
5
Enter No. of Resources
4
Enter No. of Available Resource of 1
1
Enter No. of Available Resource of 2
0
Enter No. of Available Resource of 3
2
Enter No. of Available Resource of 4
0
Enter Allocated Row for Process 1
3
0
1
1
Enter Allocated Row for Process 2
0
1
0
0
Enter Allocated Row for Process 3
1
1
1
0
Enter Allocated Row for Process 4
1
1
0
1
Enter Allocated Row for Process 5
0
0
0
0
Enter Max Row for Process 1
4
1
1
1
Enter Max Row for Process 2
0
2
1
2
Enter Max Row for Process 3
4
2
1
0
Enter Max Row for Process 4
1
1
1
1
Enter Max Row for Process 5
2
1
1
0

Allocated Matrix

3 0 1 1
0 1 0 0
1 1 1 0
1 1 0 1
0 0 0 0
Max Matrix

4 1 1 1
0 2 1 2
4 2 1 0
1 1 1 1
2 1 1 0
Need Matrix

1 1 0 0
0 1 1 2
3 1 0 0
0 0 1 0
2 1 1 0

2 1 2 1
2 1 2 1
5 1 3 2
5 2 3 2
6 3 4 2
Safe State is
4
5
1
2
3

Process completed.


Output:-
--------------------Configuration: <Default>--------------------
Enter No. of Processes
5
Enter No. of Resources
4
Enter No. of Available Resource of 1
2
Enter No. of Available Resource of 2
1
Enter No. of Available Resource of 3
0
Enter No. of Available Resource of 4
0
Enter Allocated Row for Process 1
0
0
1
2
Enter Allocated Row for Process 2
2
0
0
0
Enter Allocated Row for Process 3
0
0
3
4
Enter Allocated Row for Process 4
2
3
5
4
Enter Allocated Row for Process 5
0
3
3
2
Enter Max Row for Process 1
0
0
1
2
Enter Max Row for Process 2
2
7
5
0
Enter Max Row for Process 3
6
6
5
6
Enter Max Row for Process 4
4
3
5
6
Enter Max Row for Process 5
0
6
5
2

Allocated Matrix

0 0 1 2
2 0 0 0
0 0 3 4
2 3 5 4
0 3 3 2
Max Matrix

0 0 1 2
2 7 5 0
6 6 5 6
4 3 5 6
0 6 5 2
Need Matrix

0 0 0 0
0 7 5 0
6 6 2 2
2 0 0 2
0 3 2 0

2 1 1 2
4 4 6 6
4 7 9 8
6 7 9 8
6 7 12 12
Safe State is
1
4
5
2
3

Process completed.

*/