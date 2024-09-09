package hotelaria.persistencia;

import java.util.List;
import hotelaria.model.Cliente;

public interface ClienteDAO {
	public String inserir(Cliente emp);
	public String alterar(Cliente emp);
	public String excluir(Cliente emp);
	public List<Cliente> listarTodos();
	public Cliente pesquisarPorCodCliente(String codCliente);

}
