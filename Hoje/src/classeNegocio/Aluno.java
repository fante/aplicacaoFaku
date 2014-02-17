package classeNegocio;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeDAO.AlunoDAO;

public class Aluno {
	
	private String nome;
	private String email;
	private String dataMatricula;
	private int idade;
	private int turma;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getTurma() {
		return turma;
	}

	public void setTurma(int turma) {
		this.turma = turma;
	}

	public void salvar() throws ClassNotFoundException, SQLException {
		nome = JOptionPane.showInputDialog("Digite o nome completo do aluno");
		this.setNome(nome);
		email = JOptionPane.showInputDialog("Digite o e-mail do aluno");
		this.setEmail(email);
		idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno"));
		this.setIdade(idade);
		dataMatricula = JOptionPane.showInputDialog("Digite a data de matricula do aluno");
		this.setDataMatricula(dataMatricula);
		turma = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da turma do aluno"));
		this.setTurma(turma);
		AlunoDAO novo = new AlunoDAO();
		novo.salvar(this);
	}

	public void atualizar() throws ClassNotFoundException, SQLException {
		AlunoDAO novo = new AlunoDAO();
		novo.atualizar();
	}

	public void deletar() throws ClassNotFoundException, SQLException {
		AlunoDAO novo = new AlunoDAO();
		novo.deletar();
	}

	public void pesquisar() {
		
	}
}
