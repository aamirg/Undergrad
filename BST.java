import java.io.*;
class Node
{
	int data;
	Node l,r;
	Node()
	{
		 l=null;
		 r=null;
	}
}

class BST
{
	Node root=null;
	DataInputStream in=new DataInputStream(System.in);
	public static void main(String args[])throws IOException
	{
		DataInputStream in=new DataInputStream(System.in);
		BST b=new BST();
		int a,option;
		do
		{
			System.out.println("Menu");
			System.out.println("1.Add a node \n2.Display ");
				System.out.println("Enter your option");
				 option=Integer.parseInt(in.readLine());
				
				switch(option)
				{
					case 1:System.out.println("Enter value to be added");
					int x=Integer.parseInt(in.readLine());
					Node temp=new Node();
					temp.data=x;
					temp.l=null;
					temp.r=null;
					
					if(b.root==null)
					{
						b.root=temp;
						System.out.println("Tree created successfully");
					}
					else
					b.insert(b.root,temp);
					 break;
					 
					 case 2:System.out.println("Sub-menu");
					 System.out.println("1.Preorder \n2.Inorder \n3.Postorder");
					 System.out.println("Enter your option");
					 int op=Integer.parseInt(in.readLine());
					 
					 if(b.root==null)
					 System.out.println("Tree empty");
					 else
					 b.display(b.root,op);
					 break;
				}
				System.out.println("enter 1 to continue 0 to exit");
				  a=Integer.parseInt(in.readLine());
			}while(a==1);
		}
		
		void insert(Node root,Node temp)throws IOException
		{
			System.out.println("Sub-menu");
			System.out.println("1.Add at left \n2.Add at right");
			System.out.println("enter your choice");
			int op=Integer.parseInt(in.readLine());
			
			switch(op)
			{
				case 1:if(root.l==null)
			          root.l=temp;
			          
			          else
			          insert(root.l,temp);
			          break;
			          
			 case 2:if(root.r==null)
			          root.r=temp;
			          
			          else
			          insert(root.r,temp);
			          break;    
			   }
			   System.out.println("Node added");
			 }
			 
			 void display(Node root,int op)throws IOException
			 {
			 	if(root!=null)
			 	switch(op)
			 	{
			 		
			 		case 1: System.out.println(root.data);
			 		display(root.l,op);
			 		display(root.r,op);
			 		break;
			 		
			 		case 2:display(root.l,op);
			 		System.out.println(root.data);
			 		display(root.r,op);
			 		break;
			 		
			 		case 3: display(root.l,op);
			 		display(root.r,op);
			 		System.out.println(root.data);
			 		break;
			 	}
			 }
		}