package tareaTesting;
import java.util.*;

public class Usuario {
	int clp_acc;
	int usd_acc;
	ArrayList<String> transacciones = new ArrayList<String>();
	int numTrans;
	
	public Usuario () {
		this.clp_acc = 1000000;
		this.usd_acc = 1000;
		this.transacciones.add("Cuentas creadas con los montos inciales, 10000000 CLP, 1000 USD");
	}
	
	public boolean depositCLP(int deposit) {
		if (deposit <= 0) {
			System.out.println("Error! El monto a depositar debe ser positivo");
			return false;
		}
		else {
			clp_acc += deposit;
			transacciones.add("Deposito de " + String.valueOf(deposit) + " CLP, "+ String.valueOf(clp_acc) + " CLP, "+ String.valueOf(usd_acc) + " USD.");
			System.out.println("Depósito realizado exitosamente. Su nuevo saldo es: CLP " + clp_acc);
			return true;
		}
	}
	
	public boolean depositUSD(int deposit) {
		if (deposit <= 0) {
			System.out.println("Error! El monto a depositar debe ser positivo");
			return false;
		}
		else {
			usd_acc += deposit;
			transacciones.add("Deposito de " + String.valueOf(deposit) + " USD, "+ String.valueOf(clp_acc) + " CLP, "+ String.valueOf(usd_acc) + " USD."); 
			System.out.println("Depósito realizado exitosamente. Su nuevo saldo es: USD " + usd_acc);
			return true;
		}
	}
	
	public boolean withdrawCLP(int mount) {
		if(mount <= 0) {
			System.out.println("Error! El monto a retirar debe ser mayor a 0, intente con un nuevo monto");
			return false;
		}
		else if(mount > 200000) {
			System.out.println("Error! El monto maximo a retirar es de $200.000, ingrese un nuevo monto");
			return false;
		}
		else if(mount > clp_acc) {
			System.out.println("Error! No dispone del saldo suficiente para retirar esa cantidad de dinero, intente con un nuevo monto");
			return false;
		}
		else {
			clp_acc -= mount;
			transacciones.add("Retiro de " + String.valueOf(mount) + " CLP, "+ String.valueOf(clp_acc) + " CLP, "+ String.valueOf(usd_acc) + " USD.");
			System.out.println("Retiro realizado exitosamente. Su nuevo saldo es: CLP " + clp_acc);
			return true;
		}
	}
	
	public boolean withdrawUSD(int mount) {
		if(mount <= 0) {
			System.out.println("Error! El monto a retirar debe ser mayor a 0, intente con un nuevo monto");
			return false;
		}
		else if(mount > 100) {
			System.out.println("Error! El monto maximo a retirar es de $200.000, ingrese un nuevo monto");
			return false;
		}
		else if(mount > usd_acc) {
			System.out.println("Error! No dispone del saldo suficiente para retirar esa cantidad de dinero, intente con un nuevo monto");
			return false;
		}
		else {
			usd_acc -= mount;
			transacciones.add("Retiro de " + String.valueOf(mount) + " USD, "+ String.valueOf(clp_acc) + " CLP, "+ String.valueOf(usd_acc) + " USD.");
			System.out.println("Retiro realizado exitosamente. Su nuevo saldo es: USD " + usd_acc);
			return true;
		}
	}
	
	public void historial() {
		System.out.println("     HISTORIAL DE TRANSACCIONES REALIZADAS    ");
		System.out.println("------------------------------------------------");
		for(int i = 0; i<transacciones.size(); i++) {
			System.out.println(transacciones.get(i));
		}
	}
}