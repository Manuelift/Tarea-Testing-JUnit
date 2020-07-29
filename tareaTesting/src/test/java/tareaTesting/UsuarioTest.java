package tareaTesting;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UsuarioTest {
	private Usuario newUser;
		
	@Before
	public void setUp() throws Exception{
		newUser = new Usuario();
	}

	@Test
	public void depositarCLP_Happy() throws Exception {
		newUser.depositCLP(10000);
		Assert.assertEquals(1010000, newUser.clp_acc);
		newUser.depositCLP(1);
		Assert.assertEquals(1010001, newUser.clp_acc);
	}
	
	@Test
	public void depositarCLP_0pesos() throws Exception {
		newUser.depositCLP(0);
		Assert.assertEquals(1000000, newUser.clp_acc);
	}
	
	@Test
	public void depositarCLP_valornegativo() throws Exception {
		newUser.depositCLP(-10000);
		Assert.assertEquals(1000000, newUser.clp_acc);
	}
	
	@Test
	public void testDepositUSD() throws Exception {
		newUser.depositUSD(50);
		Assert.assertEquals(1050, newUser.usd_acc);
		newUser.depositUSD(1);
		Assert.assertEquals(1051, newUser.usd_acc);
	}
	
	@Test
	public void depositarUSD_0pesos() throws Exception {
		newUser.depositUSD(0);
		Assert.assertEquals(1000, newUser.usd_acc);
	}
	
	@Test
	public void depositarUSD_valornegativo() throws Exception {
		newUser.depositCLP(-10000);
		Assert.assertEquals(1000, newUser.usd_acc);
	}
	
	@Test
	public void testWithdrawCLP_Happy() throws Exception {
		newUser.withdrawCLP(5000);
		Assert.assertEquals(995000, newUser.clp_acc);
	}
	
	@Test
	public void testWithdrawCLP_limite_200k() throws Exception {
		newUser.withdrawCLP(200000);
		Assert.assertEquals(800000, newUser.clp_acc);
	}
	
	public void testWithdrawCLP_limite_201k() throws Exception {
		newUser.withdrawCLP(200000);
		Assert.assertEquals(800000, newUser.clp_acc);
	}
	
	@Test
	public void testWithdrawCLP_0pesos() throws Exception {
		newUser.withdrawCLP(0);
		Assert.assertEquals(1000000, newUser.clp_acc);
	}
	
	@Test
	public void testWithdrawCLP_valornegativo() throws Exception {
		newUser.withdrawCLP(-30000);
		Assert.assertEquals(1000000, newUser.clp_acc);
	}

	@Test
	public void testWithdrawUSD() throws Exception {
		newUser.withdrawUSD(25);
		Assert.assertEquals(975, newUser.usd_acc);
	}
	
	@Test
	public void testWithdrawUSD_limite_100USD() throws Exception {
		newUser.withdrawUSD(100);
		Assert.assertEquals(900, newUser.usd_acc);
	}
	
	@Test
	public void testWithdrawUSD_limite_101usd() throws Exception {
		newUser.withdrawUSD(101);
		Assert.assertEquals(1000, newUser.usd_acc);
	}
	
	@Test
	public void testWithdrawUSD_0usd() throws Exception {
		newUser.withdrawUSD(0);
		Assert.assertEquals(1000, newUser.usd_acc);
	}
	
	@Test
	public void testWithdrawUSD_valornegativo() throws Exception {
		newUser.withdrawUSD(-30);
		Assert.assertEquals(1000, newUser.usd_acc);
	}	
}
