	import java.io.*;
	import java.lang.*;
	class Knapsack
	{
		public static void main(String args[])throws IOException
		{
		DataInputStream in=new DataInputStream(System.in);
		int m,n,cp,i;
		
		System.out.println("enter no of elements");
		n=Integer.parseInt(in.readLine());
		
		float w[]=new float[n];
		float p[]=new float[n]; 
		 
		System.out.println("enter maximum weight");
		m=Integer.parseInt(in.readLine());
		
		
		for(i=0;i<n;i++)
		{
			System.out.println("enter Weight "+(i+1));
			w[i]= Float.valueOf(in.readLine()).floatValue();
			
			System.out.println("enter profit "+(i+1));
			p[i]= Float.valueOf(in.readLine()).floatValue();
		}
		
	
		bubblesort(w,p,n);
	  float z=KS (w,p,m,n);
	  System.out.println();
	  System.out.println("Optimal solution= " +z);
	}
	
	static void bubblesort(float w[],float p[],int n)
	{
		float ratio[]=new float[n];
		float temp1,temp2;
		
		for(int i=0;i<n;i++)
		{
			ratio[i]=p[i]/w[i];
		}
		
		for(int i=0;i<n-1;i++)
		{
		 for( int j=i+1;j<n;j++)
		 {
		  if(ratio[i]<ratio[j])
		  {
		  	temp1=w[i];
		  	w[i]=w[j];
		  	w[j]=temp1;
		  	
		  	temp2=p[i];
		  	p[i]=p[j];
		  	p[j]=temp2;
		  }
		 }
	}
	for( int i=0;i<n;i++)
	System.out.println("item: "+(i+1)+ " weight: "+w[i]+"  profit:"+p[i]);
	
	}
	
	static float KS(float w[],float p[],int m,int n)
	{
		float x[]=new float[10];
	  	float cp,max=0;
		int i;
		for(i=0;i<n;i++)
		x[i]=0;
		cp=m;
		i=0;
		
		while(i<n&& w[i]<=cp)
		{
			x[i]=1;
			cp=cp-w[i];
			i++;
		}
		if(i<n)
		x[i]=cp/w[i];
		
		for(i=0;i<n;i++)
		{
			max=max+x[i]*p[i];
			
		}
	 return max; 
	}
	}
	
	/*Output
	 
	 enter no of elements
	7
	enter maximum weight
	15
	enter Weight 1
	3
	enter profit 1
	5
	enter Weight 2
	7
	enter profit 2
	8
	enter Weight 3
	4
	enter profit 3
	4
	enter Weight 4
	3
	enter profit 4
	2
	enter Weight 5
	10
	enter profit 5
	6
	enter Weight 6
	7
	enter profit 6
	3
	enter Weight 7
	3
	enter profit 7
	1
	item: 1 weight: 3.0  profit:5.0
	item: 2 weight: 7.0  profit:8.0
	item: 3 weight: 4.0  profit:4.0
	item: 4 weight: 3.0  profit:2.0
	item: 5 weight: 10.0 profit:6.0
	item: 6 weight: 7.0  profit:3.0
	item: 7 weight: 3.0  profit:1.0
	
	Optimal solution= 17.666666
	Press any key to continue...
	*/