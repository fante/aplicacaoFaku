package classeNegocio;

import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import app.App;

import classeDAO.TituloDAO;

public class Titulo {
	
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

	public void atualizar() throws ClassNotFoundException, SQLException {
		TituloDAO novo = new TituloDAO();
		novo.atualizar();
	}

	public void deletar() throws NumberFormatException, HeadlessException, ClassNotFoundException, SQLException {
		TituloDAO novo = new TituloDAO();
		novo.deletar();
	}

	public void salvar() throws ClassNotFoundException, SQLException {
			nome = JOptionPane.showInputDialog("Digite o nome do título");
			this.setNome(nome);
			descricao = JOptionPane.showInputDialog("Digite a descrição do título");
			this.setDescricao(descricao);
			TituloDAO novo = new TituloDAO();
			novo.salvar(this);
		}
	}
