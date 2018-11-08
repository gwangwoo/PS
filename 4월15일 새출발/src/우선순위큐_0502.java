import java.util.PriorityQueue;

public class 우선순위큐_0502 {

	static PriorityQueue<Prisoner> getPriorityQueue() {
		Prisoner prisoner1 = new Prisoner("james",5);
		Prisoner prisoner2 = new Prisoner("james",5);
		Prisoner prisoner3 = new Prisoner("james",5);
		Prisoner prisoner4 = new Prisoner("james",5);
		Prisoner prisoner5 = new Prisoner("james",5);
		
		
		
	    PriorityQueue<Prisoner> priorityQueue = new PriorityQueue<Prisoner>();
	    return priorityQueue;
	}
	
	public static void main(String[] args) {

		
	}

}
class Prisoner implements Comparable<Prisoner>{
	String name;
	int weight; // 형량
	
	public Prisoner(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
		
	}

	@Override
	public int compareTo(Prisoner target) {
		if(this.weight > target.weight) {
			return 1;
		}else if(this.weight < target.weight) {
			return -1;
		}
		return 0;
	}
}
