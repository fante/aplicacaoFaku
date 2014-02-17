package classeDAO;

import java.awt.HeadlessException;
import java.sql.SQLException;

import classeNegocio.Aluno;

public interface BaseDAO {
	
	public void atualizar() throws SQLException, ClassNotFoundException;
	
	public void deletar() throws SQLException, NumberFormatException, HeadlessException, ClassNotFoundException;
	
	public void pesquisar() throws SQLException, ClassNotFoundException;

	public void salvar(Object novo) throws SQLException, ClassNotFoundException;
	
}
