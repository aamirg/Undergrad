import java.io.*;
class Copybytes
{
	public static void main(String args[])
	{
		File infile=new File(args[0]);
		File outfile=new File(args[1]);
		FileInputStream ins=null;
		FileOutputStream outs=null;
		byte byteread;
		try
		
		{
			ins= new FileInputStream(infile);
			outs =new FileOutputStream(outfile);
			while((byteread=(byte)ins.read())!=-1)
			outs.write(byteread);
		}
		
		catch(Exception e){}
		
		finally
		{
			try
			{
				ins.close();
				outs.close();
			}
			catch(Exception e){}
		}
	}
}
