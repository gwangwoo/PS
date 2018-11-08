import java.util.Scanner;

public class 덩치_0428 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Person arr[] = new Person[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = new Person(sc.nextInt(),sc.nextInt(),1);
		}
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(i==j) continue;
				if(arr[i].weight < arr[j].weight && arr[i].height < arr[j].height) {
					arr[i].rank+=1;
				}
			}
		}

		for(int i = 0 ; i < N ; i++) {
			System.out.print(arr[i].rank + " ");
		}

	}
	static class Person {
		int weight;
		int height;
		int rank;
		Person(int weight, int height,int rank) {
			this.weight = weight;
			this.height = height;
			this.rank = rank;
		}
	}
}
