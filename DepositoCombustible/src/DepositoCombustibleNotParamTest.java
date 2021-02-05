import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class DepositoCombustibleNotParamTest {
	
	DepositoCombustible tank = new DepositoCombustible (40, 0);

	@Test
	public void getDepositoNivelTest() {
		double res = tank.getDepositoNivel();
		double exp = 0;
		assertEquals(exp, res, 0.1);
		
	}
	
	@Test
	public void getDepositoMaxTest() {
		double exp = 40;
		double res = tank.getDepositoMax();
		assertEquals(exp, res, 0.1);
		
	}
	
	@Test
	public void estarVacioTest() {
		assertTrue(tank.estaVacio());		
	}
	
	@Test
	public void fillTest() {
		tank.fill(40);
		double exp = tank.getDepositoNivel();
		double res = 40;
		assertEquals(exp, res, 0.1);
	}
	
	@Test
	public void consumitTest() {
		tank.fill(40);
		tank.consumir(30);
		double exp = 10;
		double res = tank.getDepositoNivel();
		assertEquals(exp, res, 0.1);
	}
	
	@Test
	public void estarLLenoTest() {
		tank.fill(40);
		assertTrue(tank.getDepositoMax()==tank.getDepositoNivel());
	}
}
