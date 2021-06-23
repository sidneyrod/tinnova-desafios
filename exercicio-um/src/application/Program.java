package application;

import entities.Votos;

public class Program {

	public static void main(String[] args) {
		
		Votos votos = new Votos();
		
		votos.setTotalEleitores(1000.0);
		votos.setVotosValidos(800.0);
		votos.setVotosBrancos(150.0);
		votos.setVotosNulos(50.0);
		
		System.out.println("Porcentagem de votos válidos: " + votos.percentualVotosValidos(votos.getVotosValidos()) + "%");
		System.out.println("Porcentagem de votos brancos: " + votos.percentualVotosBrancos(votos.getVotosBrancos()) + "%");
		System.out.println("Porcentagem de votos nulos: " + votos.percentualVotosNulos(votos.getVotosNulos()) + "%");
	}
}
