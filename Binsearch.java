import java.io.*;
class Binsearch
{
	public static void main(String args[])throws IOException
	{
		DataInputStream in=new DataInputStream(System.in);
		int i,n;
		System.out.println("enter array size");
		n=Integer.parseInt(in.readLine());
		int a[]=new int [n];
		System.out.println("enter elements");
		
		for(i=0;i<n;i++)
		a[i]=Integer.parseInt(in.readLine());
		
		bubble(a,n);
		
		System.out.println("sorted array is: ");
		for(i=0;i<n;i++)
		System.out.println(a[i]);
		
		System.out.println("enter element to be searched");
		int x=Integer.parseInt(in.readLine());
		
		int j=bs(a,n-1,x);
		
		if(j==-1)
		System.out.println("element not found");
		else 
		System.out.println("element found at "+(j+1));
	}
	
	public static void bubble(int a[],int n)
	{
		int i,j,temp;
		
		for(i=0;i<n-1;i++)
		
		 for(j=i+1;j<n;j++)
			{
			if(a[i]>a[j])
			{
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
	}
	
	
	static int bs(int a[],int n,int x)
	{
		int high=n,low=0,mid;
		
		while(low<=high)
		{
			mid=(high+low)/2;
			
			if(x==a[mid])
			{
			System.out.println("element found");
			return mid;
		}
			if(x<a[mid])
				high=mid-1;
			else
			 low=mid+1;
		}
		return(-1);
	}
}

			