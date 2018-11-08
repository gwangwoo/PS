import java.util.*;

public class 소수_0425 {

	static void get_PrimaryNumber(int start,int end) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2);
		NEXT:
		for(int i = 3 ; i <= end ; i+=2) {
			for(int j = 0 ; j < arr.size() ; j++) {
				if(i % arr.get(j) == 0) {
					continue NEXT;
				}
			}
			arr.add(i);
		}
		int sum = 0;
		int res = 0;
		boolean check = false;
		for(int i = 0 ; i < arr.size(); i++) {
			if(arr.get(i) >= start && check == false) {
				check = true;
				res = arr.get(i);
			}
			if(arr.get(i) >= start && arr.get(i) <= end) {
				sum+= arr.get(i);
			}
		}
		if(sum == 0 || res == 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(sum);
		System.out.println(res);
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N,M;
		N = sc.nextInt();
		M = sc.nextInt();
		get_PrimaryNumber(N,M);
		
	}

}
