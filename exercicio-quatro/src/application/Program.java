package application;

import entities.SomaDosMultiplos;

public class Program {

	public static void main(String[] args) {
		
		int numero = 10;
		
		SomaDosMultiplos sm = new SomaDosMultiplos();
		
		System.out.println("A soma dos multiplos de 3 e 5 é " + sm.somaDosMultiplos(numero));		
	}
}