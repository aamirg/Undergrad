import java.io.*;
public class Fitting
 {
 	BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
 	 int process[], rprocess[], block[], rblock[], usage[], rusage[];
 	 int p, b, free, used, rfree, rused, c, c1;
 	 public Fitting() throws IOException
 	 	{
 	 	System.out.println("Enter number of blocks");
		b=Integer.parseInt(input.readLine());
		System.out.println("Enter number of processes");
		p=Integer.parseInt(input.readLine());
		process=new int[p];
		rprocess=new int[p];
		block=new int[b];
		rblock=new int[b];
		usage=new int[b];
		rusage=new int[b];
		c=0;
		}

	void read() throws IOException
	{
		int i;
		System.out.println("Enter block sizes");
		for(i=0;i<b;i++)
		{
			System.out.print("Block "+(i+1)+" : ");
			rblock[i]=Integer.parseInt(input.readLine());
		}
		System.out.println("Enter block usage scenario");
		for(i=0;i<b;i++)
		{
			System.out.println("Is block "+(i+1)+" used (1) or free (0)?");
			rusage[i]=Integer.parseInt(input.readLine());
			if(rusage[i]==1)
			{
				rused=rused+rblock[i];
				c1++;
			}
			else
				rfree=rfree+rblock[i];
		}
		System.out.println("Enter process demand");
		for(i=0;i<p;i++)
		{
			System.out.print("Process "+(i+1)+" : ");
			rprocess[i]=Integer.parseInt(input.readLine());
		}
	}

	void reset()
	{
	int i;
	for(i=0;i<b;i++)
	{
		block[i]=rblock[i];
		usage[i]=rusage[i];
	}
	for(i=0;i<p;i++)
	process[i]=rprocess[i];
	used=rused;
	free=rfree;
	c=c1;
	}

	void display()
	{
		int total;
		total=rused+rfree;
		System.out.println("Blocks used = "+c);
		System.out.println("Total used space = "+used);
		System.out.println("Blocks free = "+(b-c));
		System.out.println("Total free space = "+(total-used));
	}

	void f_fit()
	{
		int i,j;
		for(i=0;i<p;i++) //Processes.
		for(j=0;j<b;j++) //Blocks.
		{
			if(process[i]<=block[j]&&usage[j]==0)
			{
				usage[j]=1;
				used=used+block[j];
				c++;
				System.out.println("Process "+(i+1)+" is in block "+(j+1));
				break;
			}
		}
	}

	void b_fit()
	{
		int i,j,size,best;
		for(i=0;i<p;i++)
		{
			size=32967;
			best=-1;
		for(j=0;j<b;j++)
		{
			if(process[i]<=block[j]&&usage[j]==0&&(block[j]-process[i])<size)
			{
				size=block[j]-process[i];
				best=j;
			}
		}
		if(size<32967&&best!=-1) //Ensuring a best fit.
		{
			usage[best]=1;
			used=used+block[best];
			c++;
			System.out.println("Process "+(i+1)+" is in block "+(best+1));
		}
		}
	}

	void w_fit()
	{
		int i,j,size,worst;
		for(i=0;i<p;i++)
		{
			size=0;
			worst=-1;
			for(j=0;j<b;j++)
			{
				if(process[i]<=block[j]&&usage[j]==0&&(block[j]-process[i])>size)
				{
					size=block[j]-process[i];
					worst=j;
				}
			}
			if(worst!=-1) //Ensuring a worst fit.
			{
				usage[worst]=1;
				used=used+block[worst];
				c++;
				System.out.println("Process "+(i+1)+" is in block "+(worst+1));
			}
		}
	}

public static void main(String[] args) throws IOException
{
	BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	int option;
	String choice;
	Fitting f=new Fitting();
	f.read();
	do
	{
		f.reset();
		System.out.println("Menu");
		System.out.println("1. First fit");
		System.out.println("2. Best fit");
		System.out.println("3. Worst fit");
		/*System.out.println("4. Block information");*/
		System.out.println("Enter option");
		option=Integer.parseInt(input.readLine());

		switch(option)
		{
			case 1: f.f_fit();
			break;
			case 2: f.b_fit();
			break;
			case 3: f.w_fit();
			break;
			/*case 4: f.display();
			break;*/
			default: System.out.println("Invalid input");
		}
		f.display();
		System.out.println("Press Y to continue");
		choice=input.readLine();
	}
	while(choice.compareToIgnoreCase("y")==0);
}
}

/*OUTPUT
 Enter number of blocks
4
Enter number of processes
5
Enter block sizes
Block 1 : 4
Block 2 : 3
Block 3 : 4
Block 4 : 5
Enter block usage scenario
Is block 1 used (1) or free (0)?
0
Is block 2 used (1) or free (0)?
0
Is block 3 used (1) or free (0)?
0
Is block 4 used (1) or free (0)?
0
Enter process demand
Process 1 : 3
Process 2 : 6
Process 3 : 2
Process 4 : 1
Process 5 : 4
Menu
1. First fit
2. Best fit
3. Worst fit
Enter option
1
Process 1 is in block 1
Process 3 is in block 2
Process 4 is in block 3
Process 5 is in block 4
Blocks used = 4
Total used space = 16
Blocks free = 0
Total free space = 0
Press Y to continue
Y
Menu
1. First fit
2. Best fit
3. Worst fit
Enter option
2
Process 1 is in block 2
Process 3 is in block 1
Process 4 is in block 3
Process 5 is in block 4
Blocks used = 4
Total used space = 16
Blocks free = 0
Total free space = 0
Press Y to continue
Y
Menu
1. First fit
2. Best fit
3. Worst fit
Enter option
3
Process 1 is in block 4
Process 3 is in block 1
Process 4 is in block 3
Blocks used = 3
Total used space = 13
Blocks free = 1
Total free space = 3
Press Y to continue
N
Press any key to continue...
*/