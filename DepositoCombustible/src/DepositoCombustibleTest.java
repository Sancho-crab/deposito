import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DepositoCombustibleTest {

    static DepositoCombustible tank; 
    
    @BeforeAll
    public static void before() {
    	tank = new DepositoCombustible(40.0,0.0);
    }
	
	@Test
	public void getDepositoNivelTest() {
		
		double exp = 0.0;
		double res = tank.getDepositoNivel();
		assertEquals(exp, res, 0.1);
		
	}
	
	@Test
	public void getDepositoMaxTest() {
		
		double exp = 40.0;
		double res = tank.getDepositoMax();
		assertEquals(exp, res, 0.1);
		
	}

}
