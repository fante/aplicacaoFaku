package classeNegocio;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeDAO.ProfessorDAO;

public class Professor {
	
	private String nome;
	private double salario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void salvar() throws ClassNotFoundException, SQLException {
		nome = JOptionPane.showInputDialog("Digite o nome completo do professor");
		this.setNome(nome);
		salario = Double.parseDouble(JOptionPane.showInputDialog("Digite a salário do professor"));
		this.setSalario(salario);
		ProfessorDAO novo = new ProfessorDAO();
		novo.salvar(this);
	}

	public void deletar() throws ClassNotFoundException, SQLException {
		ProfessorDAO novo = new ProfessorDAO();
		novo.deletar();
	}

	public void atualizar() throws ClassNotFoundException, SQLException {
		ProfessorDAO novo = new ProfessorDAO();
		novo.atualizar();
	}

}
