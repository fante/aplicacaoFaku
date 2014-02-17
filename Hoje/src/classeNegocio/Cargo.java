package classeNegocio;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeDAO.CargoDAO;
import classeDAO.TituloDAO;

public class Cargo {
	
	private String nome;
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void salvar() throws ClassNotFoundException, SQLException {
		nome = JOptionPane.showInputDialog("Digite o nome do cargo");
		this.setNome(nome);
		descricao = JOptionPane.showInputDialog("Digite a descrição do cargo");
		this.setDescricao(descricao);
		CargoDAO novo = new CargoDAO();
		novo.salvar(this);
	}

	public void deletar() throws ClassNotFoundException, SQLException {
		CargoDAO novo = new CargoDAO();
		novo.deletar();
	}

	public void atualizar() throws ClassNotFoundException, SQLException {
		CargoDAO novo = new CargoDAO();
		novo.atualizar();
	}
	
}
