import java.io.*;
class sumsub
{   static int x[],w[],n,m;
	public static void main(String args[])throws IOException
	{
	DataInputStream in=new DataInputStream(System.in);
	System.out.println("Enter no of elements");
	n=Integer.parseInt(in.readLine());
    
    System.out.println("Enter maximum weight");
    m=Integer.parseInt(in.readLine());
    
    w=new int[n+1];
    x=new int[n+1];
    int r=0;
	System.out.println("enter elements in non descending order");
	for(int i=1;i<=n;i++)
	{
		w[i]=Integer.parseInt(in.readLine());
	   r=r+w[i];
	}
	sumofsub(0,1,r);
}
 
 static void sumofsub(int s,int k,int r)
 {
 	int i;
 	x[k]=1;
 	if((s+w[k])==m)
 	{
 		System.out.println("Elements of subsets are");
 		for(i=1;i<=n;i++)
 		{
 			if(x[i]==1)
 			System.out.print(w[i]+" ");
 		}
 		System.out.println();
 	}
 	else
 	if((s+w[k]+w[k+1])<=m)
 	sumofsub(s+w[k],k+1,r-w[k]);
 	
 	if((s+r-w[k])>=m&&(s+w[k+1])<=m)
 	{
 		x[k]=0;
 		sumofsub(s,k+1,r-w[k]);
 	}
 }
}

/*Output
 Enter no of elements
5
Enter maximum weight
21
enter elements in non descending order
5
6
10
11
21
Elements of subsets are
5 6 10
Elements of subsets are
10 11
Elements of subsets are
21
Press any key to continue...
*/