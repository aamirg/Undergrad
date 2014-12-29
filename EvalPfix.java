import java.io.*;
class EvalPfix
{
	int stack[];
	char postfix[];
	int i,n,top,a,b,c;
	DataInputStream in=new DataInputStream(System.in);
	
	EvalPfix()throws IOException
	{
		System.out.println("enter array size");
		n=Integer.parseInt(in.readLine());
		stack=new int[n];
		postfix=new char[n];
		top=-1;
		i=-1;
	}
	
	void readpf()throws IOException
	{
		char p;
		System.out.println("enter the expression");
		do
		{
			p=(char)in.read();
			i++;
			postfix[i]=p;
		}
		while(p!='\n');
		postfix[i]='\0';
	}
	
	boolean isoperand(char c)
	{
		if ((c>='0')&&(c<='9'))
		return true;
		else
		return false;
	}
	
	void compute()
	{
		for(i=0;postfix[i+1]!='\0';i++)
		
		if(isoperand(postfix[i]))
		{
			top++;
			stack[top]=(int)(postfix[i]-'0');
		}
		else
		{
			a=stack[top];
			top--;
			b=stack[top];
			
			switch(postfix[i])
			{
				case '+' : c=b+a;
				stack[top]=c;
				break;
				
				case '-' : c=b-a;
				stack[top]=c;
				break;
				
				case '*' : c=b*a;
				stack[top]=c;
				break;
				
				case '/' : c=b/a;
				stack[top]=c;
				break;
			}
		}
		System.out.println("value of the expression is "+stack[top]);
	}
	public static void main(String args[])throws IOException
	{
		EvalPfix p=new EvalPfix();
	p.readpf();
	p.compute();
}
}