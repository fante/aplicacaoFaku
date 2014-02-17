package classeDAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import app.App;
import classeNegocio.Aluno;
import classeNegocio.Turma;

import conexao.Conexao;

public class TurmaDAO implements BaseDAO {

	private int opcao;
	private int id;
	private String var;

	private String sql;
	private PreparedStatement stm;
	private Connection conn;
	private ResultSet rs;


	public TurmaDAO() throws ClassNotFoundException, SQLException{
		conn = new Conexao().conexao();
	}

	@Override
	public void atualizar() throws SQLException, ClassNotFoundException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da turma que quer atualizar"));
		sql = "select * from turma where idTurma="+id;

		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();

		while(rs.next()){
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção que quer atualizar\n1-Código do Curso: "+rs.getInt("curso_idCurso")+"\n2-Período: "+rs.getString("periodo")+"\n3-Ano Letivo: "+rs.getInt("anoLetivo")+"\n4-Semestre Letivo: "+rs.getString("semestreLetivo")+"\n5-Apelido:"+rs.getString("apelido")+"\n5-Identificador da Turma:"+rs.getString("identificador")));
			switch(opcao){
			case 1:
				var = JOptionPane.showInputDialog("Digite o novo código do curso da turma");
				sql = "UPDATE turma set idCurso = '"+var+"' where idTurma="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 2:
				var = JOptionPane.showInputDialog("Digite o novo período da turma");
				sql = "UPDATE turma set periodo = '"+var+"' where ra="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 3:
				var = JOptionPane.showInputDialog("Digite o novo ano da turma");
				sql = "UPDATE turma set anoLetivo = '"+var+"' where idTurma="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 4:
				var = JOptionPane.showInputDialog("Digite o novo apelido da turma");
				sql = "UPDATE turma set apelido = '"+var+"' where idTurma="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 5:
				var = JOptionPane.showInputDialog("Digite o novo semestre da turma");
				sql = "UPDATE turma set semestreLetivo = '"+var+"' where idTurma="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 6:
				var = JOptionPane.showInputDialog("Digite o novo identificador da turma");
				sql = "UPDATE turma set identificador = '"+var+"' where idTurma="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			default: JOptionPane.showMessageDialog(null, "Opção inválida");
			}
		}
		App.main(null);
	}

	@Override
	public void deletar() throws SQLException, NumberFormatException,HeadlessException, ClassNotFoundException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da turma que quer deletar"));
		sql = "delete from turma where idTurma = "+id;
		opcao = JOptionPane.showConfirmDialog(null,"Deseja Realmente excluir a turma "+id+"?","Atencão",JOptionPane.YES_NO_OPTION);    
		if(opcao == JOptionPane.YES_OPTION){   
			stm = conn.prepareStatement(sql);
			stm.execute();
			JOptionPane.showMessageDialog(null, "Turma excluída");
		}
		App.main(null);
	}

	@Override
	public void pesquisar() {

	}

	@Override
	public void salvar(Object turma) throws SQLException, ClassNotFoundException {
		Turma novo = (Turma) turma;
		sql = "insert into turma (curso_IdCurso,periodo,anoLetivo,semestreLetivo,apelido,identificador) values (?,?,?,?,?,?)";

		stm = conn.prepareStatement(sql);
		stm.setInt(1, novo.getIdCurso());
		stm.setString(2, novo.getPeriodo());
		stm.setInt(3, novo.getAnoLetivo());
		stm.setString(4, novo.getSemestreLetivo()+"º");
		stm.setString(5, novo.getApelido());
		stm.setString(6, novo.getSemestreLetivo()+novo.getApelido()+novo.getAnoLetivo());
		stm.execute();

		JOptionPane.showMessageDialog(null, "Turma cadastrada");
		App.main(null);
	}
}
