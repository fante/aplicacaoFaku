package classeNegocio;

import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeDAO.HistoricoDAO;

public class Historico {
	
	private int ra;
	private int idDisciplina;
	private float nota;
	private String situacao;

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public void atualizar() throws ClassNotFoundException, SQLException {
		HistoricoDAO novo = new HistoricoDAO();
		novo.atualizar();
	}

	public void deletar() throws NumberFormatException, HeadlessException, ClassNotFoundException, SQLException {
		HistoricoDAO novo = new HistoricoDAO();
		novo.deletar();
	}

	public void salvar() throws ClassNotFoundException, SQLException {
		ra = Integer.parseInt(JOptionPane.showInputDialog("Digite o ra do aluno"));
		this.setRa(ra);
		idDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da disciplina"));
		this.setIdDisciplina(idDisciplina);
		nota = Float.parseFloat(JOptionPane.showInputDialog("Digite a nota do aluno"));
		this.setNota(nota);
		if (this.getNota()>=6){
			this.setSituacao("Aprovado");
		}
		else{
			this.setSituacao("Reprovado");
		}
		HistoricoDAO novo = new HistoricoDAO();
		novo.salvar(this);
	}

}
