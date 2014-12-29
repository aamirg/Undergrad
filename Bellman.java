import java.io.*;
import java.lang.*;
class Bellman
{
	public static void main(String args[])throws IOException
	{
		DataInputStream in=new DataInputStream(System.in);
		System.out.println("enter no of nodes");
		int n=Integer.parseInt(in.readLine());
		int i,k,j,o,v,p,q,u;
		
		int cost[][]=new int[n+1][n+1];
		int adj[][]=new int[n+1][n+1];
		int dist[]=new int[n+1];
		
		 System.out.println("enter no of edges ");
		 int edge=Integer.parseInt(in.readLine());
			for(o=0;o<edge;o++)	
		{
			System.out.println("enter u & v for an edge");
			p=Integer.parseInt(in.readLine());
			q=Integer.parseInt(in.readLine());
			adj[p][q]=1;
		}
		for(i=1;i<n+1;i++)
		{
			for(j=1;j<n+1;j++)
			{
				if(adj[i][j]==1)
				{
				System.out.println("enter cost of "+i+" - "+j);
			 	cost[i][j]=Integer.parseInt(in.readLine());
				}
			}
		}
	System.out.println("enter source -");
   v=Integer.parseInt(in.readLine());
   System.out.println("enter destination -");
   u=Integer.parseInt(in.readLine());
  
   for(i=1;i<=n;i++)
	dist[i]=cost[v][i];
	
		for(k=2;k<=n-1;k++)
		{
		 	for(i=1;i<=n;i++)
		 	{
		 		if(adj[i][u]==1)
		 		{
		 			  if(dist[u]>dist[i]+cost[i][u])
		 	  	{
		 	  		dist[u]=dist[i]+cost[i][u];
		 		}
		 		}	 	
			}	 	
		}
		System.out.println();
	System.out.println(dist[u]+" ");
}	 
}

/*Output
 
 enter no of nodes
3
enter no of edges
3
enter u & v for an edge
1
2
enter u & v for an edge
1
3
enter u & v for an edge
2
3
enter cost of 1 - 2
2
enter cost of 1 - 3
5
enter cost of 2 - 3
-5
enter source -
1
enter destination -
3

-3
Press any key to continue...
*/