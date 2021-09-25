import static org.junit.Assert.*;
import java.util.*;

import org.junit.*;

/*
 * Classe responsável por testar os componentes pricipais da classe Solve
 */

public class SolveTest {

	ArrayList<Integer> time1; 
	ArrayList<Integer> time2;
	
	@Before
	public void init() {
		time1 = new ArrayList<Integer>();
		time2 = new ArrayList<Integer>();
	}
	@Test
	public void Impedidotest() {
		time1.add(200);
		time1.add(300);
		time2.add(100);
		time2.add(300);
		assertTrue(Solve.estaImpedido(time1, time2));
	}
	@Test
	public void PosicaoLegaltest() {
		time1.add(500);
		time1.add(600);
		
		time2.add(100);
		time2.add(500);
		time2.add(700);
		assertFalse(Solve.estaImpedido(time1, time2));
	}
	@Test
	public void MesmaLinhatest() {
		for(int i = 0;i<5;i++) {
			time1.add(10);
			time2.add(10);
		}
		assertFalse(Solve.estaImpedido(time1, time2));
	}
	
	@Test
	public void extremeTest() {
		for(int i = 0;i<10000;i++) {
			time1.add(i);
			time2.add(i);
		}
		assertTrue(Solve.estaImpedido(time1, time2));
	}

}