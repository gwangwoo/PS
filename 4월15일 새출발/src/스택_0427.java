import java.util.*;

public class 스택_0427 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Stack<Integer> stk = new Stack<>();
		int T = sc.nextInt();
		while(T-- >0) {
			String str = sc.next();
			switch(str) {
			case "push":
				int x = sc.nextInt();
				stk.add(x);
				break;
			case "pop":
				if(!stk.isEmpty()) {
					System.out.println(stk.pop());
				}else {
					System.out.println("-1");
				}
				break;
			case "size" :
				System.out.println(stk.size());
				break;
			case "empty":
				if(stk.isEmpty()) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
				break;
			case "top":
				if(!stk.isEmpty()) {
					System.out.println(stk.peek());
				}else {
					System.out.println("-1");
				}
				break;
			}
		}

	}

}
