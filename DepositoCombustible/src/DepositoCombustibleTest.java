import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
class DepositoCombustibleTest {
    
	//Propiedades
	private double depNivel;
	private double depMax;
	private double amount;
	private double amountTotal;
	DepositoCombustible tank;

	
    @Before
    public void initialize(){
    	tank = new DepositoCombustible(depMax,depNivel);
    }

	//constructor
    public DepositoCombustibleTest(double depNivel, double depMax, double amount, double amountTotal) {
    	this.depMax = depMax;
    	this.depNivel = depNivel;
    	this.amount = amount;
    	this.amountTotal = amountTotal;
    }
    
    //Bateria de datos
  	@Parameterized.Parameters
  	public static Collection<Object[]> numeros(){
  		return Arrays.asList(new Object [][] {
  			{40.0, 0.0, 30.0, 30.0}, 
  			{30.0, 20.0, 10.0, 30.0}, 
  			{60.0, 30.0, 10.0, 40.0}
  		});
  	}
	
	//Bateria de test
	@Test
	public void getDepositoNivelTest() {
		double res = tank.getDepositoNivel();
		assertEquals(depNivel, res, 0.1);
		
	}
	
	@Test
	public void getDepositoMaxTest() {
		double res = tank.getDepositoMax();
		assertEquals(depMax, res, 0.1);
		
	}
	
	@Test
	public void estarVacioTest() {
		assertTrue(tank.estaVacio());		
	}
	
	@Test
	public void fillTest() {
		tank.fill(amount);
		double res = tank.getDepositoNivel();
		assertEquals(res, amountTotal, 0.1);
	}
	
	@Test
	public void consumitTest() {
		tank.fill(amount);
		tank.consumir(amount);
		double exp = tank.getDepositoNivel()-amount;
		assertEquals(tank.getDepositoNivel(), amountTotal, 0.1);
	}
	
	@Test
	public void estarLLenoTest() {
		double toFill = tank.getDepositoMax()-tank.getDepositoNivel();
		tank.fill(toFill);
		assertTrue(tank.getDepositoMax()==tank.getDepositoNivel());
	}
}
	
	


