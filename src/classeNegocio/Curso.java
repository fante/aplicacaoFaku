package classeNegocio;

import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeDAO.CursoDAO;

public class Curso {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void salvar() throws ClassNotFoundException, SQLException {
		nome = JOptionPane.showInputDialog("Digite o nome completo do aluno");
		this.setNome(nome);
		CursoDAO novo = new CursoDAO();
		novo.salvar(this);
	}

	public void deletar() throws NumberFormatException, HeadlessException, ClassNotFoundException, SQLException {
		CursoDAO novo = new CursoDAO();
		novo.deletar();
	}

	public void atualizar() throws ClassNotFoundException, SQLException {
		CursoDAO novo = new CursoDAO();
		novo.atualizar();
	}
}
