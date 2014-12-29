import java.io.*;
class Stacks
{
	DataInputStream in = new DataInputStream(System.in);
	int a[],n,top;

	Stacks()throws IOException
	{
		System.out.println("enter array size");
		n=Integer.parseInt(in.readLine());
		a=new int[n];
		top=-1;
	}
	
	void push()throws IOException
	{
		
		if(top==(n-1))
		System.out.println("stack overflow");
		else
		{
		System.out.println("enter no to be added");
		int x=Integer.parseInt(in.readLine());	
		top++;
		a[top]=x;
	System.out.println("value added");
	}
}

 void pop()
 {
 	if(top==-1)
 	System.out.println("stack empty");
 	else
 	{
 	System.out.println("element deleted "+a[top]);
 	top--;
 }
}

void peek()
{
		if(top==-1)
	System.out.println("stack empty");
 	else
 	System.out.println("element on top "+a[top]);
 }
 
 void display()
 {
 	if(top==-1)
	System.out.println("stack empty");
 	else
 	{
 		for(int i=0;i<=top;i++)
 		System.out.println(a[i]);
 	}
 }
 
 public static void main(String args[])throws IOException
 {
 	DataInputStream in = new DataInputStream(System.in);
 	int option,choice;
 	Stacks s=new Stacks();
 	do
 	{
 		
 	System.out.println("Menu");
 	System.out.println("1.Push \n2.Pop \n3.Peek \n4.Display");
 	System.out.println("enter your option");
 	option=Integer.parseInt(in.readLine());
 	
 	switch(option)
 	{
 		case 1: s.push();
 		   break;
 		   
 		case 2: s.pop();
 		   break;
 		  
 		case 3: s.peek();
 		   break;   
 		   
 		case 4: s.display();
 		   break;
 		 
 		 default:	System.out.println("Invalid option");
 		 break;
 	}
 		System.out.println("enter 1 to continue 0 to exit");
 	  choice=Integer.parseInt(in.readLine());
 	}while(choice==1);
 	}
 }