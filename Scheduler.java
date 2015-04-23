import java.io.*;
import java.util.*;
public class Scheduler{

    public String[] processes;
    public static String jobfile; //File name
    public static List<Job> allJobs; //parsed version of file

    //main parses the csv file and calls a scheduling algorithm.
    public static void main (String [] args){
	
	jobfile = args[0];
	try{
	    allJobs = parseFile(jobfile);
	    firstComeFirstServed();
	}catch(IOException e){
	    System.out.println("File does not exist");
	}


    }

    //Just going to go through all of the processes in order that they are in the file
    //for now, as we assume they are put into the file in order. 
    //I should create a version in which they don't come into the file in order and need
    //to be sorted by timestamp
    public static void firstComeFirstServed(){
       	int time = 0; //tracks the total time elapsed
	int jobCount = allJobs.size(); //tracks total number of jobs
	while (allJobs.isEmpty() == false){ //as long as the list still has jobs
	    String output = "Total Time: " + time + " Job: " + allJobs.get(0).getName() + 
		" Time Remaining: " + allJobs.get(0).getTimeRemaining();
	    System.out.println(output);
	    time++;
	    allJobs.get(0).timeRemaining--;
	    if(allJobs.get(0).getTimeRemaining() == 0){ //when the CPU finishes a job
		allJobs.remove(0); //remove it. I wonder if I should keep a seperate list
	    }
	}
	//Final stats
	System.out.println("Jobs Finished: " + jobCount);
	System.out.println("Time Finished: " + time);
	System.out.println("Done!");
    }

    public static List parseFile(String x) throws IOException{
	List<Job> jobs = new ArrayList<Job>();
	
	//FileReader reader = new FileReader(x);
	BufferedReader br = new BufferedReader(new FileReader(x));
	String line = br.readLine();
	while((line = br.readLine()) != null){
	    String[] temp = line.split(", ");
	    int t = Integer.parseInt(temp[1]);
	    int d = Integer.parseInt(temp[2]);
	    int pr = Integer.parseInt(temp[3]);
	    Job j = new Job(temp[0], t, d, pr, d);
	    jobs.add(j);
	   
	}
	System.out.println(jobs);
	return jobs;
	
       
	

    }


}
