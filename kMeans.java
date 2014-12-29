import java.io.*;
public class kMeans {

	public static void main(String[] args)throws IOException
	{	
		DataInputStream in = new DataInputStream(System.in);
		
		//First we take the number of clusters to be made
		System.out.println("Enter the number of clusters : ");
		int numOfClusters = Integer.parseInt(in.readLine());
		
		//Then the number of elements
		System.out.println("Enter the number of elements : ");
		int numOfElements = Integer.parseInt(in.readLine());
		
		float centers[] = new float[numOfClusters];//This array stores the respective centres of each cluster 
		
		/* This is a multidimensional array of the form 
		 * 22 27 35 18 36 
		 * 9 10
		 * 12 15 11
		 * 
		 * It will store the list of elements of each cluster. rows = cluster no , cloumns = elements of that cluster 
		 * 
		 */
		int clusters[][] = new int[numOfClusters][numOfElements];

		int list[] = new int[numOfElements];//This is simply the list of elements we take input from the user
		
		//Taking Input
		System.out.println("Enter the elements : ");
		for(int i=0;i<numOfElements;i++)
		{
			list[i]=Integer.parseInt(in.readLine());
		}
		
		int q=0;//Taking first k elements as centres
		while(q<numOfClusters)
		{
			centers[q]=list[q];
			q++;
			//First k elements will be centers
		}
		
			float mindist;		//To temporarily store mindist of each element from the k centers 
			int clusterCounter[] = new int[numOfClusters];			//To count the number of elements in each cluster 
			int clusterNum=0;													//To store the CLusterNum the element should be put into eg Cluster 1 or 2 or 3 etc
			int r=0;							//I assumed 4 iterations just for the sake of simplicity .. You can make it more complex if You want
			
			while(r<4){	
				
				System.out.println("Iteration number "+r);
				System.out.println();
				
			//Assigning each elemt to a cluster by comparing its dist to all cluster centers 
			
			for(int j=0;j<numOfElements;j++)
			{
				mindist=2000;									//Max value just to start off the process
				for(int i=0;i<numOfClusters;i++)
				{
					float dist = Math.abs(list[j]-centers[i]);			//Found the distance for cluster i
					if(dist<mindist)
					{
						clusterNum = i;//If the dist is minimum the element will be put in cluster i
						mindist=dist;
					}
					
				}
				//This is the tricky bit
				
				clusters[clusterNum][clusterCounter[clusterNum]]=list[j];
				
				/* We got clusterNum ie:which cluster to put the value in,
				 * now we need to put it in the multidimensional clusters array .. 
				 * We have Employed a counter that counts the elements present in each cluster.
				 * that is ClusterCounter
				 * clusterCounter[clusterNum] signifies counter of which cluster .. that is cluster 1 or 2 or 3 etc.
				 */
				//Once we assign a new element for a cluster we increment its counter
				clusterCounter[clusterNum]++;
				
				System.out.println("Clusters are : ");
				//Displaying the clusters
				for(int l=0;l<numOfClusters;l++)
				{
					for(int p=0;p<clusterCounter[l];p++)
					{
						System.out.print(clusters[l][p]+"  ");			
					}
					System.out.println();
				}
			}
			//Displaying the centers
			System.out.println("Centers are : ");
			for(int o=0;o<numOfClusters;o++)
			{
				System.out.print(centers[o]+"  ");			
			}
			System.out.println();
			
			int sum=0;//Sum of each cluster
			float avg=0.0f;//Avg of each cluster
					
			for(int h=0;h<numOfClusters;h++)//Calculating new Centers
			{
				sum=0;
				for(int y=0;y<clusterCounter[h];y++)
				{
					sum=sum+clusters[h][y];
				}
				avg=(float)sum/clusterCounter[h];//Dividing by the counter for that cluster .. I told you it will come in handy .. 
				centers[h]=avg;//We change the center for that cluster
			}
			
			//Flushing out the clusters multidimensional array as we will recalculate the clusters in the next iteration
			for(int o=0;o<numOfClusters;o++)
			{
				for(int p=0;p<clusterCounter[o];p++)
				{
					clusters[o][p]=0;
				}
				clusterCounter[o]=0;//Counter for each cluster is also made 0
			}
			
			r++;
			}//Go back up for the next iteration 
	}
}

