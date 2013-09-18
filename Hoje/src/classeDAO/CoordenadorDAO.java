package classeDAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeNegocio.Aluno;
import classeNegocio.Coordenador;

import conexao.Conexao;

import app.App;

public class CoordenadorDAO implements BaseDAO {
	
	private int opcao;
	private int id;
	private String var;
	
	private String sql;
	private PreparedStatement stm;
	private Connection conn;
	private ResultSet rs;
	
	
	public CoordenadorDAO() throws ClassNotFoundException, SQLException{
		conn = new Conexao().conexao();
	}

	@Override
	public void atualizar() throws SQLException, ClassNotFoundException {
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite a matrícula do coordenador que quer atualizar"));
		sql = "select * from coordenador where idCoordenador="+id;
		
		stm = conn.prepareStatement(sql);
		rs = stm.executeQuery();
		
		while(rs.next()){
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção que quer atualizar\n1-Nome: "+rs.getString("nome")+"\n2-Código do Curso: "+rs.getString("curso_idCurso")));
			switch(opcao){
			case 1:
				var = JOptionPane.showInputDialog("Digite o novo nome do coordenador");
				sql = "UPDATE coordenador set nome = '"+var+"' where idCoordenador="+id;
				System.out.println(sql);
				stm = conn.prepareStatement(sql);
				stm.execute(sql);
				JOptionPane.showMessageDialog(null, "Dado atualizado");
				break;
			case 2:
				var = JOptionPane.showInputDialog("Digite o novo código do curso");
				sql = "UPDATE aluno set coordenador = '"+var+"' where idCoordenador="+id;
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
		id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código a matrícula do coordenador que quer deletar"));
		sql = "delete from coordenador where idCoordenador = "+id;
		opcao = JOptionPane.showConfirmDialog(null,"Deseja Realmente excluir o coordenador"+id+"?","Atencão",JOptionPane.YES_NO_OPTION);    
        if(opcao == JOptionPane.YES_OPTION){   
              stm = conn.prepareStatement(sql);
              stm.execute();
              JOptionPane.showMessageDialog(null, "Coordenador excluído");
          }
        App.main(null);
	}

	@Override
	public void pesquisar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salvar(Object coordenador) throws SQLException, ClassNotFoundException {
		Coordenador novo = (Coordenador) coordenador;
		sql = "insert into coordenador (nome,curso_IdCurso) values (?,?)";
		
		stm = conn.prepareStatement(sql);
		stm.setString(1, novo.getNome());
		stm.setInt(2, novo.getIdCurso());
		stm.execute();
		
		JOptionPane.showMessageDialog(null, "Coordenador cadastrado");
		App.main(null);
	}

}
