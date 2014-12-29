import java.io.*;
import java.lang.*;
class BF
{
	public static void main(String args[])throws IOException
	{
		DataInputStream in=new DataInputStream(System.in);
		System.out.println("Enter The No. of Vertices");
		int v=Integer.parseInt(in.readLine());
		System.out.println("Enter The No. of Edges");
		int e=Integer.parseInt(in.readLine());
		int i=0,j=0;
		int n,m,k,u;
		int adj[][]=new int[v+1][v+1];
		int cost[][]=new int[v+1][v+1];
		int d[]=new int[v+1];
		for(i=1;i<=v;i++)
		{
			for(j=1;j<=v;j++)
			{
				adj[i][j]=0;
				if(i==j)
					cost[i][j]=0;
				else
					cost[i][j]=1000;
			}
		}
		for(i=0;i<e;i++)
		{
			System.out.println("Enter u and v if they are connected");
		    n=Integer.parseInt(in.readLine());
		    m=Integer.parseInt(in.readLine());
		    adj[n][m]=1;
        }
		for(i=1;i<=v;i++)
		for(j=1;j<=v;j++)
		{
			if(adj[i][j]==1)
			{
				System.out.println("Enter the weight of edge"+"["+i+"]"+"["+j+"]");
			    cost[i][j]=Integer.parseInt(in.readLine());
			}

		}
		System.out.println("\n");
		System.out.println("Enter Source and Destination");
		int v1=Integer.parseInt(in.readLine());
		int u1=Integer.parseInt(in.readLine());
		for(i=1;i<=v;i++)
			d[i]=cost[v1][i];
		for(k=2;k<v;k++)
		{
			for(u=1;u<=v;u++)
			{
				if(u!=v1)
				for(i=1;i<=v;i++)
					if(adj[i][u]==1)
						if(d[u]>d[i]+cost[i][u])
							d[u]=d[i]+cost[i][u];
			}
		}
		for(i=1;i<=v;i++)
		System.out.println("Minimum Distance from 1-"+i+"is  "+d[i]);
	}
}
/*
Output:-
--------------------Configuration: <Default>--------------------
Enter The No. of Vertices
7
Enter The No. of Edges
10
Enter u and v if they are connected
1
2
Enter u and v if they are connected
1
3
Enter u and v if they are connected
1
4
Enter u and v if they are connected
2
5
Enter u and v if they are connected
3
2
Enter u and v if they are connected
3
5
Enter u and v if they are connected
4
3
Enter u and v if they are connected
4
6
Enter u and v if they are connected
5
7
Enter u and v if they are connected
6
7
Enter the weight of edge[1][2]
6
Enter the weight of edge[1][3]
5
Enter the weight of edge[1][4]
5
Enter the weight of edge[2][5]
-1
Enter the weight of edge[3][2]
-2
Enter the weight of edge[3][5]
1
Enter the weight of edge[4][3]
-2
Enter the weight of edge[4][6]
-1
Enter the weight of edge[5][7]
3
Enter the weight of edge[6][7]
3


Enter Source and Destination
1
7
Minimum Distance from 1-1is  0
Minimum Distance from 1-2is  1
Minimum Distance from 1-3is  3
Minimum Distance from 1-4is  5
Minimum Distance from 1-5is  0
Minimum Distance from 1-6is  4
Minimum Distance from 1-7is  3

Process completed.
*/






