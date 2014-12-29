import java.io.*;

class FCFS
{
public static void main(String a[])throws Exception
{
DataInputStream in=new DataInputStream(System.in);
System.out.println("please anter the no. of processes"); 
int n=Integer.parseInt(in.readLine());
// System.out.println("Processes you entered " +n); 
System.out.println("Please enter the name of ol processes n thier burst time");
String name[]=new String[n];
int burst[]=new int[n];
for(int i=0;i<n;i++)
{ name[i]=in.readLine();
burst[i]=Integer.parseInt(in.readLine());
}

int st[]=new int[n];
st[0]=0;
for(int i=1;i<n;i++)
st[i]=burst[i-1]+st[i-1];
for(int i=0;i<n;i++)
System.out.println("Process "+i+ " Name = "+name[i]+ " Burst time "+burst[i]+" Starting time = " +st[i]); 
int awt=0;
for(int i=0;i<n;i++)
awt=awt+st[i];
awt=awt/3;
System.out.println("Average Waiting time =" +awt);

}
}