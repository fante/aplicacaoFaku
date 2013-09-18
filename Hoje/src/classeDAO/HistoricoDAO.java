package classeDAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexao.Conexao;

import app.App;
import classeNegocio.Historico;
import classeNegocio.Titulo;

public class HistoricoDAO implements BaseDAO {
	
	private int opcao;
	private int id;
	private int id2;
	private int i=1;
	private String var;
	private String disciplinas;

	private String sql;
	private PreparedStatement stm;
	private Connection conn;
	private ResultSet rs;
	
	public HistoricoDAO() throws ClassNotFoundException, SQLException{
		conn = new Conexao().conexao();
	}

	@Override
	public void atualizar() throws SQLException, ClassNotFoundException {
		
	}

	@Override
	public void deletar() throws SQLException, NumberFormatException,HeadlessException, ClassNotFoundException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ra do aluno"));
		sql = "select * from aluno,disciplina, historico where historico.aluno_ra=aluno.ra";
		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção que quer deletar:\n1-Deletar histórico completo\n2-Deletar uma disciplina"));
		switch(opcao){
		case 1:
			sql="delete from historico where aluno_ra = "+id;
			stm = conn.prepareStatement(sql);
			opcao = JOptionPane.showConfirmDialog(null,"Deseja Realmente excluir o histórico do aluno "+id+"?","Atencão",JOptionPane.YES_NO_OPTION);    
			if(opcao == JOptionPane.YES_OPTION){   
				stm = conn.prepareStatement(sql);
				stm.execute();
				JOptionPane.showMessageDialog(null, "Histórico excluído");
			}
			break;
		case 2:
			while (rs.next()){
				disciplinas = i+"-"+rs.getString("disciplina.nome")+"\n";
				disciplinas += disciplinas;
				i++;
			}
			id2=Integer.parseInt(JOptionPane.showInputDialog("Digite o código da disciplina que quer deletar:\n"+disciplinas));
			
			break;
		}
	}

	@Override
	public void pesquisar() {
		
	}

	@Override
	public void salvar(Object historico) throws SQLException, ClassNotFoundException {
		Historico novo = (Historico) historico;
		sql = "insert into historico (aluno_ra,disciplina_idDisciplina,nota,situacao) values (?,?,?,?)";
		
		stm = conn.prepareStatement(sql);
		stm.setInt(1, novo.getRa());
		stm.setInt(2, novo.getIdDisciplina());
		stm.setFloat(3, novo.getNota());
		stm.setString(4, novo.getSituacao());

		stm.execute();
		
		JOptionPane.showMessageDialog(null, "Histórico cadastrado");
		App.main(null);
	}

}
