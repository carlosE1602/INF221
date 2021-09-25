import java.util.*;

/*
 * Classe responsável por resolver o problema, le os dados, processa e retorna a saida esperas
 */
public class Solve {
	
	public static boolean estaImpedido(ArrayList<Integer> time1,ArrayList<Integer>time2) {
		Collections.sort(time1);
		Collections.sort(time2);
		
		if(time1.get(0) < time2.get(1))
			return true;
		else return false;
	}
	
	public static void main(String[] args) {
		
		int A,D;
		Scanner input = new Scanner(System.in);
		
		while(true) {
			A = input.nextInt();
			D = input.nextInt();
			if(A+D == 0) 
				return;
			
			ArrayList<Integer> time1 = new ArrayList<Integer>();
			ArrayList<Integer> time2 = new ArrayList<Integer>();
			
			for(int i = 0;i<A;i++) {
				time1.add(input.nextInt());
			}
			
			for(int i = 0;i<D;i++) {
				time2.add(input.nextInt());
			}
			
			if(estaImpedido(time1,time2)) 
				System.out.println("Y");
			else System.out.println("N");
		}
	}

}
