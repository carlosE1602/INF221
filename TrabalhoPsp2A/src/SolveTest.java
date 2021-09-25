import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

/*
 * Classe destinada a testar o a entrada de dados e a resolução do problema,
 * usada para testar a lógica usada na classe Solve, que precisa ler do terminal
 * o que não é tão trivial para teste unitários
 */
public class SolveTest {
	
	ArrayList<Time> time;
	
	//após a execução simula a saida da Solve.main() em uma string para facilitar a comparação
	public String saida(int N) {
		String saida = "";
		for(int i = 0;i<N;i++) {
			saida += time.get(i).getIndice();
			if(i != N-1) {			
				saida +=  " ";
			}
		}
		saida+="\n";
		
		return saida;
	}
	
	//fixture base para todas os testes
	@Before
	public void init() {
		time = new ArrayList<Time>();
	}
	
	
	//situação padrão onde o time com mais pontos fica em primeiro
	@Test
	public void testPontosDecide() {
		int N = 3;
		
		Solve.iniciaIndices(time, N);
		
		Solve.addEntrada(time, 1, 3, 2, 2);
		Solve.addEntrada(time, 1, 5, 3, 2);
		Solve.addEntrada(time, 2, 3, 3, 8);
		
		Collections.sort(time, new Sort());
				
		String saida = saida(N);
	
		
		assertEquals("1 3 2\n",saida);
	}	
	@Test
	public void testCADecide() {//situação padrão onde o time com melhor CA fica em primeiro
		int N = 3;
		
		Solve.iniciaIndices(time,N);
		
		Solve.addEntrada(time, 1, 3, 2, 1);
		Solve.addEntrada(time, 1, 1, 3, 3);
		Solve.addEntrada(time, 2, 4, 3, 1);
		
		Collections.sort(time, new Sort());
				
		String saida = saida(N);
		
		assertEquals("2 1 3\n",saida);
	}
	
	//caso de teste oncde o CA é zero, nesse caso deve ser usado apenas o total
	//de cestas feitas
	@Test
	public void testCAComZero() {
		int N = 4;
		
		Solve.iniciaIndices(time, N);
		
		Solve.addEntrada(time, 1, 3, 2, 0);
		Solve.addEntrada(time, 1, 4, 3, 0);
		Solve.addEntrada(time, 1, 4, 3, 0);
		Solve.addEntrada(time, 4, 2, 3, 0);
		Solve.addEntrada(time, 4, 4, 2, 0);
		Solve.addEntrada(time, 4, 4, 2, 0);
		
		Collections.sort(time, new Sort());
		
		String saida = saida(N);
		
		assertEquals("1 4 2 3\n",saida);
		
	}
	
	//situação onde o time com mais cestas fica na frente
	@Test
	public void testFeitosDecide() {
		int N = 3;
		
		Solve.iniciaIndices(time,N);
		
		Solve.addEntrada(time, 1, 6, 2, 0);
		Solve.addEntrada(time, 1, 0, 3, 3);
		Solve.addEntrada(time, 2, 12, 3, 0);
		
		Collections.sort(time, new Sort());
				
		String saida = saida(N);
		
		assertEquals("2 1 3\n",saida);
	}
	
	//situação onde o time com menor indice fica em primeiro
	@Test
	public void testIndiceDecide(){ 
		int N = 3;
		
		Solve.iniciaIndices(time,N);
		
		Solve.addEntrada(time, 1, 3, 2, 1);
		Solve.addEntrada(time, 1, 1, 3, 3);
		Solve.addEntrada(time, 2, 3, 3, 1);
		
		Collections.sort(time, new Sort());
				
		String saida = saida(N);
		
		assertEquals("1 2 3\n",saida);
	}
	
	//caso de teste dado na descrição do problema
	@Test
	public void testGeral() {
		int N = 5;
		
		Solve.iniciaIndices(time, N);
		
		Solve.addEntrada(time,1,102,2,62);
		Solve.addEntrada(time,1,128,3,127);
		Solve.addEntrada(time,1,144,4,80);
		Solve.addEntrada(time,1,102,2,101);
		Solve.addEntrada(time,2,62,3,61);
		Solve.addEntrada(time,2,100,4,80);
		Solve.addEntrada(time,2,88,5,82);
		Solve.addEntrada(time,3,79,4,90);
		Solve.addEntrada(time,3,87,5,100);
		Solve.addEntrada(time,4,110,5,99);
		
		Collections.sort(time, new Sort());
				
		String saida = saida(N);
		assertEquals("1 2 4 5 3\n",saida);
	}
}
