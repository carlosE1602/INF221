import static org.junit.Assert.*;
import org.junit.*;

/*
 * Classe destinada ao teste do método compare da classe Sort
 * paralelamente(regressão)  também testa os métodos da classe Time
 */
public class SortTest {
	Time A,B;
	Sort S;
	
	@Before
	public void init() {
		A = new Time();
		B = new Time();
		S = new Sort();
	}
	
	//testa a comparação entre dois times com pontos diferentes(testa os dois branches dentro do mesmo teste)
	@Test
	public void testMaisPontos() {
		A.addPontos(10);
		B.addPontos(5);
		int value = S.compare(A,B);
		assertEquals(-1,value); //espera -1 pois não deve trocar
		value = S.compare(B,A);
		assertEquals(1,value);
	}
	
	//testa a comparação de dois times com mesmos pontons mas CA diferente
	@Test
	public void testCestaAverage() {
		A.partida(6, 5);
		
		B.partida(6, 4);
		
		int value = S.compare(A,B);
		assertEquals(1,value); // espera 1 pois average de B melhor que de A 
		value = S.compare(B,A);
		assertEquals(-1,value);
	}
	
	//testa dois times com mesmos pontos,mesmo CA, mas com numero de cestas feitas distintos
	@Test
	public void testMaisCestas() {
		
		A.partida(3,0);
		A.addFeitos(3); //atrapalha a logica,pois considera fazer cestas sem jogos, mas serve pra testar o problema
		
		B.partida(10,2);
		B.addFeitos(2);
		
		int value = S.compare(A,B);
		assertEquals(1,value); // espera 1 pois A tem mais cestas que B 
		value = S.compare(B,A);
		assertEquals(-1,value);
	}
	
	//testa última condição, caso todos os outros testes sejam iguais, testa o que tem menor indice
	@Test
	public void testMenorIndice() {
		A.setIndice(3);
		B.setIndice(2);
		
		int value = S.compare(A,B);
		assertEquals(1,value);
		value = S.compare(B,A);
		assertEquals(-1,value);
	}

}
