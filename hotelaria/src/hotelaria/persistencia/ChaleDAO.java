package hotelaria.persistencia;

import java.util.List;
import hotelaria.model.Chale;

public interface ChaleDAO {
	public String inserir(Chale emp);
	public String alterar(Chale emp);
	public String excluir(Chale emp);
	public List<Chale> listarTodos();
	public Chale pesquisarPorCodCliente(String codChale);

}
