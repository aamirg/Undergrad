import java.io.*;
class Fit
{
	static int b[],p[];
	static int m,n;
	public static void main(String args[])throws IOException
	{
		DataInputStream in = new DataInputStream(System.in);
		System.out.println("Enter No. of Processes");
		n=Integer.parseInt(in.readLine());
		System.out.println("Enter No. of Blcoks");
		m=Integer.parseInt(in.readLine());
		b=new int[m];
		p=new int[n];
		int i,j;
		for(i=0;i<m;i++)
		{
			System.out.println("Enter Block Size of "+(i+1));
			b[i]=Integer.parseInt(in.readLine());
		}
		for(i=0;i<n;i++)
		{
			System.out.println("Enter Process Size of "+(i+1));
			p[i]=Integer.parseInt(in.readLine());
		}
		do
		{
			System.out.println("Enter Your Choice");
			System.out.println("1. First Fit  2. Best Fit  2.Worst Fit");
			j=Integer.parseInt(in.readLine());
			switch(j)
			{
				case 1: ffit();
						break;
				case 2: bfit();
						break;
				case 3: wfit();
						break;
			}
			System.out.println("1 to continue 0 to exit");
			j=Integer.parseInt(in.readLine());
		}while(j!=0);

	}
	static void ffit()
	{
		int i,j;
		int usage[]=new int[m];
		for(i=0;i<m;i++)
			usage[i]=0;
		for(i=0;i<n;i++)
		{
			for(j=0;j<m;j++)
			{
				if(p[i]<=b[j]&&usage[j]==0)
				{
					usage[j]=1;
					System.out.println("Process "+(i+1)+" is in block "+(j+1));
					break;
				}
			}
		}
	}
	static void bfit()
	{
		int i,j,size,best;
		int usage[]=new int[m];
		for(i=0;i<m;i++)
			usage[i]=0;
		for(i=0;i<n;i++)
		{
			size=1000;
			best=-1;
			for(j=0;j<m;j++)
			{
				if(p[i]<=b[j]&&usage[j]==0&&(b[j]-p[i])<size)
				{
					size=b[j]-p[i];
					best=j;
				}
			}
			if(size<1000&&best!=-1)
			{
				usage[best]=1;
				System.out.println("Process "+(i+1)+" is in block "+(best+1));
			}
		}
	}
	static void wfit()
	{
		int i,j,size,worst;
		int usage[]=new int[m];
		for(i=0;i<m;i++)
			usage[i]=0;
		for(i=0;i<n;i++)
		{
			size=0;
			worst=-1;
			for(j=0;j<m;j++)
			{
				if(p[i]<=b[j]&&usage[j]==0&&(b[j]-p[i])>size)
				{
					size=b[j]-p[i];
					worst=j;
				}
			}
			if(size<1000&&worst!=-1)
			{
				usage[worst]=1;
				System.out.println("Process "+(i+1)+" is in block "+(worst+1));
			}
		}
	}
}