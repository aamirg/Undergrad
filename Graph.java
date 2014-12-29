import java.io.*;
class Queue
{
	int a[]=new int[10];
	int front,rear;
	Queue()
	{
		front=0;
		rear=-1;
	}
	void insert(int e)
	{
		if(rear==9)
		System.out.println("Queue Overflow");
		else
		a[++rear]=e;
	}
	int empty()
	{
		return(rear<front?1:0);
	}
	int remove()
	{
		int x=0;
		if(empty()==1)
		{
			System.out.println("Queue Overflow");
			return 0;
		}
		else
		{
			x=a[front++];
			return x;
		}
	}
}
class Stack
{
	int stk[]=new int[10];
	int top;
	Stack()
	{
		top=-1;
	}
	void push (int item)
	{
		if (top==9)
			System.out.println("Stack overflow");
		else
			stk[++top]=item;
	}
	boolean isempty()
	{
		if (top<0)
			return true;
		else
			return false;
	}
	int pop()
	{
		if (isempty())
		{
			System.out.println("Stack underflow");
			return 0;
		}
		else
			return (stk[top--]);
	}
}
class Graph1
{
	int max=10;
	int adj[][]=new int[max][max];
	int visited[]=new int[max];
	Queue q=new Queue();
	Stack s=new Stack();
	void createGraph()throws IOException
	{
		int ch;
		int n,i,j,parent,adjparent,initialnode;
		int ans=0,ans1=0;
		System.out.println("Enter Total No. of Elements in an Undirected Graph");
		n=getNumber();
		for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		adj[i][j]=0;
		for(int c=0;c<n;c++)
		visited[c]=0;
		System.out.println("Enter Graph Structure");
		do
		{
			System.out.println("Enter Parent node:");
			parent=getNumber();
			do
			{
				System.out.println("Enter Adjacent node for node "+parent+" :");
				adjparent=getNumber();
				adj[parent][adjparent]=1;
				adj[adjparent][parent]=1;
				System.out.println("Conitnue to add adjacent node for "+parent+" (1/0)?");
				ans1=getNumber();
			}
			while(ans1!=0);
			System.out.println("Continue to add Graph nodes? (1/0)");
			ans=getNumber();
		}
		while(ans!=0);
		System.out.println("Adjacency Matrix For your Graph is");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			System.out.print("  "+adj[i][j]);
			System.out.println();
		}
		System.out.println("Your Undirected Graph is:");
		for(i=1;i<=n;i++)
		{
			System.out.print("Vertex "+i+" is connected to :");
			for(j=1;j<=n;j++)
			{
				if(adj[i][j]==1)
				System.out.print(" "+j);
			}
			System.out.println();
		}
		System.out.println("Enter Initial Node for Traversal :");
		initialnode=getNumber();
		System.out.println("Enter your Choice");
		System.out.println("1.DSF  2.BSF");
		ch=getNumber();
		switch(ch)
			{
				case 1:dfs(initialnode,n);break;
				case 2:bfs(initialnode,n);break;
				default:System.out.println("Wrong Choice");
		    } 
	}
	void bfs(int initialnode,int n)
	{
		int u,i;
		u=initialnode;
		visited[initialnode]=1;
		System.out.println("BFS Traversal for Given Graph is :");
		System.out.print(initialnode);
		q.insert(initialnode);
		while(q.empty()==0)
		{
			u=q.remove();
			for(i=1;i<=n;i++)
			{
		    	if((adj[u][i]==1)&&(visited[i]==0))
				{
					q.insert(i);
					visited[i]=1;
					System.out.print("  "+i);
				}
			}
		}
		System.out.println();
	}
	void dfs(int initial_node,int n)
	{
		int u,i;
		s.top = -1;
		s.push(initial_node);
		System.out.println("\nDFS traversal for given graph is : ");
		while(!s.isempty())
		{
			u=s.pop();
			if(visited[u]==0)
			{
				System.out.print("\n"+u);
				visited[u]=1;
			}
			for (i=1;i<=n;i++)
			{
				if((adj[u][i]==1) && (visited[i]==0))
				{
					s.push(u);
					visited[i]=1;
					System.out.print(" "+i);
					u = i;
				}
			}
		}
		System.out.println();
	}
	int getNumber()throws IOException
	{
		DataInputStream in=new DataInputStream(System.in);
		int ne=Integer.parseInt(in.readLine());
		return ne;
	}
}
class Graph
{
	public static void main(String args[])throws IOException
	{
		Graph1 g=new Graph1();
		g.createGraph();
	}
}
	