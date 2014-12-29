import java.io.*;
class Node
{
	int data;
	Node link;
	Node()
	{
		link=null;
	}
}

class DLL
{
	Node p=null;
	DataInputStream in=new DataInputStream(System.in);
	
	void append()throws IOException
	{
		int x;
		Node q;
		System.out.println("enter the value to be added");
			x=Integer.parseInt(in.readLine());
			Node temp =new Node();
			temp.data=x;
			temp.link=null;
			
			if(p==null)
			{
				System.out.println("creating list");
				p=temp;
				System.out.println("value added");
			}
			else
			{
				q=p;
				
				while(q.link!=null)
				q=q.link;
				
				q.link=temp;
		System.out.println("value added successfully");
	}
}

 		void inbegin()throws IOException
 		{
 			int x;
 			System.out.println("enter the value to be added");
			x=Integer.parseInt(in.readLine());
			Node temp =new Node();
			temp.data=x;
			temp.link=p;
			p=temp;
		System.out.println("value added");
	}
		
		void display()
		{
			Node q;
			q=p;
			if(p==null)
			System.out.println("List empty");
			
			else
			{
				int c=0;
				while(q!=null)
				{
					c++;
					System.out.println(q.data);
					q=q.link;
				}
				System.out.println("total no of nodes "+c);
			}
		}	
		
		void delete()throws IOException
		{
		int x;
		Node q,old;
		boolean found=false;
		System.out.println("Enter value to be deleted");
		x=Integer.parseInt(in.readLine());
		q=p;
		old=p;
		
		if(p==null)
		System.out.println("List empty");
		
		else
		{
			while(q!=null)
			{
				if(q.data==x)
				{
					if(q==p)
					{
						p=q.link;
						found=true;
					}
					
					else
					{
						old.link=q.link;
						q=null;
						found=true;
					}
				}
				else
				{
				old=q;
				q=q.link;
			}
		}
	}
	if(found==true)
		System.out.println("element deleted");
		else
		System.out.println("element not found");
	}
		
	public static void main(String args[])throws IOException
	{
		DLL a=new DLL();
		DataInputStream in=new DataInputStream(System.in);
		int op,c;
		
			do
		{
			System.out.println("Enter your choice");
			System.out.println("1.Append 2.Add in Beginning 3.Delete 4.Display");
			op=Integer.parseInt(in.readLine());
			
			switch(op)
			{
				case 1: a.append();
				break;
				case 2: a.inbegin();
				break;
				case 3: a.delete();
				break;
				case 4: a.display();
				break;
			}
			System.out.println("Enter 1 to continue 0 to exit");
			c=Integer.parseInt(in.readLine());
		}while(c==1);
	}
}