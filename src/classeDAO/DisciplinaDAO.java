package classeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import app.App;

import conexao.Conexao;

import classeNegocio.Curso;
import classeNegocio.Disciplina;

public class DisciplinaDAO {
	
	private int opcao;
	private int id;
	private String var;
	
	private String sql;
	private PreparedStatement stm;
	private Connection conn;
	private ResultSet rs;
	
	public DisciplinaDAO() throws ClassNotFoundException, SQLException{
		conn = new Conexao().conexao();
	}

	public void salvar(Disciplina disciplina) throws SQLException, ClassNotFoundException {
		Disciplina novo = (Disciplina) disciplina;
		sql = "insert into Disciplina (nome,curso_idCurso,professor_idProfessor) values (?,?,?)";
		
		stm = conn.prepareStatement(sql);
		stm.setString(1, novo.getNome());
		stm.setInt(2, novo.getIdCurso());
		stm.setInt(3, novo.getIdProfessor());
		
		stm.execute();
		
		JOptionPane.showMessageDialog(null, "Disciplina cadastrada");
		App.main(null);
	}

	public void atualizar() throws SQLException, ClassNotFoundException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da disciplina que quer atualizar"));
		sql = "select * from disciplina where idDisciplina="+id;
		
		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();
		
		while(rs.next()){
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção que quer atualizar\n1-Nome: "+rs.getString("nome")+"\n2-Código da turma: "+rs.getInt("curso_idCurso")));
			switch(opcao){
			case 1:
				var = JOptionPane.showInputDialog("Digite o novo nome da disciplina");
				sql = "UPDATE disciplina set nome = '"+var+"' where idDisciplina="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			}
		}
		App.main(null);
	}

	public void deletar() throws SQLException, ClassNotFoundException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da disciplina que quer deletar"));
		sql = "delete from disciplina where idcurso = "+id;
		opcao = JOptionPane.showConfirmDialog(null,"Deseja Realmente excluir a disciplina "+id+"?","Atencão",JOptionPane.YES_NO_OPTION);    
	    if(opcao == JOptionPane.YES_OPTION){   
	          stm = conn.prepareStatement(sql);
	          stm.execute();
	          JOptionPane.showMessageDialog(null, "Disciplina excluído");
	      }
	    App.main(null);
	}
	
}
