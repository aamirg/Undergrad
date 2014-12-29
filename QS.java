import java.io.*;
class QS
{
	public static void main(String args[])throws IOException
	{
			DataInputStream in = new DataInputStream(System.in);
			int a[],n,i;
			System.out.println("Enter array size");
			n=Integer.parseInt(in.readLine());
			
			a=new int[n];
			System.out.println("Enter elements");
			
			for(i=0;i<n;i++)
			a[i]=Integer.parseInt(in.readLine());
			
			quicksort(a,0,n-1);
			
			System.out.println("sorted array is");
			
			for(i=0;i<n;i++)
			System.out.println(a[i]);
		}
		
		static void quicksort(int a[],int lb,int ub)
		{
			int j=0;
			
			if(lb<=ub)
			{
				j=partition(a,lb,ub);
				quicksort(a,lb,j-1);
				quicksort(a,j+1,ub);
			}
	}
	
	 static int partition(int a[],int lb,int ub)
	 {
	 	int up,down,temp,x;
	 	up=ub;
	 	down=lb;
	 	x=a[lb];
	 	
	 	while(down<up)
	 	{
	 		
	 	while(a[down]<=x && down<up)
	 	down++;
	 	
	 	while(a[up]>x)
	 	up--;
	 	
	 	if(down<up)
	 	{
	 		temp=a[down];
	 		a[down]=a[up];
	 		a[up]=temp;
	 	}
	 }
	 a[lb]=a[up];
	 a[up]=x;
	 return up;
}
}