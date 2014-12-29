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
		int i,j=0;
		int n,m;
		int adj[][]=new int[v+1][v+1];
		int cost[][]=new int[v+1][v+1];
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
		/*
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
		/*int v1=Integer.parseInt(in.readLine());
		int u1=Integer.parseInt(in.readLine());*/
		adj[1][2]=1;
		adj[1][3]=1;
		adj[1][4]=1;
		adj[2][5]=1;
		adj[3][2]=1;
		adj[3][5]=1;
		adj[4][6]=1;
		adj[4][3]=1;
		adj[5][7]=1;
		adj[6][7]=1;


		cost[1][2]=6;
		cost[1][3]=5;
		cost[1][4]=5;
		cost[2][5]=-1;
		cost[3][2]=-2;
		cost[3][5]=1;
		cost[4][3]=-2;
		cost[4][6]=-1;
		cost[5][7]=3;
		cost[6][7]=3;

		for(i=1;i<=7;i++)
			for(j=1;j<=7;j++)
		Bellman(i,j,cost,adj,v);
	}
	static void Bellman(int v,int u1,int cost[][],int adj[][],int n)
	{
		int i,u,k;
		int dist[]=new int[n+1];
		for(i=1;i<=n;i++)
		dist[i]=cost[v][i];
		for(k=2;k<=7;k++)
		{
				for(i=1;i<=7;i++)
					for(u=1;u<=7;u++)
					if(adj[i][u]==1)
						if(dist[u]>dist[i]+cost[i][u])
							dist[u]=dist[i]+cost[i][u];
		}
		System.out.println("Answer for  "+v+" to "+u1+" is "+dist[u1]);
	}
}
/*
Output:-
Enter The No. of Vertices
7
Enter The No. of Edges
10
Answer for  1 to 1 is 0
Answer for  1 to 2 is 1
Answer for  1 to 3 is 3
Answer for  1 to 4 is 5
Answer for  1 to 5 is 0
Answer for  1 to 6 is 4
Answer for  1 to 7 is 3
Answer for  2 to 1 is 1000
Answer for  2 to 2 is 0
Answer for  2 to 3 is 998
Answer for  2 to 4 is 1000
Answer for  2 to 5 is -1
Answer for  2 to 6 is 999
Answer for  2 to 7 is 2
Answer for  3 to 1 is 1000
Answer for  3 to 2 is -2
Answer for  3 to 3 is 0
Answer for  3 to 4 is 1000
Answer for  3 to 5 is -3
Answer for  3 to 6 is 999
Answer for  3 to 7 is 0
Answer for  4 to 1 is 1000
Answer for  4 to 2 is -4
Answer for  4 to 3 is -2
Answer for  4 to 4 is 0
Answer for  4 to 5 is -5
Answer for  4 to 6 is -1
Answer for  4 to 7 is -2
Answer for  5 to 1 is 1000
Answer for  5 to 2 is 996
Answer for  5 to 3 is 998
Answer for  5 to 4 is 1000
Answer for  5 to 5 is 0
Answer for  5 to 6 is 999
Answer for  5 to 7 is 3
Answer for  6 to 1 is 1000
Answer for  6 to 2 is 996
Answer for  6 to 3 is 998
Answer for  6 to 4 is 1000
Answer for  6 to 5 is 995
Answer for  6 to 6 is 0
Answer for  6 to 7 is 3
Answer for  7 to 1 is 1000
Answer for  7 to 2 is 996
Answer for  7 to 3 is 998
Answer for  7 to 4 is 1000
Answer for  7 to 5 is 995
Answer for  7 to 6 is 999
Answer for  7 to 7 is 0

Process completed.
*/
