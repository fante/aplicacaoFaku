package classeNegocio;

import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeDAO.TurmaDAO;

public class Turma {
	
	private String semestreLetivo;
	private String apelido;
	private String identificador;
	private String periodo;
	private int idCurso;
	private int anoLetivo;

	public String getSemestreLetivo() {
		return semestreLetivo;
	}

	public void setSemestreLetivo(String semestreLetivo) {
		this.semestreLetivo = semestreLetivo;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public void atualizar() throws ClassNotFoundException, SQLException {
		TurmaDAO novo = new TurmaDAO();
		novo.atualizar();
	}

	public void deletar() throws NumberFormatException, HeadlessException, ClassNotFoundException, SQLException {
		TurmaDAO novo = new TurmaDAO();
		novo.deletar();
	}

	public void salvar() throws ClassNotFoundException, SQLException {
		idCurso = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do curso da turma"));
		this.setIdCurso(idCurso);
		periodo = JOptionPane.showInputDialog("Digite o período da turma");
		this.setPeriodo(periodo);
		semestreLetivo = JOptionPane.showInputDialog("Digite o semestre da turma");
		this.setSemestreLetivo(semestreLetivo);
		apelido = JOptionPane.showInputDialog("Digite o apelido da turma");
		anoLetivo = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano da turma"));
		this.setAnoLetivo(anoLetivo);
		TurmaDAO novo = new TurmaDAO();
		novo.salvar(this);
	}

}
