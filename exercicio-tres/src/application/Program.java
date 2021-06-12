package application;

import entities.Fatorial;

public class Program {

	public static void main(String[] args) {
		
		int numero1 = 0;
		int numero2 = 1;
		int numero3 = 2;
		int numero4 = 3;
		int numero5 = 4;
		int numero6 = 5;
		int numero7 = 6;
		Fatorial f = new Fatorial();
		
		System.out.println(numero1 + "! = " + f.calculoFatorial(numero1));
		System.out.println(numero2 + "! = " + f.calculoFatorial(numero2));
		System.out.println(numero3 + "! = " + f.calculoFatorial(numero3));
		System.out.println(numero4 + "! = " + f.calculoFatorial(numero4));
		System.out.println(numero5 + "! = " + f.calculoFatorial(numero5));
		System.out.println(numero6 + "! = " + f.calculoFatorial(numero6));
		System.out.println(numero6 + "! = " + f.calculoFatorial(numero7));
	}
}
