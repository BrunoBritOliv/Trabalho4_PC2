package hotelaria.model;

public class Chale {
	private Integer codChale;
	private String localizacao;
	private Integer capacidade;
	private Double valorBaixaEstacao;
	private Double valorAltaEstacao;
	
	
	public Chale() {};
	
	public Chale(int codigo, String local, int capacidade, double valorBaixa, double valorAlta) {
		this.codChale = codigo;
		this.localizacao = local;
		this.capacidade = capacidade;
		this.valorBaixaEstacao = valorBaixa;
		this.valorAltaEstacao = valorAlta;
	}

	public Integer getCodChale() {
		return codChale;
	}

	public void setCodChale(Integer codChale) {
		this.codChale = codChale;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Double getValorBaixaEstacao() {
		return valorBaixaEstacao;
	}

	public void setValorBaixaEstacao(Double valorBaixaEstacao) {
		this.valorBaixaEstacao = valorBaixaEstacao;
	}

	public Double getValorAltaEstacao() {
		return valorAltaEstacao;
	}

	public void setValorAltaEstacao(Double valorAltaEstacao) {
		this.valorAltaEstacao = valorAltaEstacao;
	}

}
