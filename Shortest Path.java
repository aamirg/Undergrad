import java.io.*;
class ShortestPath
{
public static void main(String args[])throws IOException
{
DataInputStream in=new DataInputStream(System.in);
System.out.println("Enter no. of vertices");
int v=Integer.parseInt(in.readLine());
int cost[][]=new int[v+1][v+1];
for(int i=1;i<=v;i++)
for(int j=1;j<=v;j++)
{
System.out.println("Enter cost for edge "+i+"-"+j);
cost[i][j]=Integer.parseInt(in.readLine());
}
int a[][]=new int[v+1][v+1];
//copying values
for(int i=1;i<=v;i++)
for(int j=1;j<=v;j++)
{
a[i][j]=cost[i][j];
}
//claculation

for(int k=1;k<=v;k++)
for(int i=1;i<=v;i++)
for(int j=1;j<=v;j++)
a[i][j]=Math.min(a[i][j],a[i][k]+a[k][j]);

//Displaying final matrix
System.out.println("The final matrix is=>\n");
for(int i=1;i<=v;i++)
{ for(int j=1;j<=v;j++)
{
System.out.print(a[i][j]+"\t");
}
System.out.println();
}
}
}

/*
Enter no. of vertices
3
Enter cost for edge 1-1
0
Enter cost for edge 1-2
4
Enter cost for edge 1-3
11
Enter cost for edge 2-1
6
Enter cost for edge 2-2
0
Enter cost for edge 2-3
2
Enter cost for edge 3-1
3
Enter cost for edge 3-2
3392
Enter cost for edge 3-3
0
The final matrix is=>

0 4 6
5 0 2
3 7 0

Process completed.
*/