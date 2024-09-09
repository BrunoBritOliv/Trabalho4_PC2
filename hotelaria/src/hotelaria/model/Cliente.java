package hotelaria.model;

import java.sql.Date;

public class Cliente {
	private Integer codCliente;
	private String nomeCliente;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String rgCliente;
	private Date nascCliente;
	private String cepCliente;
	
	
	public Cliente() {
		
	}
	
	public Cliente(int codigo, String nome, String rg, String endereco, String bairro, String cidade, String estado, Date nascimento) {		
		this.codCliente = codigo;
		this.nomeCliente = nome;
		this.rgCliente = rg;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.nascCliente = nascimento;
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRgCliente() {
		return rgCliente;
	}

	public void setRgCliente(String rgCliente) {
		this.rgCliente = rgCliente;
	}

	public Date getNascCliente() {
		return nascCliente;
	}

	public void setNascCliente(Date nascCliente) {
		this.nascCliente = nascCliente;
	}

	public String getCepCliente() {
		return cepCliente;
	}

	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}

}
