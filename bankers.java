//Bankers Safety Algorithm

import java.io.*;
import java.util.*;
class bank
{
	void safet(int m1,int n1,int alloc1[][],int need1[][],int work1[],boolean finish1[])
	{
	int safe=1;
	
	int safety[]=new int[m1];
	
	for(int k=0;k<m1;k++)
	{
	int chk=0;
	
	for(int i=0;i<m1&& chk==0;i++)
	{
	
	int flag=0;
			for(int j=0;j<n1&&!finish1[i];j++)
			{
			
				if(need1[i][j]>work1[j])
					flag=1;
			}			
		if(finish1[i]==false && flag!=1)
		{
		for(int j=0;j<n1;j++)
                  {
                  	work1[j]=work1[j]+alloc1[i][j];
			System.out.print(work1[j]);
			}
		finish1[i]=true;
		chk=1;
		safety[k]=i;
		}
	System.out.println();
	
	}	
	}
	for(int i=0;i<m1;i++){
		System.out.print("p"+safety[i]+",");
	
	}
}}
class bankers
{
	public static void main(String args[])
	{
		int m,n,work[],alloc[][],max[][],need[][];
		boolean finish[];
		System.out.println("Enter the no of processes m nd resources n");
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt();
		n=sc.nextInt();
		work=new int[n];
		finish= new boolean[m];
		alloc=new int[m][n];
		need=new int[m][n];

		max=new int[m][n];
		System.out.println("ENter data of alloc[]");

		for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			alloc[i][j]=sc.nextInt();
		}}
		System.out.println("ENter data of max[]");

		for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			max[i][j]=sc.nextInt();
		}}
                  for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			need[i][j]=max[i][j]-alloc[i][j];
		}}
		for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			System.out.print(alloc[i][j] + "  ");
			
		}for(int j=0;j<n;j++){ 
			System.out.print(max[i][j] + "  ");
			
		}for(int j=0;j<n;j++){
			System.out.print(need[i][j] + "  ");
			
		}System.out.println();
}
		int[] max_reso=new int[n];
		System.out.println("enter max reso");
		for(int j=0;j<n;j++){
			max_reso[j]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
		
			work[i]=max_reso[i];
		}for(int j=0;j<m;j++){
			finish[j]=false;
		}
	
		for(int i=0;i<n;i++){
		for(int j=0;j<m;j++){
			work[i]=work[i]-alloc[j][i];
		}System.out.println(work[i]+"\t");}
		bank b=new bank();
		b.safet(m,n,alloc,need,work,finish);

}
}







						//	Output


//C:\Java\bin>javac bankers.java

/*C:\Java\bin>java bankers
Enetr the no of processes m nd resources n
5
3
ENter data of alloc[]
0
1
0
2
0
0
3
0
2
2
1
1
0
0
2
ENter data of max[]
7
5
3
3
2
2
9
0
2
2
2
2
4
3
3
alloc     max       need
0  1  0   7  5  3   7  4  3
2  0  0   3  2  2   1  2  2
3  0  2   9  0  2   6  0  0
2  1  1   2  2  2   0  1  1
0  0  2   4  3  3   4  3  1
enter max reso
10
5
7
available
3
3
2
work
532
743
753
1055
1057
safety
p1,p3,p0,p2,p4
C:\Java\bin>*/