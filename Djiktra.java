	import java.io.*;
	class Djiktra
	{
		static	int adj[][]=new int[10][10];
		static	int weight [][]=new int[10][10];
		static	int path[]=new int[10];
		
	public static void main(String args[])throws IOException
	{
	DataInputStream in=new DataInputStream(System.in);
	System.out.println("enter no of nodes");
	int no=Integer.parseInt(in.readLine());
	System.out.println("enter no of Edges");
	int e=Integer.parseInt(in.readLine());
	int i,j;
	for(i=1;i<=no;i++)
	{
		for(j=1;j<=no;j++)
		{
			adj[i][j]=0;
			weight[i][j]=0;
		}
	}
	
	for(i=1;i<=e;i++)
	{
		System.out.println("enter nodes connected");
		int n=Integer.parseInt(in.readLine());
		int m=Integer.parseInt(in.readLine());
		adj[n][m]=1;
	}
	
	for(i=1;i<=no;i++)
	{
		for(j=1;j<=no;j++)
		{
			if(adj[i][j]==1)
			{
			System.out.println("enter weight of Edges"+i+"-"+j);
			weight[i][j]=Integer.parseInt(in.readLine());
		}
	}
  }

	shortestpath(1,no);
	}	

	static void shortestpath(int s,int t)
	{
	int i,dc,newdist,mindist,current;
	int dist[]=new int[10];
	int nodeset[]=new int[10];
	final int inf=32767;
	int l,x;
	int no=t;
	
	for(i=1;i<=no;i++)
	{
		dist[i]=inf;
		nodeset[i]=0;
	}
	current=s;
	dist[current]=0;
	nodeset[current]=1;
	
	while(current!=t)
	{
		dc=dist[current];
		for(i=1;i<=no;i++)
		{
			if(adj[current][i]==1&&(nodeset[i]==0))
			{
				newdist=dc+weight[current][i];
				if(newdist<dist[i])
				{
					dist[i]=newdist;
					path[i]=current;
				}
			}
		}
			mindist=inf;
			for(i=1;i<=no;i++)
			{
				if(nodeset[i]==0&&dist[i]<mindist)
				{
					mindist=dist[i];
					current=i;
				}
			}
			nodeset[current]=1;
	 }
	 
	 System.out.println(dist[t]);
	 l=t;
	 do
	 {
	 	x=path[l];
	 	System.out.println("The path in reverse is- "+l+" "+x);
	 	l=x;
	 }
	 while(l!=s);
	}
	}
	
	/*Output
	enter no of nodes
	8
	enter no of Edges
	14
	enter nodes connected
	1
	2
	enter nodes connected
	1
	3
	enter nodes connected
	1
	4
	enter nodes connected
	2
	3
	enter nodes connected
	2
	5
	enter nodes connected
	3
	6
	enter nodes connected
	3
	8
	enter nodes connected
	4
	7
	enter nodes connected
	5
	3
	enter nodes connected
	5
	8
	enter nodes connected
	6
	4
	enter nodes connected
	6
	8
	enter nodes connected
	7
	6
	enter nodes connected
	7
	8
	enter weight of Edges1-2
	1
	enter weight of Edges1-3
	7
	enter weight of Edges1-4
	5
	enter weight of Edges2-3
	8
	enter weight of Edges2-5
	2
	enter weight of Edges3-6
	2
	enter weight of Edges3-8
	7
	enter weight of Edges4-7
	2
	enter weight of Edges5-3
	3
	enter weight of Edges5-8
	15
	enter weight of Edges6-4
	1
	enter weight of Edges6-8
	7
	enter weight of Edges7-6
	1
	enter weight of Edges7-8
	1
	8
	The path in reverse is- 8 7
	The path in reverse is- 7 4
	The path in reverse is- 4 1
	Press any key to continue...
	*/