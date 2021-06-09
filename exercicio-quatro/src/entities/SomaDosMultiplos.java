package entities;

public class SomaDosMultiplos {

	public int somaDosMultiplos(int numero) {
		int soma = 0;
		for (int i = 3; i < numero; i += 3) {
			soma += i;
		}
		for (int i = 5; i < numero; i += 5) {
			if (i % 3 != 0) {
				soma += i;
			}
		}
		return soma;
	}
}