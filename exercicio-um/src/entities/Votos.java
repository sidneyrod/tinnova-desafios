package entities;

public class Votos {

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
	
	public Double percentualVotosValidos(Double quantidade) {
		return (votosValidos * 100) / totalEleitores;
	}
	
	public Double percentualVotosBrancos(Double quantidade) {
		return (votosBrancos * 100) / totalEleitores;
	}
	
	public Double percentualVotosNulos(Double quantidade) {
		return (votosNulos * 100) / totalEleitores;
	}
}