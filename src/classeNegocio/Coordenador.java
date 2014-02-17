package classeNegocio;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeDAO.AlunoDAO;
import classeDAO.CoordenadorDAO;

public class Coordenador {
	
	private String nome;
	private int idCurso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public void salvar() throws ClassNotFoundException, SQLException {
		nome = JOptionPane.showInputDialog("Digite o nome completo do coordenador");
		this.setNome(nome);
		idCurso = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do curso da disciplina"));
		this.setIdCurso(idCurso);
		CoordenadorDAO novo = new CoordenadorDAO();
		novo.salvar(this);
	}

	public void deletar() throws ClassNotFoundException, SQLException {
		CoordenadorDAO novo = new CoordenadorDAO();
		novo.deletar();
	}

	public void atualizar() throws ClassNotFoundException, SQLException {
		CoordenadorDAO novo = new CoordenadorDAO();
		novo.atualizar();
	}

}
