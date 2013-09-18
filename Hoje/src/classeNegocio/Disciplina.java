package classeNegocio;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeDAO.DisciplinaDAO;

public class Disciplina {
	
	private String nome;
	private int idCurso;
	private int idProfessor;

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
	
	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public void atualizar() throws ClassNotFoundException, SQLException {
		DisciplinaDAO novo = new DisciplinaDAO();
		novo.atualizar();
	}

	public void salvar() throws ClassNotFoundException, SQLException {
		nome = JOptionPane.showInputDialog("Digite o nome da disciplina");
		this.setNome(nome);
		idCurso = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do curso"));
		this.setIdCurso(idCurso);
		idProfessor = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do professor"));
		this.setIdProfessor(idProfessor);
		DisciplinaDAO novo = new DisciplinaDAO();
		novo.salvar(this);
	}

	public void deletar() throws ClassNotFoundException, SQLException {
		DisciplinaDAO novo = new DisciplinaDAO();
		novo.deletar();
	}

}
