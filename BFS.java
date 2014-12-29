import java.io.*;
class Queue
{
	int f,r;
	int items[]=new int[10];

	Queue()
	{
		f=0;
		r=-1;
	}
	
	void insert(int e)
	{
		if(r==9)
		System.out.println("Queue full");
		else
		{
			r++;
			items[r]=e;
		}
		
	}
	
	int empty()
	{
		if(r<f)
		return 1;
		else 
		return 0;
	}

	int remove()
	{
		int x=0;
		if(empty()==1)
			{
				System.out.println("Queue empty");
			return 0;
		}
			else
			{
				x=items[f];
				f++;
				return x;
			}
		}
		}
	
	class Graph
	{
		int adj[][]=new int[10][10];
		int visited[]=new int[10];
		Queue q =new Queue();
		DataInputStream in=new DataInputStream(System.in);
		
		void creategraph()throws IOException
		{
			int c,n,i,j,parent,adj_parent,initial_node;
			int ans=0,ans1=0;
			System.out.println("Enter no of graph nodes");
			n=Integer.parseInt(in.readLine());
			
				for(i=1;i<=n;i++)
				for(j=1;j<=n;i++)
				adj[i][j]=0;
				
				for(c=1;c<=10;i++)
				visited[c]=0;
				
				System.out.println("Enter graph structure for BFS");
				
				do
				{
						System.out.println("Enter Parent node");
						parent=Integer.parseInt(in.readLine());
						
						do
						{
							System.out.println("Enter adjacent node to "+parent);
							adj_parent=Integer.parseInt(in.readLine());
							
							adj[parent][adj_parent]=1;
							adj[adj_parent][parent]=1;
							
							System.out.println("Press 1 to Enter more adjacent nodes to "+parent);
							ans1=Integer.parseInt(in.readLine());
						}
						while(ans1==1);
						
						System.out.println("Press 1 to Enter graph node");
						ans=Integer.parseInt(in.readLine());
					}
					while(ans==1);
					
					System.out.println("Adjacency matrix is ");
					for(i=1;i<=n;i++)
					{
					for(j=1;j<=n;j++)
					System.out.println(adj[i][j]);
					
					System.out.println("\n");
				}
				
				System.out.println("enter initial node for traversal");
				initial_node=Integer.parseInt(in.readLine());
				bfs(initial_node,n);
			}
			
			void bfs(int initial_node,int n)
			{
				int u,i;
				q.insert(initial_node);
				u=initial_node;
				visited[initial_node]=1;
				System.out.println("Bfs traversal is: ");
				System.out.println(initial_node);
				
				
				while(q.empty()==0)
				{
					u=q.remove();
					for(i=1;i<=n;i++)
					if((adj[u][i]==1)&&(visited[i]==0))
					{
					 q.insert(i);
					 visited[i]=1;
						System.out.println(" "+i);
					}
				}
			}
		}	
			class BFS
			{
				public static void main(String args[])throws IOException
				{
					Graph g=new Graph();
					g.creategraph();
				}
			}
				
				