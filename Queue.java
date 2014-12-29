import java.io.*;
class Queue
{
	int a[],n,f,r;
	DataInputStream in=new DataInputStream(System.in);
	
	Queue() throws IOException
	{
		System.out.println("Enter the size of the array");
		n=Integer.parseInt(in.readLine());
		a=new int[n];
		f=-1;
		r=-1;
	}
	
	void add() throws IOException
	{
		int x;
		
		if(r==n-1)
		System.out.println("Queue full");
		
		else
		{
		System.out.println("enter value to be added");
		x=Integer.parseInt(in.readLine());
		r++;
		a[r]=x;
    
    if(f==-1)
    f++;
    System.out.println("value added successfully");
		}	
	}
	
	void delete()
	{
		if(f==-1)
		System.out.println("Queue empty");
		else
		{
			if(f==r)
			{
				f=-1;
				r=-1;
			}
			else
			{
				f++;
			}
			System.out.println("value deleted successfully");
		}
	}
	
	void display()
	{
		int i;
		
		if(f==-1)
		System.out.println("Queue empty");
		
		else
			for(i=f; i<=r; i++)
			System.out.println(a[i]);
		}
		
		public static void main(String args[])throws IOException
		{
			int op,c;
			DataInputStream in=new DataInputStream(System.in);
			Queue z= new Queue();
			
			do
			{
					System.out.println("Enter your choice");
				System.out.println("1.Add 2.Delete 3.Display");
				op=Integer.parseInt(in.readLine());
				
				switch(op)
				{
					case 1 : z.add();
					break;
					
					case 2 : z.delete();
					break;
					
					case 3 : z.display();
					break;
				}
				
				System.out.println("Enter 1 to continue 0 to exit");
				c=Integer.parseInt(in.readLine());
			}while(c==1);
		}
	}