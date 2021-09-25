import static org.junit.Assert.*;
import org.junit.*;

/*
 * Classe de teste destinada a testar os métodos da classe time
 */
public class TimeTest {
	Time A;
	@Before
	public void init() {
		A = new Time();
	}
	@Test
	public void testPontos() {
		A.partida(5, 4);
		assertEquals(2,A.getPontos());
	}
	
	@Test
	public void testCestas() {
		A.partida(3, 2);
		assertEquals(3,A.getFeitos());
		assertEquals(2,A.getSofridos());
	}
	
	@Test
	public void testIndice() {
		A.setIndice(5);
		assertEquals(5, A.getIndice());
	}
	
	@Test
	public void testCestaAverage() {
		A.partida(3, 2);
		A.partida(2, 3);
		assertEquals(1.0,A.cestaAverage(),0.00001); // espera um delta quando compara doubles
	}
	@Test
	public void testSemCestasAverage() {
		A.partida(3, 0);
		A.partida(2, 0);
		assertEquals(5.0,A.cestaAverage(),0.00001); // espera um delta quando compara doubles
	}

}
