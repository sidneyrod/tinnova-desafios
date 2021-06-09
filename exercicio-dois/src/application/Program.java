package application;

public class Program {

	public static void main(String[] args) {

		int vetor[] = { 5, 3, 2, 4, 7, 1, 0, 6 };
		int troca;
		boolean controlador;

		for (int i = 0; i < vetor.length; i++) {
			controlador = true;
			for (int j = 0; j < (vetor.length - 1); j++) {
				if (vetor[j] > vetor[j + 1]) {
					troca = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = troca;
					controlador = false;
				}
			}
			if (controlador = true) {
				break;
			}
		}

		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}

	}
}