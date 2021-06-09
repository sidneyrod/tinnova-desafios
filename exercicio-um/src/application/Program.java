package application;

import entities.Votos;

public class Program {

	public static void main(String[] args) {
		
		double totalEleitores = 1000;
		double votosValidos = 800;
		double votosBrancos = 150;
		double votosNulos = 50;
		
		Votos votos = new Votos(totalEleitores, votosValidos, votosBrancos, votosNulos);
		
		System.out.println("Porcentagem de votos válidos: " + votos.percentualVotosValidos(votosValidos) + "%");
		System.out.println("Porcentagem de votos brancos: " + votos.percentualVotosBrancos(votosBrancos) + "%");
		System.out.println("Porcentagem de votos nulos: " + votos.percentualVotosNulos(votosNulos) + "%");
	}
}