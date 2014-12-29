import java.io.*;
class Node
{
	int data;
	Node prev,next;
	Node()
	{
		prev=null;
		next=null;
	}
}

class DoublyLL
{
	Node p=null;
	DataInputStream in=new DataInputStream(System.in);
	
	void append()throws IOException
	{
		Node q;
		int x;
		
		System.out.println("enter the value to be added");
			x=Integer.parseInt(in.readLine());
			
			Node temp=new Node();
			temp.data=x;
			
			if(p==null)
			{
				System.out.println("creating the list");
				p=temp;
				System.out.println("Node added");
			}
			else
			{
				q=p;
				
				while(q.next!=null)
				q=q.next;
				
				temp.prev=q;
				q.next=temp;
				System.out.println("Node added");
			}
		}
		
		void inbegin()throws IOException
		{
			int x;
			System.out.println("enter the value to be added");
			x=Integer.parseInt(in.readLine());
			Node temp=new Node();
			temp.data=x;
			
			temp.next=p;
			p.prev=temp;
			p=temp;
			System.out.println("Node added");
			
	}
	
	void delete()throws IOException
	{
		Node q;
		int x;
		System.out.println("enter the value to be deleted");
			x=Integer.parseInt(in.readLine());
			boolean found=false;
		q=p;
		if(q==null)
		System.out.println("list doesnt exist");
		else
		{
			while(q!=null)
			{
				if(q.data==x)
				{
					if(q==p)
					{
						p=q.next;
						
					if(p!=null)
					p.prev=null;
					
					found=true;
					break;
				}
				else
				{
					(q.prev).next=q.next;
					(q.next).prev=q.prev;
					found=true;
					q=p;
				}
			}
			else
				q=q.next;
			}
		}
	}
		void display()
		{
			Node q;
			q=p;
			if(q==null)
		System.out.println("list doesnt exist");
		else
		{
			while(q!=null)
			{
				System.out.println(q.data);
				q=q.next;
			}
		}
	}
	
	public static void main(String args[])throws IOException
	{
		DoublyLL a=new DoublyLL();
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