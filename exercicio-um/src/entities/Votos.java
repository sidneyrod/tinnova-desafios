package entities;

public class Votos {
	
	private final static double PORCENTAGEM_TOTAL = 100.0;

	private Double totalEleitores;
	private Double votosValidos;
	private Double votosBrancos;
	private Double votosNulos;
	
	public Votos() {
	}

	public Votos(Double totalEleitores, Double votosValidos, Double votosBrancos, Double votosNulos) {
		this.totalEleitores = totalEleitores;
		this.votosValidos = votosValidos;
		this.votosBrancos = votosBrancos;
		this.votosNulos = votosNulos;
	}

	public Double getTotalEleitores() {
		return totalEleitores;
	}

	public void setTotalEleitores(Double totalEleitores) {
		this.totalEleitores = totalEleitores;
	}

	public Double getVotosValidos() {
		return votosValidos;
	}

	public void setVotosValidos(Double votosValidos) {
		this.votosValidos = votosValidos;
	}

	public Double getVotosBrancos() {
		return votosBrancos;
	}

	public void setVotosBrancos(Double votosBrancos) {
		this.votosBrancos = votosBrancos;
	}

	public Double getVotosNulos() {
		return votosNulos;
	}

	public void setVotosNulos(Double votosNulos) {
		this.votosNulos = votosNulos;
	}
	
	public Double percentualVotosValidos(Double percentual) {
		return (votosValidos * PORCENTAGEM_TOTAL) / totalEleitores;
	}
	
	public Double percentualVotosBrancos(Double percentual) {
		return (votosBrancos * PORCENTAGEM_TOTAL) / totalEleitores;
	}
	
	public Double percentualVotosNulos(Double percentual) {
		return (votosNulos * PORCENTAGEM_TOTAL) / totalEleitores;
	}
}
