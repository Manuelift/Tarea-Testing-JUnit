package tareaTesting;
import java.util.*;

public class mainClass {
	public static void printAcciones() {
		System.out.println("\nBienvenido a Banco Azul, selecciona operaci�n a realizar:");
		System.out.println("\"1\" Dep�sito");
		System.out.println("\"2\" Retiro ");
		System.out.println("\"3\" Ver transacciones");
		System.out.println("\"4\" Cerrar sesi�n");
	}
	public static void main(String[]args) {
		int operaciones = 0;
		int sesion = 0;
		String accion;
		String divisa;
		int monto;
		boolean flag;
		
		Usuario newUser = new Usuario();
		Scanner input = new Scanner(System.in);
		
		while (true) {
			printAcciones();
			accion = input.next();
			if (!(accion.equals("3") || accion.equals("4")) && operaciones == 4) {
				System.out.println("Lo sentimos, pero ya ha realizado el m�ximo de operaciones por sesi�n");
			}
			else if (accion.equals("1")) {
				flag = false;
				while (!flag) {
					System.out.println("Ingrese Monto a depositar y moneda, formato (Currency, Amount)");
					divisa = input.next();
					monto =  input.nextInt();
					if (divisa.equals("CLP")) flag = newUser.depositCLP(monto);
					else if(divisa.equals("USD")) flag= newUser.depositUSD(monto);
				}
				operaciones++;
			}
			else if(accion.equals("2")) {
				flag = false;
				while (!flag) {
					System.out.println("Ingrese monto a retirar y moneda, formato (Currency, Amount)");
					divisa = input.next();
					monto =  input.nextInt();
					if (divisa.equals("CLP")) flag = newUser.withdrawCLP(monto);
					else if(divisa.equals("USD")) flag = newUser.withdrawUSD(monto);
				}
				operaciones++;
			}
			else if(accion.equals("3")) {
				newUser.historial();
			}
			else if(accion.equals("4")) {
				operaciones = 0;
				sesion +=1;
				if (sesion == 3) {
					System.out.println("Se ha cerrado la ultima sesi�n, fin del programa");
					break;
				}
				System.out.println("Se ha cerrado la sesi�n, para volver a iniciar sesi�n presione \"1\"");
				while (!input.next().equals("1")) {
					System.out.println("Ingrese una opci�n valida!");
					System.out.println("Se ha cerrado la sesi�n, para volver a iniciar sesi�n presione \"1\"");					
				}
			}
			else {
				System.out.println("Ingrese una opcion v�lida!");
			}		
		}
		input.close();
	}
}