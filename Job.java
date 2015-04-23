public class Job{

    public String name;
    public int timestamp;
    public int duration;
    public int priority;
    public int timeRemaining;

    public Job(){

    }

    public Job(String nm, int ts, int d, int p, int tr){
	name = nm;
	timestamp = ts;
	duration = d;
	priority = p;
	timeRemaining = tr;

    }

    public Job(String nm, int ts, int d){
	name = nm;
	timestamp = ts;
	duration = d;
	timeRemaining = d;

    }
    public String getName(){
	return name;
    }

    public int getTimeRemaining(){
	return timeRemaining;
    }


    public String toString(){
	String j = this.name + " " + this.timestamp + " " + this.duration + " " + this.priority + " " + this.timeRemaining;
	return j;

    }


}
