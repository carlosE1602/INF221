import java.util.*;

/*
 * Classe usada para ler a entrada do terminal processar os dados e retornar a saída esperada
 */
public class Solve {
	
	//método que adiciona os dados de uma linha de entrada nos respectivos times
	public static void addEntrada(ArrayList<Time> time, int A,int cestasA,int B,int cestasB) {
		time.get(A-1).partida(cestasA, cestasB);
		time.get(B-1).partida(cestasB, cestasA);
	}
	
	//método que inicia os indices do vetor na forma v[i] tem indice i+1
	public static void iniciaIndices(ArrayList<Time> times,int N) {
		for(int i = 0;i<N;i++) {
			times.add(new Time());
			times.get(i).setIndice(i+1);
		}
	}
	
	//método que le do terminal, processa os dados e gera a saída
	public static void main(String[] args) {
		int N;
		Scanner input = new Scanner(System.in);
		ArrayList<Time> times = new ArrayList<Time>();
		
		N = input.nextInt();
		iniciaIndices(times,N);
		
		for(int i = 0;i<(N*(N-1))/2;i++) {
			int indexA;
			int cestasA;
			int indexB;
			int cestasB;
			
			indexA = input.nextInt();
			cestasA = input.nextInt();
			indexB = input.nextInt();
			cestasB = input.nextInt();
			addEntrada(times,indexA,cestasA,indexB,cestasB);
		}
				
		Collections.sort(times, new Sort());
		
		for(int i = 0;i<N;i++) {			
			System.out.print(times.get(i).getIndice());
			if(i != N-1) {			
				System.out.print(" ");
			}

		}
		System.out.println();
		
		input.close();
	}

}