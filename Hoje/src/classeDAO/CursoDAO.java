package classeDAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import app.App;
import classeNegocio.Curso;

import conexao.Conexao;

public class CursoDAO implements BaseDAO{
	
	private int opcao;
	private int id;
	private String var;
	
	private String sql;
	private PreparedStatement stm;
	private Connection conn;
	private ResultSet rs;
	
	public CursoDAO() throws ClassNotFoundException, SQLException{
		conn = new Conexao().conexao();
	}

	@Override
	public void atualizar() throws SQLException, ClassNotFoundException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do curso que quer atualizar"));
		sql = "select * from curso where idCurso="+id;
		
		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();
		
		while(rs.next()){
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção que quer atualizar\n1-Nome: "+rs.getString("nome")));
			switch(opcao){
			case 1:
				var = JOptionPane.showInputDialog("Digite o novo nome do curso");
				sql = "UPDATE curso set nome = '"+var+"' where idcurso="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			}
		}
		App.main(null);
	}

	@Override
	public void deletar() throws SQLException, NumberFormatException,HeadlessException, ClassNotFoundException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do curso que quer deletar"));
		sql = "delete from curso where idcurso = "+id;
		opcao = JOptionPane.showConfirmDialog(null,"Deseja Realmente excluir o curso "+id+"?","Atencão",JOptionPane.YES_NO_OPTION);    
	    if(opcao == JOptionPane.YES_OPTION){   
	          stm = conn.prepareStatement(sql);
	          stm.execute();
	          JOptionPane.showMessageDialog(null, "Curso excluído");
	      }
	    App.main(null);
	}

	@Override
	public void pesquisar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salvar(Object curso) throws SQLException, ClassNotFoundException {
		Curso novo = (Curso) curso;
		sql = "insert into Curso (nome) values (?)";
		
		stm = conn.prepareStatement(sql);
		stm.setString(1, novo.getNome());
		
		stm.execute();
		
		JOptionPane.showMessageDialog(null, "Curso cadastrado");
		App.main(null);
	}

}
