import java.io.*;
class SJF
{
public static void main(String args[])throws IOException
{ int n;
DataInputStream in=new DataInputStream(System.in);
System.out.println("enter total no.of processes");
n=Integer.parseInt(in.readLine());
int bt[]=new int[n];
String pname[]=new String[n];
for(int i=0; i<n;i++)
{
System.out.println("Enter the process name");
pname[i]=in.readLine();
System.out.println("enter the burst time");
bt[i]=Integer.parseInt(in.readLine());
}
for(int i=0;i<n-1;i++)
for(int j=i+1;j<n;j++)
{
if(bt[i]>bt[j])
{
int temp;
temp=bt[i];
bt[i]=bt[j];
bt[j]=temp;

String nametemp=new String();
nametemp=pname[i];
pname[i]=pname[j];
pname[j]=nametemp;

}
}
System.out.println("THE SCHEDULED PROCESSES ARE=>");
for(int k=0;k<n;k++)
{
System.out.println("pname"+"\t"+"bursttime");
System.out.println(pname[k]+"\t"+bt[k]);
try
{Thread.sleep(bt[k]);
}catch(Exception e){}
}
}

}