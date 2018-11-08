import java.util.*;

public class 이진수_0425 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			ArrayList<Integer> arr = new ArrayList<>();
			int num = sc.nextInt();
			for(int i = 0; i <= 20 ; i++) {
				if((num & (1<<i)) != 0) {
					arr.add(i);
				}else continue;
			}
			for(int i = 0 ; i < arr.size() ; i++) {
				System.out.print(arr.get(i)+ " ");
			}
		}
	}
}
