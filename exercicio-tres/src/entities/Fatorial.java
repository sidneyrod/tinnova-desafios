package entities;

public class Fatorial {

	public int calculoFatorial(int numero) {
		int fatorial = 1;
		for (int i = 1; i <= numero; i++) {
			fatorial *= i;
		}
		return fatorial;
	}  
}