package classeNegocio;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeDAO.CoordenadorDAO;
import classeDAO.FuncionarioDAO;

public class Funcionario {
	
	String nome;
	double salario;
	String horaEntrada;
	String horaSaida;
	int idCargo;

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

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public void atualizar() throws ClassNotFoundException, SQLException {
		FuncionarioDAO novo = new FuncionarioDAO();
		novo.atualizar();
	}

	public void deletar() throws ClassNotFoundException, SQLException {
		FuncionarioDAO novo = new FuncionarioDAO();
		novo.deletar();
	}

	public void salvar() throws ClassNotFoundException, SQLException {
		nome = JOptionPane.showInputDialog("Digite o nome completo do funcion�rio");
		this.setNome(nome);
		idCargo = Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo do cargo do funcion�rio"));
		this.setIdCargo(idCargo);
		salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o sal�rio do funcion�rio"));
		this.setSalario(salario);
		horaEntrada = JOptionPane.showInputDialog("Digite a hora de entrada do funcion�rio");
		this.setHoraEntrada(horaEntrada);
		horaSaida = JOptionPane.showInputDialog("Digite a hora de sa�da do funcion�rio");
		this.setHoraSaida(horaSaida);
		FuncionarioDAO novo = new FuncionarioDAO();
		novo.salvar(this);
	}

}
