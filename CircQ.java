import java.io.*;
class CircQ
{
	int n,f,r,count,a[];
	DataInputStream in=new DataInputStream(System.in);
	
	CircQ()throws IOException
	{
		System.out.println("enter array size");
		n=Integer.parseInt(in.readLine());
		a=new int[n];
		count=0;
		f=-1;
		r=-1;
	}
	
	void add()throws IOException
	{
		if(count==n)
		System.out.println("Queue full");
		
		else
		{
			System.out.println("Enter value to be added");
			int x=Integer.parseInt(in.readLine());
			
			if((r==(n-1))&&(count!=n))
			{
				r=0;
				a[r]=x;
				count++;
				System.out.println("value added");
			}
			else
			{
				r++;
				a[r]=x;
				count++;
				System.out.println("value added");
		 }
			if(f==-1)
			f++;
		}
	}
	
	void del()
	{
		if(count==0)
		System.out.println("Queue empty");
		
		else
		{
			if(count==1)
			{
				f=-1;
				r=-1;
				count--;
				System.out.println("value deleted");
			}
			
			else
			{
				if(f==(n-1))
				{
					f=0;
					count--;
					System.out.println("value deleted");
				}
				else
				{
					f++;
					count--;
					System.out.println("value deleted");
				}
			}
		}
	}
	
	void display()
	{
		int i;
		if(count==0)
		System.out.println("Queue empty");
		else
		{
			if(f<=r)
			for(i=f;i<=r;i++)
			System.out.println(a[i]);
			
			else
			{
				for(i=f;i<n;i++)
				System.out.println(a[i]);
				for(i=0;i<=r;i++)
				System.out.println(a[i]);
			}
		}
	}
	
	public static void main(String args[])throws IOException
	{
		DataInputStream in=new DataInputStream(System.in);
		int option,choice;
		CircQ s = new CircQ();
		
		do
		{
			
			System.out.println("Enter your choice");
			System.out.println("1.Add 2.Delete 3.Display");
			option=Integer.parseInt(in.readLine());
			
			switch(option)
			{
				case 1: s.add();
				break;
				case 2: s.del();
				break;
				case 3: s.display();
				break;
			}
			System.out.println("Enter 1 to continue 0 to exit");
			choice=Integer.parseInt(in.readLine());
		}while(choice==1);
	}
}
			
		
		